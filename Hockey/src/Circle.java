/**
 * Circle.java
 *
 */
public class Circle implements Comparable<Circle>{
	private static final double PI = 3.14;
	private double radius;
	
	/**
	 * constructor
	 * pre: none
	 * post: A Circle object created. Radius initialized to 1.
	 */
	public Circle() {
		setRadius(1);		//default radius
	}
	
	/**
	 * constructor
	 * pre: An integer value r
	 * post: A Circle object created with radius r
	 * @param r
	 */
	public Circle(int r) {
		setRadius(r);		
	}

	/**
	 * Gets the radius of the current circle
	 * @return
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Sets the radius of the current circle
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Determine if object c is the same as this Circle object.
	 * @param c
	 * @return
	 */
	public boolean equals(Circle c) {
		if (radius == c.getRadius())
			return true;
		else
			return false;
	}
	/**
	 * Determine if object c is smaller, the same, or larger than
	 * this Circle object.
	 * pre: c is a Circle object
	 * post: -1 has been returned if c is larger than this circle,
	 *  0 has been returned if they are the same size, and 1 has been returned 
	 *  if c is smaller than this Circle.
	 * @param c
	 * @return
	 */
	public int compareTo(Circle c) {
		
		if (radius < c.getRadius())
			return -1;
		else if (radius == c.getRadius())
			return 0;
		else
			return 1;
	}

	public double area() {
		double area = PI * Math.pow(radius, 2);
		return area;
	}

}