import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Dodgeball extends GamePanel implements MouseMotionListener {
	private static final long serialVersionUID = 1L;
	
	final int pauseDuration = 50;
	static int width = 500;
	static int height = 300;
	final int numBalls = 5;
	int x = -1, y = -1;
	FlashingBall[] ball = new FlashingBall[numBalls];

	public static void main(String[] args) {
		JFrame frame = new JFrame("Dodgeball new");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(width, height));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new GamePanel());
		frame.pack();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = super.getX();
		y = super.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = super.getX();
		y = super.getY();
	}
}
