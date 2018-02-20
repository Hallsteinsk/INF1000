import java.util.Scanner;

public class UserInterface {
	
	private Scanner input = new Scanner(System.in); 
	private CashRegister myCashRegister = new CashRegister();
	private String name, action, inString;
	private double price;
	private int amount;
	private boolean cont;
	
	//constructor
	public UserInterface(){
		cont = true;
	}
	
	//Method for controling how the program should run
	public void runProgram(){
		while(true){
			System.out.println("To start a new receipt type: \"new customer\". To end the program type: \"end\"");
			inString = input.nextLine();
			
			if(inString.equalsIgnoreCase("new customer")){
				while(cont){
					printMenu();
				}
			}
			else if(inString.equalsIgnoreCase("end")){
				break;
			}
		}
	}
	
	//Prints out a menu
	public void printMenu(){
		System.out.println("Press 1 to add an item.\nPress 2 to add more than one of an item.\nPress 3 when you are done. ");
		readFromUser();
	}
	
	// Method for getting input from the user
	public void readFromUser(){
		action = input.nextLine();
		
		if(Integer.parseInt(action) == 1) {
			System.out.println("Type the name of the item:");
			name = input.nextLine();
			System.out.println("Type the price of the item:");
			price = Double.parseDouble(input.nextLine());
			myCashRegister.addItem(name, price);
			System.out.println("Test");
		}
		else if(Integer.parseInt(action) == 2){
			System.out.println("Type the name of the item:");
			name = input.nextLine();
			System.out.println("Type the price of the item:");
			price = Double.parseDouble(input.nextLine());
			System.out.println("Type in how many items it is:");
			amount = Integer.parseInt(input.nextLine());
			myCashRegister.addItems(amount, name, price);
		}
		else if(Integer.parseInt(action) == 3){
			myCashRegister.printReceipt();
			cont = false;
			System.out.println();
		}
		else{
			printMenu();
		}
	}

}
