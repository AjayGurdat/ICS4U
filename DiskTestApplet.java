/**
 * This applet tests the FlyingDisk class. October 11, 2007.
 * <applet code="ConnectFour.class" width="500" height="350"></applet>
 * @author Sam Scott
 **/
import javax.swing.JApplet;
import java.awt.Color;
import java.awt.Graphics;

public class DiskTestApplet extends JApplet
{
	FlyingDisk theDisk;

	/**
	 * Creates a new disk and sets its position, radius, and colour
	 **/
	public void init ()
	{
		theDisk = new FlyingDisk ();
		theDisk.setRadius (30);
		theDisk.setPosition (100, 65);
		theDisk.setColor (Color.yellow);
	} // init method


	/**
	 * Draws the disk on the applet along with a basic landscape
	 * @param Graphics g The graphics object to draw on.
	 **/
	public void paint (Graphics g)
	{
		setBackground (Color.black);
		g.setColor (new Color (0, 128, 0));
		g.fillRect (0, getHeight () * 3 / 4, getWidth (), getHeight () / 4);
		//theDisk.setRadius ((int) (Math.random () * 50 + 20));
		theDisk.draw (g);
	}
}
