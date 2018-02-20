
public class DVD {
	
	//Variabler
	private String navn;
	private Person eier;
	private Person laaner;
	
	//Konstruktoerer
	public DVD(String navn){
		this.navn =  navn;
	}
	
	public DVD(String navn, Person eier){
		this.navn =  navn;
		this.eier = eier;
	}
	
	public DVD(String navn, Person eier, Person laaner){
		this.navn =  navn;
		this.eier = eier;
		this.laaner = laaner;
	}

	//Getters and Setters
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Person getEier() {
		return eier;
	}

	public void setEier(Person eier) {
		this.eier = eier;
	}

	public Person getLaaner() {
		return laaner;
	}

	public void setLaaner(Person laaner) {
		this.laaner = laaner;
	}
}
