
public class Oppgave51 {

	public static void main(String[] args) {
		
		double tankstorrelse = 50;//liter
		double literPerKilometer = 1.2; // liter/km
		
		Bil bilenMin = new Bil(tankstorrelse, literPerKilometer);
		
		bilenMin.kjorTur(10);
		bilenMin.kjorTur(5);
		bilenMin.kjorTur(100);
		
		bilenMin.fyllTank(30);
		
		bilenMin.kjorTur(15);
		
		System.out.printf("Bilen har totalt kjoert %.1fkm\n", bilenMin.hentKilometerstand());	
	}

}
