import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordliste {

	private static ArrayList<Ord> ordliste = new ArrayList<Ord>();
	private static int i;
	private static boolean add;
	private Ord vanligste = new Ord();
	private String inString;
	
	//Metoder
	
	//Leser gjennom hele tekstfilen og legger til ord i ordlista.
	public void lesBok(String filnavn) throws FileNotFoundException{
		File fil = new File(filnavn);
		Scanner innFil = new Scanner(fil);

		while(innFil.hasNextLine()){
			inString = innFil.nextLine();	
			Ordliste.leggTilOrd(inString);
		}
		
		innFil.close();
		
	}
	
	private static void leggTilOrd(String ord){
		
		//Vi starter med aa anta at ordet ikke finnes i lista fra foer. Derfor add = true.
		add = true;
		//Deretter leser vi gjennom ordlista og ser om ordet er der.
		for(i = 0; i < ordliste.size(); i++){
			if(ord.equalsIgnoreCase(ordliste.get(i).toString())){
				//Hvis ordet finnes fra foer, skal det ikke legges til. Derfor add = false.
				add = false;
				//Men vi maa oeke antallet av forekomster i lista.
				ordliste.get(i).oekAntall();
			}
		}
		
		//Legger til ordet dersom det ikke finnes fra 
		//foer i ordliste ELLER ordlista er tom.
		if(add || (ordliste.size() == 0)){
			//Legger ordet inn i lista i smaa bokstaver
			ordliste.add(new Ord(ord.toLowerCase()));
		}
	}
	
	//Leter gjenom ordlista etter "tekst". Finnes det i lista blir det returnert,
	//hvis ikke blir "null" returnert
	public Ord finnOrd(String tekst) { 
		for(i = 0; i < ordliste.size(); i++){
			if(tekst.equalsIgnoreCase(ordliste.get(i).toString())){
				return ordliste.get(i);
			}
		}
		return null;
	}
	
	//Returnerer hvor mange forskjellige ord som er i ordlista
	public int antallOrd() {
		return ordliste.size();
	}
	
	//Returnerer hvor mange ganger ordet "tekst" er registrert
	public int antallForekomster(String tekst) {
		for(i = 0; i < ordliste.size(); i++){
			if(tekst.equalsIgnoreCase(ordliste.get(i).toString())){
				return ordliste.get(i).hentAntall();
			}
		}
		return 0;
	}

	//Finner det vanligste ordet.
	public Ord vanligste() {
		vanligste = ordliste.get(0);
		for(i = 1; i < ordliste.size(); i++){
			if(ordliste.get(i).hentAntall() > vanligste.hentAntall()){
				vanligste = ordliste.get(i);
			}
		}
		return vanligste;
	}
	
	
	//Skriver ut hele ordlista til terminalen. Brukt til testing og debugging
	public void skrivOrdliste(){
		for(i = 0; i < ordliste.size(); i++){
			System.out.println(ordliste.get(i) + " " + ordliste.get(i).hentAntall());
		}
	}
}
