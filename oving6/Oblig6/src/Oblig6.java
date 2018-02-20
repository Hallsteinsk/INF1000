import java.io.FileNotFoundException;

public class Oblig6 {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Oppgave 6.3
		
		//Opretter en ny ordliste
		Ordliste ordliste = new Ordliste();
		
		//Leser inn teksten "scarlet.text"
		ordliste.lesBok("scarlet.text");
		
		
		//6.3.a)
		System.out.println("Det forekommer " + ordliste.antallOrd() + " forskjellige ord i boken.");
		
		//6.3.b)
		System.out.println("Ordet \"Holmes\" forekommer " + ordliste.antallForekomster("Holmes") + " ganger.");
		
		//6.3.c)
		System.out.println("Ordet \"elementary\" forekommer " + ordliste.antallForekomster("elementary") + " ganger.");
		
		//6.3.d)
		System.out.println("Ordet \"" + ordliste.vanligste() + "\" forekommer flest ganger.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//Deloppgave 6.1
		
		//Oppretter to forekomster av ord
		Ord foersteOrd = new Ord("skog");
		Ord andreOrd = new Ord("bjerk");
		
		//Tester oekAntall
		foersteOrd.oekAntall();
		
		//tester toString og hentAntall metodene
		System.out.println(foersteOrd.toString() + " forekommer " + foersteOrd.hentAntall() + " ganger.");
		System.out.println(andreOrd.toString() + " forekommer " + andreOrd.hentAntall() + " ganger.");
		*/
		
	
		
		
		
		

	}

}
