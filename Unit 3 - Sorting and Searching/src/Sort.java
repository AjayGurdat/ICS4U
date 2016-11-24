import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 323016139, Ajay Gurdat, 09/11/2016 - 22/11/2016, Sorting
 */
public class Sort {

	private static Scanner scan;

	/**
	 * This method takes the array of strings from the main and allows the user
	 * to alter it
	 * 
	 * @param words
	 */
	static void sortString(String[] words) {
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		System.out.println("3. Bubble");
		System.out.println("4. Merge");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1) {
			selectionSort(words);
		} else if (prefMethod == 2) {
			insertionSort(words);
		} else if (prefMethod == 3) {
			bubbleSort(words);
		} else if (prefMethod == 4) {
			mergeSort(words);
		}
	}

	private static void mergeSort(String[] words) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method does bubble sorting to sort the array of strings
	 * 
	 * @param words
	 */
	private static void bubbleSort(String[] words) {
		for (int a = 0; a < words.length - 1; a++) {
			for (int i = 0; i < words.length - 1; i++) {
				if (words[i].compareTo(words[i + 1]) > 0) {
					String temp = words[i];
					words[i] = words[i + 1];
					words[i + 1] = temp;
				}
			}
			for (int x = 0; x < words.length; x++) {
				System.out.print(words[x] + "  ");
			}
			System.out.println(" ");
		}
	}

	/**
	 * This method does insertion sorting to sort the array of strings
	 * 
	 * @param words
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
	}

	/**
	 * This method does selection sorting to sort the array of string
	 * 
	 * @param words
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
	 * This method takes the array of doubles from the main and allows the user
	 * to alter it
	 * 
	 * @param doubleNumbers
	 */
	static void sortDouble(double[] doubleNumbers) {
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		System.out.println("3. Bubble");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1) {
			selectionSort(doubleNumbers);
		} else if (prefMethod == 2) {
			insertionSort(doubleNumbers);
		} else if (prefMethod == 3) {
			bubbleSort(doubleNumbers);
		}

	}

	/**
	 * This method does bubble sorting to sort the array of strings
	 * 
	 * @param doubleNumbers
	 */
	private static void bubbleSort(double[] doubleNumbers) {
		for (int a = 0; a < doubleNumbers.length - 1; a++) {
			for (int i = 0; i < doubleNumbers.length - 1; i++) {
				if (doubleNumbers[i] > doubleNumbers[i + 1]) {
					double temp = doubleNumbers[i];
					doubleNumbers[i] = doubleNumbers[i + 1];
					doubleNumbers[i + 1] = temp;
				}
			}
			for (int x = 0; x < doubleNumbers.length; x++) {
				System.out.print(doubleNumbers[x] + "  ");
			}
			System.out.println(" ");
		}
	}

	/**
	 * This method does insertion sorting to sort the array of doubles
	 * 
	 * @param doubleNumbers
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
	}

	/**
	 * This method does selection sorting to sort the array of doubles
	 * 
	 * @param doubleNumbers
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
	 * This method takes the array of integers from the main and allows the user
	 * to alter it
	 * 
	 * @param intNumbers
	 */
	public static void sortInt(int[] intNumbers) {
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		System.out.println("3. Bubble");
		System.out.println("4. Merge");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1) {
			selectionSort(intNumbers);
		} else if (prefMethod == 2) {
			insertionSort(intNumbers);
		} else if (prefMethod == 3) {
			bubbleSort(intNumbers);
		} else if (prefMethod == 4) {
			int[] sortedArray = mergeSort(intNumbers);
			for (int x = 0; x < sortedArray.length; x++) {
				System.out.print(sortedArray[x] + "  ");
			}

		}

	}

	/**
	 * This method does merge sort to sort the array of integers
	 * 
	 * @param intNumbers
	 * @return
	 */
	private static int[] mergeSort(int[] intNumbers) {
		if (intNumbers.length <= 1) {
			return intNumbers;
		}
		int[] leftSide = Arrays.copyOfRange(intNumbers, 0, intNumbers.length / 2);
		int[] rightSide = Arrays.copyOfRange(intNumbers, intNumbers.length / 2, intNumbers.length);

		leftSide = mergeSort(leftSide);
		rightSide = mergeSort(rightSide);
		int[] sortedArray = merge(leftSide, rightSide);
		return sortedArray;
	}

	/**
	 * This method merges two sorted arrays into one big sorted array
	 * 
	 * @param leftSide
	 * @param rightSide
	 * @return
	 */
	private static int[] merge(int[] leftSide, int[] rightSide) {
		int[] sortedArray = new int[leftSide.length + rightSide.length];
		int indexRight = 0;
		int indexLeft = 0;
		int indexSorted = 0;

		while (indexLeft < leftSide.length || indexRight < rightSide.length) {
			if (indexLeft < leftSide.length || indexRight < rightSide.length) {
				if (leftSide[indexLeft] <= rightSide[indexRight]) {
					sortedArray[indexSorted] = leftSide[indexLeft];
					indexLeft++;
					indexSorted++;
				} else {
					sortedArray[indexSorted] = rightSide[indexRight];
					indexRight++;
					indexSorted++;
				}
			} else if (indexLeft < leftSide.length) {
				sortedArray[indexSorted] = leftSide[indexLeft];
				indexLeft++;
				indexSorted++;
			} else if (indexRight < rightSide.length) {
				sortedArray[indexSorted] = rightSide[indexRight];
				indexRight++;
				indexSorted++;
			}
		}
		return sortedArray;
	}

	/**
	 * This method does bubble sorting to sort the array of strings
	 * 
	 * @param intNumbers
	 */
	private static void bubbleSort(int[] intNumbers) {
		for (int a = 0; a < intNumbers.length - 1; a++) {
			for (int i = 0; i < intNumbers.length - 1; i++) {
				if (intNumbers[i] > intNumbers[i + 1]) {
					int temp = intNumbers[i];
					intNumbers[i] = intNumbers[i + 1];
					intNumbers[i + 1] = temp;
				}
			}
			for (int x = 0; x < intNumbers.length; x++) {
				System.out.print(intNumbers[x] + "  ");
			}
			System.out.println(" ");
		}
	}

	/**
	 * This method does selection sorting to sort the array of integers
	 * 
	 * @param intNumbers
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
	 * This method does insertion sorting to sort the array of integers
	 * 
	 * @param intNumbers
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
	}
}