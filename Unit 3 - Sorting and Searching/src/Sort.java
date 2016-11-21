import java.util.Scanner;

/**
 * @author 323016139
 *
 */
public class Sort {

	private static Scanner scan;

	/**
	 * @param words
	 * This method takes the array of strings from the main and allows the user to alter it
	 */
	static void sortString(String[] words) {
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1) {
			selectionSort(words);
		} else if (prefMethod == 2) {
			insertionSort(words);
		}
	}
	/**
	 * @param words
	 * This method does insertion sorting to sort the array of strings
	 */
	private static void insertionSort(String[] words) {
		int i;
		for (int j = 1; j < words.length; j++) {
			String temp = words[j];
			for (i = j - 1; (i >= 0) && (words[i].compareTo(temp) > 0); i--) {
				words[i + 1] = words[i];
			}
			for (int x = 0; x < words.length; x++) {
				System.out.print(words[x] + "  ");
				if (x == words.length - 1) {
					System.out.println(" ");
				}
			}
			words[i + 1] = temp;
		}
		for (int x = 0; x < words.length; x++) {
			System.out.print(words[x] + "  ");
		}
	}

	/**
	 * @param words
	 * This method does selection sorting to sort the array of string
	 */
	private static void selectionSort(String[] words) {
		for (int i = 0; i < words.length; i++) {
			String smallestLetter = words[i];
			int smallestIndex = i;
			for (int j = i + 1; j < words.length; j++) {
				if (smallestLetter.compareTo(words[i + 1]) < 0)
					;
				smallestIndex = j;

			}

			words[smallestIndex] = words[i];
			words[i] = smallestLetter;

			for (int x = 0; x < words.length; x++) {
				System.out.print(words[x] + "  ");
			}
			System.out.println(" ");
		}
	}

	/**
	 * @param doubleNumbers
	 * This method takes the array of doubles from the main and allows the user to alter it
	 */
	static void sortDouble(double[] doubleNumbers) {
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1) {
			selectionSort(doubleNumbers);
		} else if (prefMethod == 2) {
			insertionSort(doubleNumbers);
		}

	}

	/**
	 * @param doubleNumbers
	 * This method does insertion sorting to sort the array of doubles
	 */
	private static void insertionSort(double[] doubleNumbers) {
		int i;
		for (int j = 1; j < doubleNumbers.length; j++) {
			double temp = doubleNumbers[j];
			for (i = j - 1; (i >= 0) && (doubleNumbers[i] > temp); i--) {
				doubleNumbers[i + 1] = doubleNumbers[i];
			}
			for (int x = 0; x < doubleNumbers.length; x++) {
				System.out.print(doubleNumbers[x] + "  ");
				if (x == doubleNumbers.length - 1) {
					System.out.println(" ");
				}
			}
			doubleNumbers[i + 1] = temp;
		}
		for (int x = 0; x < doubleNumbers.length; x++) {
			System.out.print(doubleNumbers[x] + "  ");
		}
	}

	/**
	 * @param doubleNumbers
	 * This method does selection sorting to sort the array of doubles
	 */
	private static void selectionSort(double[] doubleNumbers) {
		for (int i = 0; i < doubleNumbers.length; i++) {
			double smallestValue = doubleNumbers[i];
			int smallestIndex = i;
			for (int j = i + 1; j < doubleNumbers.length; j++) {
				if (smallestValue > doubleNumbers[j]) {
					smallestValue = doubleNumbers[j];
					smallestIndex = j;

				}
			}

			doubleNumbers[smallestIndex] = doubleNumbers[i];
			doubleNumbers[i] = smallestValue;

			for (int x = 0; x < doubleNumbers.length; x++) {
				System.out.print(doubleNumbers[x] + "  ");
			}
			System.out.println(" ");
		}
	}

	/**
	 * @param intNumbers
	 * This method takes the array of integers from the main and allows the user to alter it
	 */
	public static void sortInt(int[] intNumbers) {
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1) {
			selectionSort(intNumbers);
		} else if (prefMethod == 2) {
			insertionSort(intNumbers);
		}

	}

	/**
	 * @param intNumbers
	 * This method does selection sorting to sort the array of integers
	 */
	public static void selectionSort(int[] intNumbers) {
		for (int i = 0; i < intNumbers.length; i++) {
			int smallestValue = intNumbers[i];
			int smallestIndex = i;
			for (int j = i + 1; j < intNumbers.length; j++) {
				if (smallestValue > intNumbers[j]) {
					smallestValue = intNumbers[j];
					smallestIndex = j;

				}
			}

			intNumbers[smallestIndex] = intNumbers[i];
			intNumbers[i] = smallestValue;

			for (int x = 0; x < intNumbers.length; x++) {
				System.out.print(intNumbers[x] + "  ");
			}
			System.out.println(" ");
		}
	}

	/**
	 * @param intNumbers
	 * This method does insertion sorting to sort the array of integers
	 */
	public static void insertionSort(int[] intNumbers) {
		int i;
		for (int j = 1; j < intNumbers.length; j++) {
			int temp = intNumbers[j];
			for (i = j - 1; (i >= 0) && (intNumbers[i] > temp); i--) {
				intNumbers[i + 1] = intNumbers[i];
			}
			for (int x = 0; x < intNumbers.length; x++) {
				System.out.print(intNumbers[x] + "  ");
				if (x == intNumbers.length - 1) {
					System.out.println(" ");
				}
			}
			intNumbers[i + 1] = temp;
		}
		for (int x = 0; x < intNumbers.length; x++) {
			System.out.print(intNumbers[x] + "  ");
		}
	}
}