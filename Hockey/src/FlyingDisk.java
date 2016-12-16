/**
 * Code for a simple visual object that can display itself on an applet.
 * October 11, 2007
 * @author Sam Scott
 **/
import java.awt.Color;
import java.awt.Graphics;

public class FlyingDisk
{
	int x, y; // position of the disk's centre
	int radius; // radius of the disk
	Color color; // color of the disk

	/**
	 * Creates the default FlyingDisk
	 **/
	public FlyingDisk ()
	{
		x = 100;
		y = 100;
		radius = 10;
		color = Color.black;
	}


	/**
	 * Set disk position
	 * @param newX X coordinate of disk centre
	 * @param newY Y coordinate of disk centre
	 **/
	void setPosition (int newX, int newY)
	{
		x = newX;
		y = newY;
	}


	/**
	 * Sets the disk's radius
	 * @param newRadius The new Radius
	 **/
	void setRadius (int newRadius)
	{
		radius = newRadius;
	}


	/**
	 * Sets the disk color
	 * @param newColor The new color
	 **/
	void setColor (Color newColor)
	{
		color = newColor;
	}


	/**
	 * Draws the disk on a Graphics object
	 * @param g The Graphics object to draw on
	 **/
	void draw (Graphics g)
	{
		int drawX = x - radius;
		int drawY = y - radius;

		g.setColor (color);
		for (int i = 0 ; i < radius / 4.0 + 0.5 ; i++)
			g.drawOval (drawX + i, drawY + i, radius * 2 - i * 2, radius * 2 - i * 2);

		int halfRadius = (int) (radius / 2.0 + 0.5);
		int quarterRadius = (int) (radius / 4.0 + 0.5);

		g.fillOval (drawX, drawY, halfRadius, halfRadius);
		g.fillOval (drawX + 2 * radius - halfRadius, drawY, halfRadius, halfRadius);
		g.fillOval (drawX, drawY + 2 * radius - halfRadius, halfRadius, halfRadius);
		g.fillOval (drawX + 2 * radius - halfRadius, drawY + 2 * radius - halfRadius, halfRadius, halfRadius);

	}
}
