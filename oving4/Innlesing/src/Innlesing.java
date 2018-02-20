import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Innlesing {

	public static void main(String[] args) throws FileNotFoundException{

		//The word that is going to be searched for
		String word;; 
		//word = "winnie-the-pooh";   \\ Used for task a and b
		
		//User interface to get the word from user.
		Scanner input = new Scanner(System.in);
		System.out.println("Type in a word that you want to count in the file winnie.txt:");
		word = input.nextLine();
		
		int numberOfWords = findNumberOfWords(word);
		
		System.out.println("Your word: \"" + word + "\" is mentioned " + numberOfWords + " times in the document \"winnie.txt\".");

	}

	//Method for opening the file, read trough it and find the occurance of "word"
	static int findNumberOfWords(String word) throws FileNotFoundException{
		//Creates a file object and a scanner that reads the file "winnie.txt"
		String fileName = "winnie.txt";
		File file = new File(fileName);
		Scanner inFile = new Scanner(file);
		
		//Integer to store the amount of times the word is written in the document "winnie.txt"
		int numberOfWords = 0;
		String line;
		
		//Loop that scans each line, and discards the symbols , . : ( ) ' ". 
		//If the line matches the word numberOfWords is increased. Difference in case is ignored
		while(inFile.hasNextLine()){
			line = inFile.nextLine().replaceAll("[,.:()'\"]","");
			if(line.equalsIgnoreCase(word))
				numberOfWords++;
		}
		
		//closes the file
		inFile.close();
		
		return numberOfWords;
	}
}
