import java.util.Scanner;

/**
 * @author 323016139
 *
 */
public class Sort {
	/**
	 * 
	 */
	private static Scanner scan;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("What type of list do you want sorted?");
		System.out.println("1. Integer");
		System.out.println("2. Double");
		System.out.println("3. String");
		scan = new Scanner(System.in);
		int prefList = scan.nextInt();
		switch (prefList){
		case 1: sortInt();
		break;
		case 2: sortDouble();
		break;
		case 3: sortString();
		break;

		}
	}
	/**
	 * 
	 */
	private static void sortString() {
		String[] words = {"Apple", "Case", "Pen", "Clock", "Mouse", "Bird", "Light", "Food", "Foot", "Cat", "Movie", "School"};
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1){
			selectionSortDouble(words);
		}else if (prefMethod == 2){
			insertionSortDouble(words);
		}
	}

	private static void insertionSortDouble(String[] words) {
		for (int a = 0; a < words.length - 1; a++){
			for (int i = 0; i < words.length - 1; i++){
				if (words[i].compareTo(words[i + 1])<0){
					String temp = words[i];
					words[i] = words[i + 1];
					words[i + 1] = temp;
					for (int x = 0; x < words.length; x++){
						System.out.print(words[x] + "  ");
						if (x == words.length - 1){
							System.out.println(" ");
						}
						
					}
				}

			}
		}
		
	}
	/**
	 * 
	 * @param words
	 */
	private static void selectionSortDouble(String[] words) {
		for (int i = 0; i < words.length; i++){
			String smallestLetter = words[i];
			int smallestIndex = i;
			for (int j = i + 1; j < words.length; j++){
				if (smallestLetter.compareTo(words[i + 1])<0);
					smallestIndex = j;

				}

			words[smallestIndex] = words[i];
			words[i] = smallestLetter;

			for (int x = 0; x < words.length; x++){
				System.out.print(words[x] + "  ");
			}
			System.out.println(" ");
		}
	}

	/**
	 * 
	 */
	private static void sortDouble() {

		double[] intNumbers = {7.4, 3.1, 22.6, 1.5, 6.1, 8.7, 4.2, 0, 5.4, 10.1, 9.8};
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1){
			selectionSortDouble(intNumbers);
		}else if (prefMethod == 2){
			insertionSortDouble(intNumbers);
		}



	}
	/**
	 * 
	 * @param doubleNumbers
	 */
	private static void insertionSortDouble(double[] doubleNumbers) {
		for (int a = 0; a < doubleNumbers.length - 1; a++){
			for (int i = 0; i < doubleNumbers.length - 1; i++){
				if (doubleNumbers[i] > doubleNumbers [i +1]){
					double temp = doubleNumbers[i];
					doubleNumbers[i] = doubleNumbers[i + 1];
					doubleNumbers[i + 1] = temp;
					for (int x = 0; x < doubleNumbers.length; x++){
						System.out.print(doubleNumbers[x] + "  ");
						if (x == doubleNumbers.length - 1){
							System.out.println(" ");
						}
					}
				}

			}
		}

	}
	/**
	 * 
	 * @param doubleNumbers
	 */
	private static void selectionSortDouble(double[] doubleNumbers) {
		for (int i = 0; i < doubleNumbers.length; i++){
			double smallestValue = doubleNumbers[i];
			int smallestIndex = i;
			for (int j = i + 1; j < doubleNumbers.length; j++){
				if (smallestValue > doubleNumbers[j]){
					smallestValue = doubleNumbers[j];
					smallestIndex = j;

				}
			}

			doubleNumbers[smallestIndex] = doubleNumbers[i];
			doubleNumbers[i] = smallestValue;

			for (int x = 0; x < doubleNumbers.length; x++){
				System.out.print(doubleNumbers[x] + "  ");
			}
			System.out.println(" ");
		}
	}
	/**
	 * 
	 */
	public static void sortInt(){
		int[] intNumbers = {7, 3, 2, 1, 6, 8, 4, 0, 5, 10, 9};
		System.out.println("What method would you like to sort the array?");
		System.out.println("1. Selection");
		System.out.println("2. Insertion");
		scan = new Scanner(System.in);
		int prefMethod = scan.nextInt();
		if (prefMethod == 1){
			selectionSortInt(intNumbers);
		}else if (prefMethod == 2){
			insertionSortInt(intNumbers);
		}


	}
	/**
	 * 
	 * @param intNumbers
	 */
	public static void selectionSortInt(int[] intNumbers){
		for (int i = 0; i < intNumbers.length; i++){
			int smallestValue = intNumbers[i];
			int smallestIndex = i;
			for (int j = i + 1; j < intNumbers.length; j++){
				if (smallestValue > intNumbers[j]){
					smallestValue = intNumbers[j];
					smallestIndex = j;

				}
			}

			intNumbers[smallestIndex] = intNumbers[i];
			intNumbers[i] = smallestValue;

			for (int x = 0; x < intNumbers.length; x++){
				System.out.print(intNumbers[x] + "  ");
			}
			System.out.println(" ");
		}
	}
	/**
	 * 
	 * @param intNumbers
	 */
	public static void insertionSortInt(int[] intNumbers){
		for (int a = 0; a < intNumbers.length - 1; a++){
			for (int i = 0; i < intNumbers.length - 1; i++){
				if (intNumbers[i] > intNumbers [i +1]){
					int temp = intNumbers[i];
					intNumbers[i] = intNumbers[i + 1];
					intNumbers[i + 1] = temp;
					for (int x = 0; x < intNumbers.length; x++){
						System.out.print(intNumbers[x] + "  ");
						if (x == intNumbers.length - 1){
							System.out.println(" ");
						}
					}
				}

			}
		}
	}
}