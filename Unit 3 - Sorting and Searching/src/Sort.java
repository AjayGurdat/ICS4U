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
	public static void sortString(String[] words) {
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		System.out.println("3. Bubble");
		System.out.println("4. Merge");
		System.out.println("5. Quick");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1) {
			// calls selection sort and sends the array words
			selectionSort(words);
		} else if (prefMethod == 2) {
			// calls insertion sort and sends the array words
			insertionSort(words);
		} else if (prefMethod == 3) {
			// calls bubble sort and sends the array words
			bubbleSort(words);
		} else if (prefMethod == 4) {
			// calls merge sort and sends the array words
			String[] sortedArray = mergeSort(words);
			for (int x = 0; x < sortedArray.length; x++) {
				System.out.print(sortedArray[x] + "  ");
			}
		} else if (prefMethod == 5) {
			int start = 0;
			int end = words.length - 1;
			// calls quick sort and sends the array intNumbers and some
			// variables based on the array's length
			quickSort(words, start, end);
			for (int x = 0; x < words.length; x++) {
				System.out.print(words[x] + "  ");
			}
		}
	}

	/**
	 * This method does quick sorting to sort the array of strings
	 * 
	 * @param words
	 * @param start
	 * @param end
	 * @return
	 */
	public static String[] quickSort(String[] words, int start, int end) {
		if (start >= end)
			return words;
		String pivot = words[end];
		int i = start, j = end;
		while (i <= j) {
			while (words[i].compareTo(pivot) < 0) {
				i++;
			}

			while (words[j].compareTo(pivot) > 0) {
				j--;
			}

			if (i <= j) {
				String temp = words[i];
				words[i] = words[j];
				words[j] = temp;
				i++;
				j--;
			}
		}

		if (start < j)
			quickSort(words, start, j);

		if (end > i)
			quickSort(words, i, end);
		return words;
	}

	/**
	 * This method does merge sorting to sort the array of strings
	 * 
	 * @param words
	 * @return
	 */
	public static String[] mergeSort(String[] words) {
		if (words.length <= 1) {
			return words;
		}
		// breaks array into two new sub arrays and creates new array size that
		// will be returned
		String[] sortedArray = new String[words.length];
		String[] leftSide = Arrays.copyOfRange(words, 0, words.length / 2);
		String[] rightSide = Arrays.copyOfRange(words, words.length / 2, words.length);

		// call back method to divide the sub array
		leftSide = mergeSort(leftSide);
		rightSide = mergeSort(rightSide);
		// merges two arrays into one sorted array
		sortedArray = merge(leftSide, rightSide);
		return sortedArray;
	}

	/**
	 * This method merges two sorted arrays into one big sorted array
	 * 
	 * @param leftSide
	 * @param rightSide
	 * @return
	 */
	private static String[] merge(String[] leftSide, String[] rightSide) {
		// sets size of array that will be returned
		String[] sortedArray = new String[leftSide.length + rightSide.length];
		int indexRight = 0;
		int indexLeft = 0;
		int indexSorted = 0;

		while (indexLeft < leftSide.length || indexRight < rightSide.length) {
			if (indexLeft < leftSide.length && indexRight < rightSide.length) {
				if (leftSide[indexLeft].compareTo(rightSide[indexRight]) <= 0) {
					// if left < right, put left index into new sorted array
					sortedArray[indexSorted] = leftSide[indexLeft];
					// increase index of left and sorted, showing the program is
					// done looking at those values
					indexLeft++;
					indexSorted++;
				} else {
					// when left > right, put right index into new sorted array
					sortedArray[indexSorted] = rightSide[indexRight];
					indexRight++;
					indexSorted++;
				}
			} else if (indexLeft < leftSide.length) {
				// if right side has no more elements in it, put the rest of
				// left
				// into the sorted array
				sortedArray[indexSorted] = leftSide[indexLeft];
				indexLeft++;
				indexSorted++;
			} else if (indexRight < rightSide.length) {
				// if left side has no more elements in it, put the rest of
				// right
				// into the sorted array
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
	 * @param words
	 */
	public static void bubbleSort(String[] words) {
		// goes through the array for every element
		for (int a = 0; a < words.length - 1; a++) {
			for (int i = 0; i < words.length - 1; i++) {
				// swaps bigger number with smaller number one index higher than
				// it, then goes to the next element and repeats
				if (words[i].compareTo(words[i + 1]) > 0) {
					String temp = words[i];
					words[i] = words[i + 1];
					words[i + 1] = temp;
				}
			}
			// prints out array
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
	public static void insertionSort(String[] words) {
		int i;
		// makes a sub array within the same array
		for (int j = 1; j < words.length; j++) {
			String temp = words[j];
			// puts next element of the sub array and puts into its proper spot
			// in
			// the sub array
			for (i = j - 1; (i >= 0) && (words[i].compareTo(temp) > 0); i--) {
				words[i + 1] = words[i];
			}
			// prints out array
			for (int x = 0; x < words.length; x++) {
				System.out.print(words[x] + "  ");
				if (x == words.length - 1) {
					System.out.println(" ");
				}
			}
			// declares new element to compare
			words[i + 1] = temp;
		}
	}

	/**
	 * This method does selection sorting to sort the array of string
	 * 
	 * @param words
	 */
	public static void selectionSort(String[] words) {
		for (int i = 0; i < words.length; i++) {
			// finds the smallest value in the array, saves it and its index
			String smallestWord = words[i];
			int smallestIndex = i;
			for (int j = i + 1; j < words.length; j++) {
				// swaps the smallest value with the next value of the sorted
				// part of the array
				if (smallestWord.compareTo(words[j]) > 0) {
					smallestWord = words[j];
					smallestIndex = j;

				}
			}
			words[smallestIndex] = words[i];
			words[i] = smallestWord;
			// prints out array
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
	public static void sortDouble(double[] doubleNumbers) {
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		System.out.println("3. Bubble");
		System.out.println("4. Merge");
		System.out.println("5. Quick");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1) {
			// calls selection sort and sends the array doubleNumbers
			selectionSort(doubleNumbers);
		} else if (prefMethod == 2) {
			// calls insertion sort and sends the array doubleNumbers
			insertionSort(doubleNumbers);
		} else if (prefMethod == 3) {
			// calls bubble sort and sends the array doubleNumbers
			bubbleSort(doubleNumbers);
		} else if (prefMethod == 4) {
			// calls merge sort and sends the array doubleNumbers
			double[] sortedArray = mergeSort(doubleNumbers);
			for (int x = 0; x < sortedArray.length; x++) {
				System.out.print(sortedArray[x] + "  ");
			}
		} else if (prefMethod == 5) {
			int start = 0;
			int end = doubleNumbers.length - 1;
			// calls quick sort and sends the array intNumbers and some
			// variables based on the array's length
			quickSort(doubleNumbers, start, end);
			for (int x = 0; x < doubleNumbers.length; x++) {
				System.out.print(doubleNumbers[x] + "  ");
			}
		}

	}

	public static double[] quickSort(double[] doubleNumbers, int start, int end) {
		if (start >= end)
			return doubleNumbers;
		double pivot = doubleNumbers[end];
		int i = start, j = end;
		while (i <= j) {
			while (doubleNumbers[i] < pivot) {
				i++;
			}

			while (doubleNumbers[j] > pivot) {
				j--;
			}

			if (i <= j) {
				double temp = doubleNumbers[i];
				doubleNumbers[i] = doubleNumbers[j];
				doubleNumbers[j] = temp;
				i++;
				j--;
			}
		}

		if (start < j)
			quickSort(doubleNumbers, start, j);

		if (end > i)
			quickSort(doubleNumbers, i, end);
		return doubleNumbers;
	}

	public static double[] mergeSort(double[] doubleNumbers) {
		if (doubleNumbers.length <= 1) {
			return doubleNumbers;
		}
		// breaks array into two new sub arrays and creates new array size that
		// will be returned
		double[] sortedArray = new double[doubleNumbers.length];
		double[] leftSide = Arrays.copyOfRange(doubleNumbers, 0, doubleNumbers.length / 2);
		double[] rightSide = Arrays.copyOfRange(doubleNumbers, doubleNumbers.length / 2, doubleNumbers.length);

		// call back method to divide the sub array
		leftSide = mergeSort(leftSide);
		rightSide = mergeSort(rightSide);
		// merges two arrays into one sorted array
		sortedArray = merge(leftSide, rightSide);
		return sortedArray;
	}

	/**
	 * This method merges two sorted arrays into one big sorted array
	 * 
	 * @param leftSide
	 * @param rightSide
	 * @return
	 */

	private static double[] merge(double[] leftSide, double[] rightSide) {
		// sets size of array that will be returned
		double[] sortedArray = new double[leftSide.length + rightSide.length];
		int indexRight = 0;
		int indexLeft = 0;
		int indexSorted = 0;

		while (indexLeft < leftSide.length || indexRight < rightSide.length) {
			if (indexLeft < leftSide.length && indexRight < rightSide.length) {
				if (leftSide[indexLeft] <= rightSide[indexRight]) {
					// if left < right, put left index into new sorted array
					sortedArray[indexSorted] = leftSide[indexLeft];
					// increase index of left and sorted, showing the program is
					// done looking at those values
					indexLeft++;
					indexSorted++;
				} else {
					// when left > right, put right index into new sorted array
					sortedArray[indexSorted] = rightSide[indexRight];
					indexRight++;
					indexSorted++;
				}
			} else if (indexLeft < leftSide.length) {
				// if right side has no more elements in it, put the rest of
				// left
				// into the sorted array
				sortedArray[indexSorted] = leftSide[indexLeft];
				indexLeft++;
				indexSorted++;
			} else if (indexRight < rightSide.length) {
				// if left side has no more elements in it, put the rest of
				// right
				// into the sorted array
				sortedArray[indexSorted] = rightSide[indexRight];
				indexRight++;
				indexSorted++;
			}
		}
		// returns new sorted array
		return sortedArray;
	}

	/**
	 * This method does bubble sorting to sort the array of strings
	 * 
	 * @param doubleNumbers
	 */
	public static void bubbleSort(double[] doubleNumbers) {
		// goes through the array for every element
		for (int a = 0; a < doubleNumbers.length - 1; a++) {
			for (int i = 0; i < doubleNumbers.length - 1; i++) {
				// swaps bigger number with smaller number one index higher than
				// it, then goes to the next element and repeats
				if (doubleNumbers[i] > doubleNumbers[i + 1]) {
					double temp = doubleNumbers[i];
					doubleNumbers[i] = doubleNumbers[i + 1];
					doubleNumbers[i + 1] = temp;
				}
			}
			// prints out array
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
	public static void insertionSort(double[] doubleNumbers) {
		int i;
		// makes a sub array within the same array
		for (int j = 1; j < doubleNumbers.length; j++) {
			double temp = doubleNumbers[j];
			// puts next element of the sub array and puts into its proper spot
			// in
			// the sub array
			for (i = j - 1; (i >= 0) && (doubleNumbers[i] > temp); i--) {
				doubleNumbers[i + 1] = doubleNumbers[i];
			}
			// prints out array
			for (int x = 0; x < doubleNumbers.length; x++) {
				System.out.print(doubleNumbers[x] + "  ");
				if (x == doubleNumbers.length - 1) {
					System.out.println(" ");
				}
			}
			// declares new element to compare
			doubleNumbers[i + 1] = temp;
		}
		for (int x = 0; x < doubleNumbers.length; x++) {
			System.out.print(doubleNumbers[x] + "  ");
		}
	}

	/**
	 * This method does selection sorting to sort the array of doubles
	 * 
	 * @param doubleNumbers
	 */
	public static void selectionSort(double[] doubleNumbers) {
		// finds the smallest value in the array, saves it and its index
		for (int i = 0; i < doubleNumbers.length; i++) {
			// swaps the smallest value with the next value of the sorted
			// part of the array
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
			// prints out array
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
		System.out.println("5. Quick");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1) {
			// calls selection sort and sends the array intNumbers
			selectionSort(intNumbers);
		} else if (prefMethod == 2) {
			// calls insertion sort and sends the array intNumbers
			insertionSort(intNumbers);
		} else if (prefMethod == 3) {
			// calls bubble sort and sends the array intNumbers
			bubbleSort(intNumbers);
		} else if (prefMethod == 4) {
			// calls merge sort and sends the array intNumbers
			int[] sortedArray = mergeSort(intNumbers);
			for (int x = 0; x < sortedArray.length; x++) {
				System.out.print(sortedArray[x] + "  ");
			}

		} else if (prefMethod == 5) {
			int start = 0;
			int end = intNumbers.length - 1;
			// calls quick sort and sends the array intNumbers and some
			// variables based on the array's length
			quickSort(intNumbers, start, end);
			for (int x = 0; x < intNumbers.length; x++) {
				System.out.print(intNumbers[x] + "  ");
			}
		}

	}

	public static int[] quickSort(int[] intNumbers, int start, int end) {
		// base case, returns array
		if (start >= end)
			return intNumbers;
		// creates pivot at the end of current part of the array
		int pivot = intNumbers[end];
		int i = start, j = end;
		while (i <= j) {
			while (intNumbers[i] < pivot) {
				i++;
			}

			while (intNumbers[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = intNumbers[i];
				intNumbers[i] = intNumbers[j];
				intNumbers[j] = temp;
				i++;
				j--;
			}
		}

		if (start < j)
			// calls back method with new variables for the next part of the
			// array
			quickSort(intNumbers, start, j);

		if (end > i)
			// calls back method with new variables for the next part of the
			// array
			quickSort(intNumbers, i, end);
		return intNumbers;
	}

	/**
	 * This method does merge sort to sort the array of integers
	 * 
	 * @param intNumbers
	 * @return
	 */
	public static int[] mergeSort(int[] intNumbers) {
		if (intNumbers.length <= 1) {
			return intNumbers;
		}
		// breaks array into two new sub arrays and creates new array size that
		// will be returned
		int[] sortedArray = new int[intNumbers.length];
		int[] leftSide = Arrays.copyOfRange(intNumbers, 0, intNumbers.length / 2);
		int[] rightSide = Arrays.copyOfRange(intNumbers, intNumbers.length / 2, intNumbers.length);

		// call back method to divide the sub array
		leftSide = mergeSort(leftSide);
		rightSide = mergeSort(rightSide);
		// merges two arrays into one sorted array
		sortedArray = merge(leftSide, rightSide);
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
		// sets size of array that will be returned
		int[] sortedArray = new int[leftSide.length + rightSide.length];
		int indexRight = 0;
		int indexLeft = 0;
		int indexSorted = 0;

		while (indexLeft < leftSide.length || indexRight < rightSide.length) {
			if (indexLeft < leftSide.length && indexRight < rightSide.length) {
				if (leftSide[indexLeft] <= rightSide[indexRight]) {
					// if left < right, put left index into new sorted array
					sortedArray[indexSorted] = leftSide[indexLeft];
					// increase index of left and sorted, showing the program is
					// done looking at those values
					indexLeft++;
					indexSorted++;
				} else {
					// when left > right, put right index into new sorted array
					sortedArray[indexSorted] = rightSide[indexRight];
					// increase index of right and sorted, showing the program
					// is done looking at those values
					indexRight++;
					indexSorted++;
				}
			} else if (indexLeft < leftSide.length) {
				// if right side has no more elements in it, put the rest of
				// left
				// into the sorted array
				sortedArray[indexSorted] = leftSide[indexLeft];
				indexLeft++;
				indexSorted++;
			} else if (indexRight < rightSide.length) {
				// if left side has no more elements in it, put the rest of
				// right
				// into the sorted array
				sortedArray[indexSorted] = rightSide[indexRight];
				indexRight++;
				indexSorted++;
			}
		}
		// returns new sorted array
		return sortedArray;
	}

	/**
	 * This method does bubble sorting to sort the array of strings
	 * 
	 * @param intNumbers
	 */
	public static void bubbleSort(int[] intNumbers) {
		// goes through the array for every element
		for (int a = 0; a < intNumbers.length - 1; a++) {
			for (int i = 0; i < intNumbers.length - 1; i++) {
				// swaps bigger number with smaller number one index higher than
				// it
				if (intNumbers[i] > intNumbers[i + 1]) {
					int temp = intNumbers[i];
					intNumbers[i] = intNumbers[i + 1];
					intNumbers[i + 1] = temp;
				}
			}
			// prints out array
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
			// finds the smallest value in the array, saves it and its index
			int smallestValue = intNumbers[i];
			int smallestIndex = i;
			for (int j = i + 1; j < intNumbers.length; j++) {
				// swaps the smallest value with the next value of the sorted
				// part of the array
				if (smallestValue > intNumbers[j]) {
					smallestValue = intNumbers[j];
					smallestIndex = j;

				}
			}
			intNumbers[smallestIndex] = intNumbers[i];
			intNumbers[i] = smallestValue;
			// prints out array
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
		// makes a sub array within the same array
		for (int j = 1; j < intNumbers.length; j++) {
			int temp = intNumbers[j];
			// puts next element of the sub array and puts into its proper spot
			// in
			// the sub array
			for (i = j - 1; (i >= 0) && (intNumbers[i] > temp); i--) {
				intNumbers[i + 1] = intNumbers[i];
			}
			// prints out array
			for (int x = 0; x < intNumbers.length; x++) {
				System.out.print(intNumbers[x] + "  ");
				if (x == intNumbers.length - 1) {
					System.out.println(" ");
				}
			}
			// declares new element to compare
			intNumbers[i + 1] = temp;
		}
		for (int x = 0; x < intNumbers.length; x++) {
			System.out.print(intNumbers[x] + "  ");
		}
	}
}