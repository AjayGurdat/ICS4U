public class Puck extends Disk {

	public Puck(double r, double t) {
		super(r, t);
	}
	private double weight;
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
	
	public void setWeight(double newWeight) {
		weight = newWeight;
	}
	
	public double getWeight(){
		return(weight);
	}
	
	public boolean equals(Puck p) {
		Puck testObj = (Puck) p;

		if (testObj.getRadius() == super.getRadius() && testObj.getThickness() == super.getThickness() && testObj.getWeight() == weight) {
			return (true);
		} else {
			return (false);
		}
	}
	public String toString(){
		String puckString;
		
		puckString = "The puck has radius " + super.getRadius() + ", thickness " + super.getThickness() + " and weight " + weight + ".";
		return(puckString);
	}
}