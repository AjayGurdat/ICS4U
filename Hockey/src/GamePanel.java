import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the beginning of a simple game. You should expand it into a dodgeball
 * game, where the user controls an object with the mouse or keyboard, and tries
 * to avoid the balls flying around the screen. If they get hit, it's game over.
 * If they survive for 20 seconds (or some other fixed time), they go on to the
 * next level. <br>
 * <br>
 * Should be run at around 500x300 pixels.<br>
 * <br>
 * 
 * @version Nov. 2015
 * 
 * @author Christina Kemp adapted from Sam Scott
 */

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, MouseMotionListener, MouseListener {

	int levelRadius = 10;
	int level = 0;
	int distanceBetweenLevels = 20;
	int nextLevelTime = 1;
	int time = 0;
	
	
	boolean alive;
	boolean dieByBall = false;
	int x = -1, y = -1;
	static int width = 1280;
	static int height = 700;

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

	boolean filled = false;

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

		Thread gameThread = new Thread(this);
		gameThread.start();
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

	}

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

	@Override
	public void mouseDragged(MouseEvent e) {
		boolean space = hitBoxCheck(e);
		if (space == true) {
			doRun();
		} else if (space == false) {
			alive = false;
			dieByBall = true;
			System.out.println("You got hit!");
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		boolean space = hitBoxCheck(e);
		if (space == true) {
			doRun();
		} else if (space == false) {
			alive = false;
			dieByBall = true;
			System.out.println("You got hit!");
		}
	}

	public void doRun() {
		if (alive == true) {
			run();
			time++;
			if (time == nextLevelTime) {
				level++;
				nextLevelTime = nextLevelTime + distanceBetweenLevels;
				levelRadius++;
				for (int i = 0; i < numBalls; i++){
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

	@Override
	public void mouseEntered(MouseEvent e) {
		if (dieByBall == false) {
			alive = true;
		}
		System.out.println("Entered");
	}

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
