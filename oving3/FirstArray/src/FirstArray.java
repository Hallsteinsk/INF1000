import java.util.Scanner;

public class FirstArray {


	public static void main(String[] args) {
		
		//Oppgave 3.2a
		//int[] values = {0, 1, 2, 3};  
		
		//Oppgaver 3.2b
		int[] values = new int[4];
		
		for(int i = 0; i < 4; i++){
			values[i] = i;
		}
		
		//Oppgave 3.2c
		values[0] = values[3] = 1337;

		//Oppgave 3.2d
		Scanner input = new Scanner(System.in);
		
		String[] names = new String[5];
		
		System.out.println("Type in 5 names:");
		for(int i = 0; i < 5; i++){
			names[i] = input.nextLine();
		}
		
		//Oppgave 3.2e
		int i = 0;
		System.out.println("\nContent of int array:");
		while(i < 4){
			System.out.println(values[i]);
			i++;
		}
		
		System.out.println();
		
		i = 0;
		System.out.println("Content of string array:");
		while(i < 5){
			System.out.println(names[i]);
			i++;
		}
		
		
		
	}

}
