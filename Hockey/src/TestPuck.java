import java.util.Scanner;

public class TestPuck {
	private static Scanner scan;

	public static void main(String[] args) {
		Puck puck1 = new Puck(10, 0.02);
		System.out.println("What is the weight of the puck? (in ounces)");
		scan = new Scanner(System.in);
		puck1.setWeight(scan.nextDouble());
		System.out.println(puck1.getDivision(puck1.getWeight()));
		
		Puck puck2 = new Puck(10, 0.02);
		System.out.println("What is the weight of the puck? (in ounces)");
		scan = new Scanner(System.in);
		puck2.setWeight(scan.nextDouble());
		System.out.println(puck2.getDivision(puck2.getWeight()));
		
		if (puck1.equals(puck2)){
			System.out.println("Objects are equal.");
		} else {
			System.out.println("Objects are not equal.");
		}
		
		System.out.println(puck1);
		System.out.println(puck2);
	}
}
