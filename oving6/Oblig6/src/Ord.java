
public class Ord {

	//Ordet som objektet holder
	private String ordet;
	
	//Antall forekomser av ordet
	private int forekomst;
	
	//Konstruktoer. Naar ordet konstrueres blir det
	//registrert 1 stk forekomst av ordet 
	public Ord(String tekst){
		ordet = tekst;
		forekomst = 1;
	}
	//Konstruktoer for et blankt ord. Brukt for testing og debugging
	public Ord(){
		
	}
	
	
	//Metoder
	
	//Returnerer ordet
	public String toString(){
		return ordet;
	}
	
	//Returnerer antal forekomster av ordet
	public int hentAntall(){
		return forekomst;
	}
	
	//Registrerer 1stk forekomst av ordet
	public void oekAntall(){
		forekomst++;
	}
	
	
}
