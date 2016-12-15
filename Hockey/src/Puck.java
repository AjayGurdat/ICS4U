
public class Puck extends Disk {

	public Puck(double r, double t) {
		super(r, t);
	}

	public boolean standard(double weight) {
		boolean answer = false;
		if (weight <= 5.5 && weight >= 5.0) {
			answer = true;
		} else {
			answer = false;
		}
		return answer;

	}

	public boolean youth(double weight) {
		boolean answer = false;
		if (weight <= 4.5 && weight >= 4.0) {
			answer = true;
		} else {
			answer = false;
		}
		return answer;
	}
	
}
