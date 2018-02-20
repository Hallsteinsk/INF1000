import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DVDadministrasjon {

//Variabler
	private ArrayList<Person> navneliste = new ArrayList<Person>();
	
//Metoder	
	//Kommandoloekke
	public void kommando(){
		Scanner input = new Scanner(System.in);
		while(true){
			printMeny();
			int valg = Integer.parseInt(input.nextLine());
			if(valg == 1){
				System.out.println("Hva heter den nye personen?");
				nyPerson(input.nextLine());
			}
			else if(valg == 2){
				System.out.println("Hvem har kjøpt DVD-en?");
				String navn = input.nextLine();
				System.out.println("Hva er tittelen paa DVD-en?");
				String titel = input.nextLine();
				kjop(titel, navn);
			}
			else if(valg == 3){
				System.out.println("Hvem vil laane DVD-en?");
				String laaner = input.nextLine();
				System.out.println("Hvem skal DVD-en laanes fra?");
				String eier = input.nextLine();
				System.out.println("Hva er tittelen paa DVD-en?");
				String titel = input.nextLine();
				laan(titel, eier, laaner);
			}
			else if(valg == 4){
				System.out.println("Hvilken person vil du se? (* for alle)");
				String navn = input.nextLine();
				visPerson(navn);
			}
			else if(valg == 5){
				visOversikt();
			}
			else if(valg == 6){
				System.out.println("Hvem laaner DVD-en?");
				String laaner = input.nextLine();
				System.out.println("Hva er titelen på DVD-en?");
				String titel = input.nextLine();
				System.out.println("Hvem skal DVD-en returneres til?");
				String eier = input.nextLine();
				retur(titel, eier, laaner);
			}
			else if(valg == 7){
				break;
			}	
		}
		return;
	}
	
	//Metode for aa lese fra fil
	public void lesFil(String filnavn) throws FileNotFoundException{
		File fil = new File(filnavn);
		Scanner innFil = new Scanner(fil);
		
		String linje = null, person = null; 
		while(innFil.hasNextLine()){
			linje = innFil.nextLine();
			if(linje.equals("-")){
				System.out.println("Break");
				break;
			}
			else{
				nyPerson(linje);
				System.out.println(linje);
			}
		}
		while(innFil.hasNextLine()){
			if(linje.equals("-")){
				person = innFil.nextLine();
				System.out.println(person);
			}
			else{
				if(linje.charAt(0) == '*'){
					kjop(linje.substring(1), person);
					laan(linje.substring(1), person, innFil.nextLine());
					System.out.println("Laan");
				}
				else{
					kjop(linje, person);
					System.out.println("Kjop " + linje + " " + person);	
				}
			}
			linje = innFil.nextLine();	
		}
	}
	
	
	//Metoder til kommandoloekke
	//Printmeny
	private void printMeny(){
		System.out.println("MENY FOR DVD-ADMINISTRASJON");
		System.out.println("1: Ny person.");
		System.out.println("2: Kjop.");
		System.out.println("3: Laan.");
		System.out.println("4: Vis.");
		System.out.println("5: Oversikt.");
		System.out.println("6: Retur.");
		System.out.println("7: Avslutt.");	
	}
	
	//Menyvalg 1:
	private void nyPerson(String navn){
		navneliste.add(new Person(navn));
	}
	
	//Menyvalg 2:
	private void kjop(String titel, String eier){
		for(Person p: navneliste){
			if(p.getNavn().equalsIgnoreCase(eier)){
				if(p.finnArkiv(titel) == null){
					p.addDvd(titel);
					return;
				}
				else{
					System.out.println(eier + " eier allerede et eksemplar av " + titel);
					System.out.println();
					return;
				}
			}
		}
		System.out.println("Det er ingen som heter " + eier + ".");
		System.out.println();
	}
	
	//Menyvalg 3:
	private void laan(String titel, String eier, String laaner){
		for(Person pEier: navneliste){
			if(pEier.getNavn().equalsIgnoreCase(eier)){
				for(Person pLaaner: navneliste){
					if(pLaaner.getNavn().equalsIgnoreCase(laaner)){
						if(pEier.finnArkiv(titel) == null){
							System.out.println(pEier.getNavn() + " har ikke " + titel + " i sin DVDsamling.");
							return;
						}
						else{
							pEier.addUtlaanteDvd(titel, pLaaner);
							pLaaner.addLaantDvd(titel, pEier);
							return;	
						}
					}
				}
				System.out.println("Det er ingen som heter " + laaner + ".");
				System.out.println();
				return;
			}	
		}
		System.out.println("Det er ingen som heter " + eier + ".");
		System.out.println();
	}
	
	//Menyvalg 4:
	private void visPerson(String navn){
		if(navn.equals("*")){
			for(Person p: navneliste){
				System.out.println("Person: " + p.getNavn());
				ArrayList<DVD> liste = p.getArkiv();
				if(liste.size() > 0){
					System.out.println("DVDer " + p.getNavn() + " eier:");
					for(DVD dvd: liste){
						System.out.println(dvd.getNavn());
					}
				}
				else{
					System.out.println(p.getNavn() + " eier ingen DVDer");
				}				
				liste = p.getLaante();
				if(liste.size() > 0){
					System.out.println("DVDer " + p.getNavn() + " laaner:");
					for(DVD dvd: liste){
						System.out.println(dvd.getNavn() + " laant fra " + dvd.getEier().getNavn());
					}
				}
				else{
					System.out.println(p.getNavn() + " laaner ingen DVDer");
				}
				liste = p.getUtlaante();
				if(liste.size() > 0){
					System.out.println("DVDer " + p.getNavn() + " laaner ut:");
					for(DVD dvd: liste){
						System.out.println(dvd.getNavn() + " laanes ut til " + dvd.getLaaner().getNavn());
					}
				}
				else{
					System.out.println(p.getNavn() + " laaner ikke ut noen DVDer");
				}
				System.out.println();
			}
			return;
		}
		else{
			for(Person p: navneliste){
				if(p.getNavn().equalsIgnoreCase(navn)){
					System.out.println("Person: " + p.getNavn());
					ArrayList<DVD> liste = p.getArkiv();
					if(liste.size() > 0){
						System.out.println("DVDer " + p.getNavn() + " eier:");
						for(DVD dvd: liste){
							System.out.println(dvd.getNavn());
						}
					}
					else{
						System.out.println(p.getNavn() + " eier ingen DVDer");
					}				
					liste = p.getLaante();
					if(liste.size() > 0){
						System.out.println("DVDer " + p.getNavn() + " laaner:");
						for(DVD dvd: liste){
							System.out.println(dvd.getNavn() + " laant fra " + dvd.getEier().getNavn());
						}
					}
					else{
						System.out.println(p.getNavn() + " laaner ingen DVDer");
					}
					liste = p.getUtlaante();
					if(liste.size() > 0){
						System.out.println("DVDer " + p.getNavn() + " laaner ut:");
						for(DVD dvd: liste){
							System.out.println(dvd.getNavn() + " laanes ut til " + dvd.getLaaner().getNavn());
						}
					}
					else{
						System.out.println(p.getNavn() + " laaner ikke ut noen DVDer");
					}
					System.out.println();
					return;
				}	
			}
			System.out.println("Det er ingen som heter " + navn + ".");
			System.out.println();
		}

	}
	
	//Menyvalg 5:
	private void visOversikt(){
		for(Person p: navneliste){
			System.out.println("Person: " + p.getNavn());
			System.out.println("Eier: " + p.getArkiv().size());
			System.out.println("Laaner: " + p.getLaante().size());
			System.out.println("Utlaant: " + p.getUtlaante().size());
		}
		System.out.println();
	}
	
	//Menyvalg 6:
	private void retur(String titel, String eier, String laaner){
		for(Person pEier: navneliste){
			if(pEier.getNavn().equalsIgnoreCase(eier)){
				for(Person pLaaner: navneliste){
					if(pLaaner.getNavn().equalsIgnoreCase(laaner)){
						if(pEier.finnUtlaantDvd(titel) == null){
							System.out.println(pEier.getNavn() + " laaner ikke ut " + titel + ".");
							return;
						}
						else if(pLaaner.finnLaantDvd(titel) == null){
							System.out.println(pLaaner.getNavn() + " laaner ikke " + titel + ".");
							return;
						}
						else{
							pEier.removeUtlaanteDvd(titel);
							pLaaner.removeLaantDvd(titel);
							return;	
						}
					}
				}
				System.out.println("Det er ingen som heter " + laaner + ".");
				System.out.println();
				return;
			}	
		}
		System.out.println("Det er ingen som heter " + eier + ".");
		System.out.println();
	}
				
	
	

}
