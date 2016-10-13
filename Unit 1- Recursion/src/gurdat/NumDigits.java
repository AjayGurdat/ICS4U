/**
 * 
 */
package gurdat;

import java.util.Scanner;

/**
 * @author 323016139
 *
 */
public class NumDigits {

	public static void main(String[] args) {
		
		System.out.print("Enter a number: ");
		int num;
		@SuppressWarnings("resource")
		Scanner user_input = new Scanner(System.in);
		num = user_input.nextInt();
		int counter = 0;
		
		while (num != 0); {
			if (num > 10); {
				counter++;
				num  = num / 10;
			}
		}
		counter++;
		System.out.println("Your number has " + counter + " digit(s).");	
	}
}
