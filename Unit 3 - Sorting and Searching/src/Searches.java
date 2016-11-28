import java.util.Scanner;

/**
 * @author 323016139 Ajay Gurdat 07/11/2016 - 22/11/2016 Searching
 */
public class Searches {

	private static Scanner scan;

	/**
	 * @param words
	 */
	static void searchString(String[] words) {
		// declares variables based on array size
		int startIndex = 0;
		int endIndex = words.length - 1;
		int midIndex = (startIndex + endIndex) / 2;
		System.out.println("How would you like to find your target?");
		System.out.println("1. Linear Search");
		System.out.println("2. Binary Search");
		scan = new Scanner(System.in);
		int prefMode = scan.nextInt();
		System.out.println("What is your target string?");
		scan = new Scanner(System.in);
		String target = scan.nextLine();
		int foundIndex = 0;
		switch (prefMode) {
		case 1:
			// calls linear search
			foundIndex = linearSearch(words, target);
			break;
		case 2:
			// sorts array because binary search assumes the array is already
			// sorted (bubble sort)
			for (int a = 0; a < words.length - 1; a++) {
				for (int i = 0; i < words.length - 1; i++) {
					if (words[i].compareTo(words[i + 1]) > 0) {
						String temp = words[i];
						words[i] = words[i + 1];
						words[i + 1] = temp;
					}
				}
			}
			// calls binary search
			foundIndex = binarySearch(startIndex, endIndex, midIndex, target, words);
			break;
		}
		if (foundIndex >= 0) {
			System.out.print("Your target was found at spot " + foundIndex
					+ " in the array, this would be the spot if the array was sorted if you chose binary search.");
		} else {
			System.out.print("Your target was not found the in the array.");
		}
	}

	/**
	 * @param doubleNumbers
	 */
	static void searchDouble(double[] doubleNumbers) {
		// declares variables based on array size
		int startIndex = 0;
		int endIndex = doubleNumbers.length - 1;
		int midIndex = (startIndex + endIndex) / 2;
		System.out.println("How would you like to find your target?");
		System.out.println("1. Linear Search");
		System.out.println("2. Binary Search");
		scan = new Scanner(System.in);
		int prefMode = scan.nextInt();
		System.out.println("What is your target number?");
		scan = new Scanner(System.in);
		double target = scan.nextDouble();
		int foundIndex = 0;
		switch (prefMode) {
		case 1:
			// calls liner search
			foundIndex = linearSearch(doubleNumbers, target);
			break;
		case 2:
			// sorts array because binary search assumes the array is already
			// sorted (bubble sort)
			for (int a = 0; a < doubleNumbers.length - 1; a++) {
				for (int i = 0; i < doubleNumbers.length - 1; i++) {
					if (doubleNumbers[i] > doubleNumbers[i + 1]) {
						double temp = doubleNumbers[i];
						doubleNumbers[i] = doubleNumbers[i + 1];
						doubleNumbers[i + 1] = temp;
					}
				}
			}
			// calls binary search
			foundIndex = binarySearch(startIndex, endIndex, midIndex, target, doubleNumbers);
			break;
		}
		if (foundIndex >= 0) {
			System.out.print("Your target was found at spot " + foundIndex
					+ " in the array, this would be the spot if the array was sorted if you chose binary search.");
		} else {
			System.out.print("Your target was not found the in the array.");
		}

	}

	/**
	 * @param numbers
	 */
	static void searchInt(int[] intNumbers) {
		// declares variables based on array size
		int startIndex = 0;
		int endIndex = intNumbers.length - 1;
		int midIndex = (startIndex + endIndex) / 2;
		System.out.println("How would you like to find your target?");
		System.out.println("1. Linear Search");
		System.out.println("2. Binary Search");
		scan = new Scanner(System.in);
		int prefMode = scan.nextInt();
		System.out.println("What is your target number?");
		scan = new Scanner(System.in);
		int target = scan.nextInt();
		int foundIndex = 0;
		switch (prefMode) {
		case 1:
			// calls liner search
			foundIndex = linearSearch(intNumbers, target);
			break;
		case 2:
			// sorts array because binary search assumes the array is already
			// sorted (bubble sort)
			for (int a = 0; a < intNumbers.length - 1; a++) {
				for (int i = 0; i < intNumbers.length - 1; i++) {
					if (intNumbers[i] > intNumbers[i + 1]) {
						int temp = intNumbers[i];
						intNumbers[i] = intNumbers[i + 1];
						intNumbers[i + 1] = temp;
					}
				}
			}
			// calls binary search
			foundIndex = binarySearch(startIndex, endIndex, midIndex, target, intNumbers);
			break;
		}
		if (foundIndex >= 0) {
			System.out.print("Your target was found at spot " + foundIndex
					+ " in the array, this would be the spot if the array was sorted if you chose binary search.");
		} else {
			System.out.print("Your target was not found the in the array.");
		}
	}

	/**
	 * @param startIndex
	 * @param endIndex
	 * @param midIndex
	 * @param target
	 * @return This method does binary searching to find the target number in
	 *         the array
	 */
	private static int binarySearch(int startIndex, int endIndex, int midIndex, int target, int[] intNumbers) {

		if (startIndex > endIndex) {
			return -1; // Returns -1 is target is not found
		}

		if (intNumbers[midIndex] == target) {
			return midIndex; // Returns when target index is found

		} else if (intNumbers[midIndex] > target) {
			return binarySearch(startIndex, midIndex - 1, ((startIndex + (midIndex - 1)) / 2), target, intNumbers); // Calls
			// back
			// method
			// with
			// new
			// variables

		} else if (intNumbers[midIndex] < target) {
			return binarySearch(midIndex + 1, endIndex, (((midIndex + 1) + endIndex) / 2), target, intNumbers); // Calls
			// back
			// method
			// with
			// new
			// variables
		}
		return -1; // Returns -1 is target is not found

	}

	private static int binarySearch(int startIndex, int endIndex, int midIndex, double target, double[] doubleNumbers) {

		if (startIndex > endIndex) {
			return -1; // Returns -1 is target is not found
		}

		if (doubleNumbers[midIndex] == target) {
			return midIndex; // Returns when target index is found

		} else if (doubleNumbers[midIndex] > target) {
			return binarySearch(startIndex, midIndex - 1, ((startIndex + (midIndex - 1)) / 2), target, doubleNumbers); // Calls
			// back
			// method
			// with
			// new
			// variables

		} else if (doubleNumbers[midIndex] < target) {
			return binarySearch(midIndex + 1, endIndex, (((midIndex + 1) + endIndex) / 2), target, doubleNumbers); // Calls
			// back
			// method
			// with
			// new
			// variables
		}
		return -1; // Returns -1 is target is not found

	}

	/**
	 * @param startIndex
	 * @param endIndex
	 * @param midIndex
	 * @param target
	 * @param words
	 * @return
	 */
	private static int binarySearch(int startIndex, int endIndex, int midIndex, String target, String[] words) {

		if (startIndex > endIndex) {
			return -1; // Returns -1 is target is not found
		}

		if (words[midIndex].equals(target)) {
			return midIndex; // Returns when target index is found

		} else if (words[midIndex].compareTo(target) > 0) {
			return binarySearch(startIndex, midIndex - 1, (startIndex + (midIndex - 1)) / 2, target, words);// Calls
			// back
			// method
			// with
			// new
			// variables

		} else if (words[midIndex].compareTo(target) < 0) {
			return binarySearch(midIndex + 1, endIndex, ((midIndex + 1) + endIndex) / 2, target, words); // Calls
			// back
			// method
			// with
			// new
			// variables
		}
		return -1; // Returns -1 is target is not found

	}

	/**
	 * @param numbers
	 * @param inputTarget
	 * @return This method does linear searching to find the target number in
	 *         the array
	 */
	public static int linearSearch(int[] intNumbers, int target) {
		for (int i = 0; i < intNumbers.length; i++) {
			if (intNumbers[i] == (target)) {
				int foundIndex = i;
				return foundIndex; // Returns index where target is found
			} else if (i > intNumbers.length) { // Returns -1 if target is not
				// found
				int foundIndex = -1;
				return foundIndex;
			}
		}
		return -1; // Returns -1 is target is not found
	}

	/**
	 * @param words
	 * @param target
	 * @return
	 */
	public static int linearSearch(String[] words, String target) {
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) {
				int foundIndex = i;
				return foundIndex; // Returns index where target is found
			} else if (i > words.length) { // Returns -1 if target is not found
				int foundIndex = -1;
				return foundIndex;
			}
		}
		return -1; // Returns -1 is target is not found
	}

	/**
	 * @param doubleNumbers
	 * @param target
	 * @return
	 */
	public static int linearSearch(double[] doubleNumbers, double target) {
		for (int i = 0; i < doubleNumbers.length; i++) {
			if (doubleNumbers[i] == (target)) {
				int foundIndex = i;
				return foundIndex; // Returns index where target is found
			} else if (i > doubleNumbers.length) { // Returns -1 if target is
				// not found
				int foundIndex = -1;
				return foundIndex;
			}
		}
		return -1; // Returns -1 is target is not found
	}
}