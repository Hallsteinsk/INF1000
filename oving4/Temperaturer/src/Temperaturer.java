import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Temperaturer {
	
	//Array to hold the temperatures from the file
	static int[] temperatures = new int[12];

	//Methodes that handles files uses throws FileNotFoundException in case file is not found
	public static void main(String[] args) throws FileNotFoundException { 
		
		readFile("temperaturer.txt");

		double averageTemp = findAverageTemp();
		
		System.out.printf("The average temperature this year is: %.2f\n", averageTemp);

	}
	
	static void readFile(String fileName) throws FileNotFoundException{
		//Creates a file object and a scanner that reads the file
		File temperatureFile = new File(fileName);
		Scanner inFile = new Scanner(temperatureFile);
		
		int index = 0;
		
		//While loop that reads each line in the file, and stores each 
		//line in the temperatures array
		while(inFile.hasNextLine()){
			temperatures[index] = Integer.parseInt(inFile.nextLine());
			index++;
		}
		
		//closes the file
		inFile.close();
		
	}
	
	static double findAverageTemp(){
		int sum = 0;
		double averageTemp;
		
		//For loop that sums the values in the temperature array
		for(int i = 0; i < temperatures.length; i++){
			sum+= temperatures[i];
		}
		
		//Calculates the average temperature
		averageTemp = (double)sum/12;
		
		return averageTemp;
	}

}
