import java.util.ArrayList;
import java.util.Scanner;

public class MinOppgave3 {

	//Objects available for alle methods class
	static Scanner input = new Scanner(System.in);
	static ArrayList<Employee> employees = new ArrayList<Employee>();
	

	
	public static void main(String[] args) {
		
		addEmployees();
		if(employees.size() > 0){
			printNumbersOfEmployees();
			printEmployees();		
		}
		else {
			System.out.println("You have no employees.");
		}
		
	}
	
	//Method for adding employees
	static void addEmployees(){
		
		String name, position, yesOrNo;
		int id;
		
		//"Infinite loop" that runs until broken. Each loop adds an employee
		while(true){
			System.out.println("Do you want to add a new employee? Type \"yes\" or \"no\".");
			yesOrNo = input.nextLine();

			if(yesOrNo.equals("yes")){
				System.out.println("Type the name of the new employee:");
				name = input.nextLine();
				System.out.println("Give the employee an integer ID code:");
				id = Integer.parseInt(input.nextLine());
				System.out.println("Type in the employees position:");
				position = input.nextLine();
				System.out.println();
				
				employees.add(new Employee(name, id, position));
			}
			else if(yesOrNo.equals("no")){
				System.out.println();
				break; //Exits the while loop
			}
			else{
				System.out.println("Try again..."); //Gives feedback to the user, if they dont type yes or no
			}				
		}
	}
	
	//Method for printing out all the info about all the employees
	static void printEmployees(){
		Employee anEmployee;
		
		System.out.println("Here is a list of your employees:\n");
		
		for(int i = 0; i < employees.size(); i++){
			anEmployee = employees.get(i);
			anEmployee.printInfo();
			System.out.println();
		}
	}
	
	//Method for printing out the total number of employees
	static void printNumbersOfEmployees(){
		System.out.println("You have " + employees.size() +" employees.\n");
	}
}
