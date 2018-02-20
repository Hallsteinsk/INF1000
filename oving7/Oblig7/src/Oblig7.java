import java.io.FileNotFoundException;

public class Oblig7 {

	public static void main(String[] args) throws FileNotFoundException {
		DVDadministrasjon test = new DVDadministrasjon();
		
		test.lesFil("dvdarkiv.txt");
		test.kommando();
		
		
		System.out.println("Ferdig");

	}

}
