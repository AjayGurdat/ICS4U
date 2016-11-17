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

		scan = new Scanner(System.in);
		System.out.println("Which array would you like to use?");
		System.out.println("1. Int");
		System.out.println("2. Double");
		System.out.println("3. String");
		int prefSearch = scan.nextInt();
		
		int startIndex = 0;
		int endIndex = numbers.length - 1;
		int midIndex = (startIndex + endIndex)/2;
		int endIndexDouble = numbersDouble.length - 1;
		int midIndexDouble = (startIndex + endIndexDouble)/2;
		scan = new Scanner(System.in);
		System.out.println("What is your target number?");
		double inputTarget = scan.nextDouble();

		System.out.println("How would you like to find your target?");
		System.out.println("1. Linear Search");
		System.out.println("2. Binary Search");
		scan = new Scanner(System.in);
		int prefMode = scan.nextInt();
		
		int foundIndex = 0;
		if (prefMode == 1 && prefSearch == 1){
			foundIndex = linearSearch(numbers, inputTarget);
		}else if (prefMode == 1 && prefSearch == 2){
			foundIndex = binarySearch(startIndex, endIndex, midIndex, inputTarget);
		}else if (prefMode == 2 && prefSearch == 1){
			foundIndex = linearSearchDouble(numbersDouble, inputTarget);
		}else if (prefMode == 2 && prefSearch == 2){
			foundIndex = binarySearchDouble(startIndex, endIndexDouble, midIndexDouble, inputTarget);
		}else{
			System.out.println("You didn't select a valid answer.");
		}

		if (foundIndex >= 0){ 
			System.out.print("Your target was found at spot " + foundIndex + ".");
		}else{
			System.out.print("Your target was not in the array.");
		}
	}
	/**
	 * 
	 * @param startIndex
	 * @param endIndexDouble
	 * @param midIndexDouble
	 * @param inputTarget
	 * @return
	 * This method does binary searching in the double array
	 */
	private static int binarySearchDouble(int startIndex, int endIndexDouble, int midIndexDouble, double inputTarget) {

		
		if (startIndex > endIndexDouble){
			return -1; //Returns -1 is target is not found
		}
		
		if (midIndexDouble == inputTarget){
			return midIndexDouble; // Returns when target index is found

		}else if (midIndexDouble > inputTarget){
			return binarySearchDouble(startIndex, midIndexDouble - 1, (startIndex + (midIndexDouble -1))/2, inputTarget); //Calls back method with new variables

		}else if (midIndexDouble < inputTarget){
			return binarySearchDouble(midIndexDouble + 1, endIndexDouble, ((midIndexDouble +1) + endIndexDouble)/2, inputTarget); //Calls back method with new variables
		}
		return -1; //Returns -1 is target is not found

	}

	/**
	 * 
	 * @param numbersDouble
	 * @param inputTarget
	 * @return
	 */
	private static int linearSearchDouble(double[] numbersDouble, double inputTarget) {

		for(int i = 0; i < numbersDouble.length; i++){
			if (numbersDouble[i] == (inputTarget)){
				int foundIndex = i;
				return foundIndex; //Returns index where target is found
			}else if (i > numbersDouble.length){ // Returns -1 if target is not found
				int foundIndex = -1;
				return foundIndex;
			}
		}
		return -1; //Returns -1 is target is not found
	
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
	public static int linearSearch(int[] numbers, double inputTarget){
		for(int i = 0; i < numbers.length; i++){
			if (numbers[i] == (inputTarget)){
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