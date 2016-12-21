import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Should be run at around 500x300 pixels.<br>
 * <br>
 * 
 * @version Dec. 2016
 * 
 * @author Ajay Gurdat adapted from Christina Kemp adapted from Sam Scott
 */
@SuppressWarnings("serial")
public class Dodgeball extends JPanel implements Runnable, MouseMotionListener {

	int x = -1, y = -1;
	int width = 500;
	int height = 300;

	/**
	 * The number of balls on the screen.
	 */
	final int numBalls = 50;
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
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new Dodgeball());
		frame.pack();

	}

	public void init() {
		addMouseMotionListener(this);
	}

	public Dodgeball() {
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
	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
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

	@Override
	public void mouseDragged(MouseEvent e) {
		filled = true;
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		filled = false;
		x = e.getX();
		y = e.getY();
		repaint();
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
				return true;
			}
		}
		return false;
	}

}
