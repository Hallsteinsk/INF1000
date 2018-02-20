import java.util.Scanner;

public class EnkelKalkulator {

	public static void main(String[] args) {
		// Objects
		Scanner input = new Scanner(System.in);

		// Variables
		int number_1, number_2;

		// User interface
		System.out.println("Type in a number:");
		number_1 = Integer.parseInt(input.nextLine());
		System.out.println("Type in a second number:");
		number_2 = Integer.parseInt(input.nextLine());
		System.out.printf("Your numbers are %d and %d\n", number_1, number_2);

		// Perform the calculator methods with the numbers: number_1 and number_2
		add(number_1, number_2);
		subtract(number_1, number_2);
		multiply(number_1, number_2);
	}

	// Addition method
	static void add(int number_1, int number_2) {
		int sum = number_1 + number_2;
		System.out.printf("The sum of %d and %d is %d\n", number_1, number_2, sum);
	}

	// Subtraction method
	static void subtract(int number_1, int number_2) {
		int sub = number_1 - number_2;
		System.out.printf("%d subtracted from %d is %d\n", number_2, number_1, sub);
	}

	// Multiplication method
	static void multiply(int number_1, int number_2) {
		int mult = number_1 * number_2;
		System.out.printf("%d multiplied by %d is %d\n", number_1, number_2, mult);
	}

}