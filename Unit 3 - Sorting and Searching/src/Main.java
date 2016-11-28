import java.util.Scanner;

/**
 * @author 323016139 Ajay Gurdat 010/11/2016 - 22/11/2016 Main
 */
public class Main {
	private static Scanner scan;

	/**
	 * @param args
	 *            Main method with arrays that send the arrays to other methods
	 */
	public static void main(String[] args) {
		// creates arrays to be searched and/or sorted in different methods
		String[] words = { "Apple", "Case", "Pen", "Clock", "Mouse", "Bird", "Light", "Food", "Foot", "Cat", "Movie",
				"School" };
		double[] doubleNumbers = { 7.4, 3.1, 22.6, 1.5, 6.1, 8.7, 4.2, 0, 5.4, 10.1, 9.8, -0.2 };
		int[] intNumbers = { 7, 3, 2, 1, 14, 6, 8, 4, 0, 5, 10, 9, 12, -4 };
		System.out.println("What do you want to do?");
		System.out.println("1. Sort the list");
		System.out.println("2. Search the list");
		scan = new Scanner(System.in);
		int mainOption = scan.nextInt();
		if (mainOption == 1) {
			System.out.println("What type of list do you want sorted?");
			System.out.println("1. Integer");
			System.out.println("2. Double");
			System.out.println("3. String");
			scan = new Scanner(System.in);
			int prefList = scan.nextInt();
			switch (prefList) {
			case 1:
				// calls sort method for integers
				Sort.sortInt(intNumbers);
				break;
			case 2:
				// calls sort method for doubles
				Sort.sortDouble(doubleNumbers);
				break;
			case 3:
				// calls sort method for strings
				Sort.sortString(words);
				break;
			}
		} else if (mainOption == 2) {
			System.out.println("Which array would you like to use?");
			System.out.println("1. Integer");
			System.out.println("2. Double");
			System.out.println("3. String");
			scan = new Scanner(System.in);
			int prefSearch = scan.nextInt();
			switch (prefSearch) {
			case 1:
				// calls search method for integers
				Searches.searchInt(intNumbers);
				break;
			case 2:
				// calls search method for doubles
				Searches.searchDouble(doubleNumbers);
				break;
			case 3:
				// calls search method for strings
				Searches.searchString(words);
				break;

			}
		}

	}
}