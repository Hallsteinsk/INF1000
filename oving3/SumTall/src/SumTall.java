import java.util.ArrayList;
import java.util.Scanner;

public class SumTall {

	//Scanner object for reading values from the user
	static Scanner input = new Scanner(System.in);
	
	//List of integers, to store values from the users
	static ArrayList<Integer> values = new ArrayList<>();
	
	public static void main(String[] args) {	
		
		//Methods for reading the numbers, printing them back to the user and summing them.
		getNumbers();
		printNumbers();
		printSum();

	}
	
	static void getNumbers(){
		
		Integer in; //Variable to temporary store the value from the user.
		boolean sumation = true; //Bool to regulate when to exit the while loop
		
		//Message to user
		System.out.println("Type in integers. Type \"0\" when done.");
		
		while(sumation == true){
			//Uses the scanner object to read values from the user
			in  = input.nextInt();
			//Exits the loop if user types "0"
			if(in == 0){
				sumation = false;
			}
			else{
				//Adds the users values to the list "values"
				values.add(in);
			}
		}
	}
	
	static void printNumbers(){
		
		//Message to user
		System.out.println("Your numbers are:");
		
		//For loop that prints out each item in the list "values" seperated by a space
		for(int i = 0; i < values.size(); i++){
			System.out.printf("%d ", values.get(i));
		}
		
		//insterts two line shifts
		System.out.printf("\n\n");
	}
	
	static void printSum(){
		
		//Variable to store the sum of the values in the list "values" 
		int sum = 0;
		
		//For loop that sums together all the values in the list "values"
		for(int i  = 0; i < values.size(); i++){
			sum+= values.get(i);
		}
		
		//Prints out the sum to the user
		System.out.println("The sum of your numbers is " + sum);
	}

}
