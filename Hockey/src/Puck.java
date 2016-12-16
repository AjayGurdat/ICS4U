/**
 * @author 323016139 - Ajay Gurdat
 * 
 * 15/12/2016
 * 
 * Puck class
 */
public class Puck extends Disk {
	/**
	 * constructor A Puck object has been created with radius r and thickness t
	 * 
	 * @param r
	 * @param t
	 */
	public Puck(double r, double t) {
		super(r, t);
	}

	private double weight;

	/**
	 * This method gets the weight of the puck by the user's input, then
	 * determines if the puck qualifies for the standard division or the youth
	 * division
	 * 
	 * @param weight
	 * @return A string that states what divison the puck is from
	 */
	public String getDivision(double weight) {
		boolean standard;
		boolean youth;
		String divisionInfo;
		if (weight >= 5.0 && weight <= 5.5) {
			standard = true;
			youth = false;
		} else if (weight >= 4.0 && weight <= 4.5) {
			youth = true;
			standard = false;
		} else {
			standard = false;
			youth = false;
		}
		if (standard == true && youth == false) {
			divisionInfo = "You puck is in the standard division.";
		} else if (standard == false && youth == true) {
			divisionInfo = "You puck is in the youth division.";
		} else if (standard == false && youth == false) {
			divisionInfo = "Your puck doesn't qualify for any divisions.";
		} else {
			divisionInfo = "An error has occured (line 28, Puck.java)";
		}
		return divisionInfo;
	}

	/**
	 * This method sets the weight of the this object
	 * 
	 * @param newWeight
	 */
	public void setWeight(double newWeight) {
		weight = newWeight;
	}

	/**
	 * This method returns the weight of this object
	 * 
	 * @return
	 */
	public double getWeight() {
		return (weight);
	}
/**
 * Determines if the object is equal to another Puck object
 * 	Tests to see if the radius, thickness, and weight of the objects are equal, true if equal, otherwise false
 * @param p
 * @return
 */
	public boolean equals(Puck p) {
		Puck testObj = (Puck) p;

		if (testObj.getRadius() == super.getRadius() && testObj.getThickness() == super.getThickness()
				&& testObj.getWeight() == weight) {
			return (true);
		} else {
			return (false);
		}
	}
/**
 * Returns a String that represents the Puck object
 * 	Shows the radius, thickness, and weight of the puck object
 */
	public String toString() {
		String puckString;

		puckString = "The puck has radius " + super.getRadius() + ", thickness " + super.getThickness() + " and weight "
				+ weight + ".";
		return (puckString);
	}
}