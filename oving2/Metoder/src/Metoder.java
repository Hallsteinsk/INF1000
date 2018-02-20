import java.util.Scanner;

public class Metoder {

	// Objects. Using modifier static to make object available for all methodes in class
	static Scanner input = new Scanner(System.in); 

	// Variables. Using modifier static to make variables available for all methods in class
	static String name; 
	static String town;

	public static void main(String[] args) {

		// Run the gatherInfo method 3 times
		for (int i = 0; i < 3; i++) {
			gatherInfo();
		}
	}

	//Method for reading in info from the user
	static void gatherInfo() {
		// User interface
		System.out.printf("Skriv inn navn:\n");
		name = input.nextLine();
		System.out.printf("Skriv inn bosted\n");
		town = input.nextLine();
		System.out.printf("Hei, %s! Du bor i %s.\n\n", name, town);
	}

}
