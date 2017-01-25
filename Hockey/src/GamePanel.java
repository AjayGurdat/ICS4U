import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A simple game where the objective is the survive for as long as possible my
 * moving the mouse to not hit any of the balls on the screen. <br>
 * <br>
 * The mouse MUST BE CONSTANTLY MOVED for the program to continue to update what
 * is on the screen. <br>
 * 
 * @version Dec. 2019
 * 
 * @author Ajay Gurdat adapted from Christina Kemp adapted from Sam Scott
 */

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, MouseMotionListener, MouseListener {

	/**
	 * The current radius of the ball for a level.
	 */
	int levelRadius = 10;
	/**
	 * The current level.
	 */
	int level = 0;
	/**
	 * The time it takes to move onto the next level.
	 */
	int distanceBetweenLevels = 20;
	/**
	 * Time remaining until the next level.
	 */
	int nextLevelTime = 1;
	/**
	 * Current time alive.
	 */
	int time = 0;
	/**
	 * If the player is alive.
	 */
	boolean alive;
	/**
	 * If they player died form hitting a ball.
	 */
	boolean dieByBall = false;
	/**
	 * Initial starting positions for the mouse.
	 */
	int x = -1, y = -1;
	/**
	 * Width of the JPanel
	 */
	static int width = 1280;
	/**
	 * Height of the JPanel.
	 */
	static int height = 900;
	/**
	 * The number of balls on the screen.
	 */
	int numBalls = 20;
	/**
	 * The pause between repainting (should be set for about 30 frames per
	 * second).
	 */
	final int pauseDuration = 50;
	/**
	 * An array of balls.
	 */
	FlashingBall[] ball = new FlashingBall[numBalls];

	/** main program (entry point) */
	public static void main(String[] args) {
		// Set up main window (using Swing's Jframe)
		JFrame frame = new JFrame("Dodgeball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(width, height));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new GamePanel());
		frame.pack();

	}

	/**
	 * Sets up the JPanel for the game to run in
	 */
	public GamePanel() {
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.WHITE);

		for (int i = 0; i < numBalls; i++) {
			ball[i] = new FlashingBall(50, 50, 0, width, 0, height);
			ball[i].setXSpeed(Math.random() * 16 - 8);
			ball[i].setYSpeed(Math.random() * 16 - 8);
			ball[i].setColor(
					new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
		}
		// Creates the thread that the balls will run in
		Thread gameThread = new Thread(this);
		gameThread.start();
		// Starts the MouseMotionListener and MouseListener
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		repaint();
		try {
			Thread.sleep(pauseDuration);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < numBalls; i++) {
			ball[i].draw(g);
		}
		if (alive != false) {
			g.setColor(new Color(0, 0, 0));
		} else {
			g.setColor(new Color(255, 255, 255));
			g.setFont(new Font("TimesRoman", Font.ITALIC, 60));
			g.drawString("YOU ARE DEAD!!!", 410, 450);
			g.drawString("Level: " + level, 10, 50);
			g.drawString("Points/Time: " + time, 10, 150);
			return;
		}
		g.drawString("Level: " + level, 10, 20);
		g.drawString("Points/Time: " + time, 10, 40);

	}

	/**
	 * Checks if the mouse in within the radius of all of the balls, will return
	 * false if the mouse had been hit, otherwise returns true
	 * 
	 * @param e
	 *            The mouse event
	 * @return
	 */
	public boolean hitBoxCheck(MouseEvent e) {
		for (int i = 0; i < numBalls; i++) {
			double ballPositionX = ball[i].getX();
			double mousePositionX = e.getX();
			double ballPositionY = ball[i].getY();
			double mousePositionY = e.getY();
			double xLine = ballPositionX - mousePositionX;
			double yLine = ballPositionY - mousePositionY;
			double distance = Math.sqrt(Math.pow(xLine, 2) + Math.pow(yLine, 2));
			if (distance <= ball[i].getRadius()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Runs if the mouse had been dragged.<br>
	 * Tests if the mouse had been hit, if the mouse was hit, changed the
	 * background and all of the balls color
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		boolean space = hitBoxCheck(e);
		if (space == true) {
			doRun();
		} else if (space == false) {
			alive = false;
			dieByBall = true;
			System.out.println("You got hit!");
			// Sets the background to black
			this.setBackground(Color.RED);
			// Sets all of the balls color to black
			for (int i = 0; i < numBalls; i++) {
				ball[i].setColor(new Color(0, 0, 0));
			}
		}
	}

	/**
	 * Runs if the mouse had been dragged.<br>
	 * Tests if the mouse had been hit, if the mouse was hit, changed the
	 * background and all of the balls color
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		boolean space = hitBoxCheck(e);
		if (space == true) {
			doRun();
		} else if (space == false) {
			alive = false;
			dieByBall = true;
			System.out.println("You got hit!");
			// Sets the background to black
			this.setBackground(Color.RED);
			// Sets all of the balls color to black
			for (int i = 0; i < numBalls; i++) {
				ball[i].setColor(new Color(0, 0, 0));
			}
		}
	}

	/**
	 * Tests to see if the player qualifies to move onto the next level, if yes,
	 * increases all of the balls radius and sets a new goal for the next level
	 */
	public void doRun() {
		if (alive == true) {
			run();
			time++;
			if (time == nextLevelTime) {
				level++;
				nextLevelTime = nextLevelTime + distanceBetweenLevels;
				levelRadius++;
				// Increases the radius of all od the balls
				for (int i = 0; i < numBalls; i++) {
					ball[i].setRadius(levelRadius);
					ball[i].setRadius(levelRadius);
				}
				if (level == 1) {
					System.out.println("LEVEL 1! Good Luck!");
				} else {
					System.out.println("NEXT LEVEL - LEVEL " + level + "!");
				}
			}

		} else {
			System.out.println("You are dead!");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * If the player was killed by the ball, the player will stay dead,
	 * otherwise, revives the player
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if (dieByBall == false) {
			alive = true;
		}
		System.out.println("Entered");
	}

	/**
	 * Kills the player when the player exits the JPanel
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		alive = false;
		System.out.println("Exited");
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}