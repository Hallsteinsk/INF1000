import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Valg {
	
	static class Party {
		//Variables
		String partyName;
		int numberOfVotes = 0;
		
		//Constructor
		public Party(String aPartyName){
			partyName = aPartyName;
		}
		
		//Method for adding vote
		public void addVotes(int number){
			numberOfVotes+= number;
		}	
	}
	
	//Static object declarations. Available to all methodes in class Valg
	static ArrayList<Party> parties = new ArrayList<Party>();
	static ArrayList<String> votes = new ArrayList<String>();
	
	static String fileName = "stemmer.txt";
	static File file = new File(fileName);
	
	//counting variables:
	static int i, j;
	
	
	//MAIN method
	public static void main(String[] args) throws FileNotFoundException {
	
		readFile();
		
		addParty("Ap");
		addParty("H");
		addParty("Sp");
		addParty("KrF");
		
		countVotes();
		
		printVotes();
		
		printPercentage();
		
		printWinner();
	}
	
	
	//Method for adding content in "stemmer.txt" to the array "votes":
	static void readFile() throws FileNotFoundException{
		Scanner inFile = new Scanner(file);
		
		while(inFile.hasNextLine()){
			votes.add(inFile.nextLine());
		}
		
		inFile.close();
	}
	
	//Method for adding party to the parties array
	static void addParty(String partyName){
		parties.add(new Party(partyName));	
	}
	
	//Method for counting the votes
	static void countVotes(){
		for(i = 0; i < votes.size(); i++){
			for(j = 0; j < parties.size(); j++){
				if(votes.get(i).equals(parties.get(j).partyName)){
					parties.get(j).addVotes(1);
				}
			}
		}		
	}
	
	//Method for printing out the number of votes each party got
	static void printVotes(){
		for(i = 0; i < parties.size(); i++){
			System.out.println(parties.get(i).partyName + " got " + parties.get(i).numberOfVotes + " votes.");
		}
		System.out.println();
	}
	
	//Method for printing out the percentage of the votes each party got
	static void printPercentage(){
		for(i = 0; i < parties.size(); i++ ){
			System.out.println(parties.get(i).partyName + " got " + ((double)parties.get(i).numberOfVotes*100)/votes.size() + "% of the votes.");
		}
		System.out.println();
	}
	
	//Method for finding the party who got the most votes
	static void printWinner(){
		int winner = 0;
		for(i = 0; i < parties.size() - 1; i++){
			if(parties.get(i).numberOfVotes > parties.get(winner).numberOfVotes){
				winner = i;
			}
		}
		System.out.println(parties.get(winner).partyName + " won the election!!!");
	}
}
