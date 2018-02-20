import java.util.ArrayList;

public class Person {

//Variabler
	private String navn;
	//DVD arrays
	private ArrayList<DVD> arkiv = new ArrayList<DVD>();
	private ArrayList<DVD> laante = new ArrayList<DVD>();
	private ArrayList<DVD> utlaante = new ArrayList<DVD>();
	
//Konstruktoer
	public Person(String navn){
		this.navn = navn;
	}
	
//Metoder	

	//Getters and Setters
	public String getNavn(){
		return navn;
	}
	
	public void setNavn(String navn){
		this.navn = navn;
	}
	
	public ArrayList getArkiv(){
		return arkiv;
	}
	
	public ArrayList getLaante(){
		return laante;
	}
	
	public ArrayList getUtlaante(){
		return utlaante;
	}
	
	//Andre metoder
	
	//Legg til DVD i arkiv-listen
	public void addDvd(String dvdNavn){
		arkiv.add(new DVD(dvdNavn, this));
	}
	
	//Finner en DVD i arkiv-lista
	public DVD finnArkiv(String dvdNavn){
		for(DVD dvd: arkiv){
			if(dvd.getNavn().equalsIgnoreCase(dvdNavn)){
				return  dvd;
			}
		}
		return null;
	}
	
	//Fjerner en DVD fra arkiv-listen
	public void removeArkiv(String dvdNavn){
		int index = 0;
		for(DVD dvd: arkiv){
			if(dvd.getNavn().equalsIgnoreCase(dvdNavn)){
				arkiv.remove(index);
				return;
			}
			index++;
		}
		System.out.println("DVDen " + dvdNavn + " finnes ikke i samlingen til " + navn + ".");
	}
	
	
	//Legg til DVD i listen over laante DVDer
	public void addLaantDvd(String dvdNavn, Person eier){
		laante.add(new DVD(dvdNavn, eier, this));
	}
	
	//Finner en DVD i lista over laante DVDer
	public DVD finnLaantDvd(String dvdNavn){
		for(DVD dvd: laante){
			if(dvd.getNavn().equalsIgnoreCase(dvdNavn)){
				return  dvd;
			}
		}
		return null;
	}
	
	//Fjerner en DVD fra listen over laante DVDer.
	public void removeLaantDvd(String dvdNavn){
		int index = 0;
		for(DVD dvd: laante){
			if(dvd.getNavn().equalsIgnoreCase(dvdNavn)){
				laante.remove(index);
				return;
			}
			index++;
		}
		System.out.println(navn + " laaner ikke " + dvdNavn + ".");
	}
	

	//Legg til DVD i listen over utlaante DVDer
	public void addUtlaanteDvd(String dvdNavn, Person laaner){
		utlaante.add(new DVD(dvdNavn, this, laaner));
	}
	
	//Finner en DVD i lista over utlaante DVDer
	public DVD finnUtlaantDvd(String dvdNavn){
		for(DVD dvd: utlaante){
			if(dvd.getNavn().equalsIgnoreCase(dvdNavn)){
				return  dvd;
			}
		}
		return null;
	}
	
	//Fjerner en DVD fra listen over utlaante DVDer.
	public void removeUtlaanteDvd(String dvdNavn){
		int index = 0;
		for(DVD dvd: utlaante){
			if(dvd.getNavn().equalsIgnoreCase(dvdNavn)){
				utlaante.remove(index);
				return;
			}
			index++;
		}
		System.out.println(navn + " laaner ikke ut " + dvdNavn + ".");
	}
	
	
		
}
