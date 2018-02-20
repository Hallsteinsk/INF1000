import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MinOppgave4 {
	
	static class Location{
		public String place;
		public String what;
		
		//Coordinates
		public int latitudeDeg;
		public int latitudeMin;
		public double latitudeSec;
		public String latitudeDir;
		
		public int longitudeDeg;
		public int longitudeMin;
		public double longitudeSec;
		public String longitudeDir;
	}
	
	//Static objects
	static String fileName = "cool.txt";
	static File file = new File(fileName);
	
	
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<Location> locations = new ArrayList<Location>();
		locations = readFile();
		printLocations(locations);
		
		
	}
	
	static ArrayList<Location> readFile() throws FileNotFoundException{
	
		ArrayList<Location> locations = new ArrayList<Location>();
		
		Scanner inFile = new Scanner(file);
		
		int i = 0;
		
		while(inFile.hasNextLine()){
				//Adds a new item to locations list
				locations.add(new Location());
				//Reads first line an removes numbers, comas and periods
				String what = inFile.nextLine().replaceAll("[0-9.,]", "");
				//Trim away white space at the start and end of the line
				locations.get(i).what = what.trim();
				
				//Reads inn the coordinates from the file
				locations.get(i).latitudeDeg = inFile.nextInt();
				locations.get(i).latitudeMin = inFile.nextInt();
				locations.get(i).latitudeSec = inFile.nextDouble();
				locations.get(i).latitudeDir = inFile.next("[NS]");
				
				locations.get(i).longitudeDeg = inFile.nextInt();
				locations.get(i).longitudeMin = inFile.nextInt();
				locations.get(i).longitudeSec = inFile.nextDouble();
				locations.get(i).longitudeDir = inFile.next("[WE]");
				
				//Shifts down to the next line
				inFile.nextLine();
				
				//Reads in the location from the file
				locations.get(i).place = inFile.nextLine();
				
				if(inFile.hasNextLine()){
					inFile.nextLine();
				}
				
				
				i++;
				
			}
			
		inFile.close();
			
		return locations;
	}
	
	static void printLocations(ArrayList<Location> locations){
		
		
		for(int i = 0; i < locations.size(); i++){
			System.out.println(locations.get(i).what + ": " + locations.get(i).place);
			System.out.printf("%d\u00b0%d'%.2f\"%s, %d\u00b0%d'%.2f\"%s\n\n", locations.get(i).latitudeDeg, 
				locations.get(i).latitudeMin,
				locations.get(i).latitudeSec,
				locations.get(i).latitudeDir,
				locations.get(i).longitudeDeg,
				locations.get(i).longitudeMin,
				locations.get(i).longitudeSec,
				locations.get(i).longitudeDir);
		
		}
		
		
	}
}
