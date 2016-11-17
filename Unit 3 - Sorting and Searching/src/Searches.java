import java.util.Scanner;
/*
 * Ajay Gurdat
 * 07/11/2016 - 09/11/2016
 * Searching
 */
/**
 * @author 323016139
 */
public class Searches {

	private static Scanner scan;

	/**
	 * @param args
	 * @param foundIndex 
	 * This method requests what array would you like to find the target number and requests a number to find using on of the two searching methods
	 */
	public static void main(String[] args) {
		int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		double[] numbersDouble = {0.24, 2.314, 4.52, 5.4, 3.5, 3.2, 4.7, 2.6, 2.4, 13.86, 2.4, 3.4};
		
		int startIndex = 0;
		int endIndex = numbers.length;
		int midIndex = (startIndex + endIndex)/2;

		scan = new Scanner(System.in);
		System.out.println("Which array would you like to use?");
		System.out.println("1. Int");
		System.out.println("2. Double");
		System.out.println("3. String");
		int prefSearch = scan.nextInt();

		switch (prefSearch){
		case 1: searchInt(numbers, startIndex, endIndex, midIndex);
		break;
		case 2: searchDouble();
		break;
		case 3: searchString ();
		break;
		}

		scan = new Scanner(System.in);
		System.out.println("What is your target number?");
		double target = scan.nextDouble();

		System.out.println("How would you like to find your target?");
		System.out.println("1. Linear Search");
		System.out.println("2. Binary Search");
		scan = new Scanner(System.in);
		int prefMode = scan.nextInt();
	}

	private static void searchString() {
		System.out.println("How would you like to find your target?");
		System.out.println("1. Linear Search");
		System.out.println("2. Binary Search");
		scan = new Scanner(System.in);
		int prefMode = scan.nextInt();
	}

private static void searchDouble() {
	System.out.println("How would you like to find your target?");
	System.out.println("1. Linear Search");
	System.out.println("2. Binary Search");
	scan = new Scanner(System.in);
	int prefMode = scan.nextInt();

}
/**
 * 
 * @param numbers
 * @param startIndex
 * @param endIndex
 * @param midIndex
 */
private static void searchInt(int[] numbers, int startIndex, int endIndex, int midIndex) {
	System.out.println("How would you like to find your target?");
	System.out.println("1. Linear Search");
	System.out.println("2. Binary Search");
	scan = new Scanner(System.in);
	int prefMode = scan.nextInt();
	System.out.println("What is your target number?");
	scan = new Scanner(System.in);
	double target = scan.nextDouble();
	switch (prefMode){
	case 1: linearSearch(numbers, target);
	break;
	case 2: binarySearch(startIndex, endIndex, midIndex, target);
	}

}
/**
 * 
 * @param startIndex
 * @param endIndex
 * @param midIndex
 * @param inputTarget
 * @return
 * This method does binary searching to find the target number in the array
 */
private static int binarySearch(int startIndex, int endIndex, int midIndex, double inputTarget) {

	if (startIndex > endIndex){
		return -1; //Returns -1 is target is not found
	}

	if (midIndex == inputTarget){
		return midIndex; // Returns when target index is found

	}else if (midIndex > inputTarget){
		return binarySearch(startIndex, midIndex - 1, (startIndex + (midIndex -1))/2, inputTarget); //Calls back method with new variables

	}else if (midIndex < inputTarget){
		return binarySearch(midIndex + 1, endIndex, ((midIndex +1) + endIndex)/2, inputTarget); //Calls back method with new variables
	}
	return -1; //Returns -1 is target is not found

}
/**
 * 
 * @param numbers
 * @param inputTarget
 * @return
 * This method does linear searching to find the target number in the array
 */
public static int linearSearch(int[] numbers, double target){
	for(int i = 0; i < numbers.length; i++){
		if (numbers[i] == (target)){
			int foundIndex = i;
			return foundIndex; //Returns index where target is found
		}else if (i > numbers.length){ // Returns -1 if target is not found
			int foundIndex = -1;
			return foundIndex;

		}

	}
	return -1; //Returns -1 is target is not found
}

}