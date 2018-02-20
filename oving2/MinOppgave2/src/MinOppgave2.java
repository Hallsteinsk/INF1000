import java.util.Scanner;

public class MinOppgave2 {

	// Scanner object available to all methods in class
	static Scanner input = new Scanner(System.in);

	// Declare a list with size 6. Available to all methods in class
	static int listSize = 6;
	static int[] numberList = new int[listSize];

	public static void main(String[] args) {

		// Uses the method "readList" to get values to numberList from user
		readList();
		
		//Message to user
		System.out.println("Your integers are stored in this list:"); 
		// Uses the method "printList" to write out numberList in the terminal
		printList(); 
	
		// Inserts an extra line shift
		System.out.println(); 

		// Sorts the users list by use of the "bubleSort" method.
		bubleSort();

		//Message to user
		System.out.println("Here is the list sorted:");
		// Prints out the sorted list in the terminal
		printList(); 

	}

	/* Bublesort method inspired by pseudocode found at
	www.sorting-algorithms.com*/
	static void bubleSort() {
		// Variables to be used inside the method
		int listIndex, startPoint;

		//The first for loop decides where in the list to start the sorting
		for (startPoint = 0; startPoint < listSize - 1; startPoint++) { 
			
			/*The second for loop compares two numbers, and moves the 
			largest to the end of the list by using an if statement and the swap method.*/
			for (listIndex = 0; listIndex < listSize - 1; listIndex++) {
				if (numberList[listIndex] > numberList[listIndex + 1]) {
					swap(listIndex, listIndex + 1);
				}
			}
		}
	}

	/* Method for swapping two values in numberList. Swaps the values with list
	index a and b by using a temporary storage variable.*/
	static void swap(int a, int b) {
		int temp = numberList[a];
		numberList[a] = numberList[b];
		numberList[b] = temp;
	}

	// Method for reading a list from user.
	static void readList() {
		int listIndex;

		// Message to user
		System.out.printf("Type in %d integers:\n", listSize);

		// For loop that saves the users integers in the list numberList
		for (listIndex = 0; listIndex < listSize; listIndex++) {
			numberList[listIndex] = Integer.parseInt(input.nextLine());
		}
	}

	// Method for printing out the values in numberList
	static void printList() {
		
		//For loop iterates trough numberList and prints each value 
		for (int listIndex = 0; listIndex < listSize; listIndex++) {
			System.out.println("numberList[" + listIndex + "] = " + numberList[listIndex]);
		}
	}
}
