import java.util.Scanner;

public class Employee {

	//Variables
	private String name;
	private int id;
	private String position;
	
	//Constructors:
	//Constructor with values at name, id and position
	public Employee(String aName, int anId, String aPosition){
		
		name = aName;
		id = anId;
		position = aPosition;
	}
	
	//Constructor with values at name and id
	public Employee(String aName, int anId){
		
		name = aName;
		id = anId;
		position = null;
	}
	
	//Constructor with values only at name
	public Employee(String aName){
		
		name = aName;
		id = 0;
		position = null;
	}
	
	
	//Methods
	//Method for editing the values.
	public void enterInfo(String aName, int anId, String aPosition){
		
		name = aName;
		id = anId;
		position = aPosition;
	}
	
	//Method for printing out the values.
	public void printInfo(){
		System.out.println("Name: " + name);
		System.out.println("ID: " + id);
		System.out.println("Position: " + position);	
	}
}

