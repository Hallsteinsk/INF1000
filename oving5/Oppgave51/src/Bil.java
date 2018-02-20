
public class Bil {

	private double kilometerstand;
	private double literPaaTanken;
	private final double TANKSTORRELSE;
	private final double LITER_PER_KM;
	
	
	//Constructor
	public Bil(double aTANKSTORRELSE, double aLITER_PER_KM){
		TANKSTORRELSE = aTANKSTORRELSE;
		LITER_PER_KM = aLITER_PER_KM;
		kilometerstand = 0;
		literPaaTanken = aTANKSTORRELSE;
	}
	
	// Nok bensin? Kjor "km" kilometer.
	public void kjorTur(int km) {  
		
		if(km == hentMaksDistanse()){
			System.out.println("Du rakk akurat aa kjoere " + km +"km. Du er naa tom for bensin.");
			kilometerstand+= hentMaksDistanse();
			literPaaTanken = 0;
		}
		else if(km > hentMaksDistanse()){
			System.out.printf("Du kjoerte %.1fkm, foer du gikk tom for bensin...\n", hentMaksDistanse());
			kilometerstand+= hentMaksDistanse();
			literPaaTanken = 0;
		}
		else if(km < hentMaksDistanse()){
			System.out.println("Du kjoerte " + km + "km.");
			kilometerstand+= km;
			literPaaTanken-= (km*LITER_PER_KM);
		}
	}
	
	// Fyll tanken, dersom det er plass til spesifisert mengde bensin.
	public void fyllTank(double liter) {
		
		if(liter == hentMaksLiter()){
			System.out.println("Du fylte " + liter + " liter. Tanken er full");
			literPaaTanken = TANKSTORRELSE;
		}
		else if(liter > hentMaksLiter()){
			System.out.println("Du prover aa fylle for mye bensin. Du faar kun fylt paa " + hentMaksLiter() + " liter.");
			literPaaTanken = TANKSTORRELSE;
		}
		else if(liter < hentMaksLiter()){
			System.out.println("Du fylte " + liter + " liter paa tanken.");
			literPaaTanken+= liter;
		}
	}
	
	// Hent maksimal kjøredistanse, gitt bensinmengde på tanken.
	public double hentMaksDistanse() {
		double maxKilometer = literPaaTanken/LITER_PER_KM; 
		return maxKilometer;
	}
	
	// Hent maksimal liter du kan fylle paa tanken, foer den blir full.
	public double hentMaksLiter() {
		double maxLiter = TANKSTORRELSE - literPaaTanken; 
		return maxLiter;
	}
	
	// Hent bilens totale kilometerstand.
	public double hentKilometerstand() { 
		return kilometerstand;
	}
	
	// Hent hvor mange liter bensin det er paa tanken
	public double hentLiter(){
		return literPaaTanken;
	}
	
	
}
