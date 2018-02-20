
public class Kalkulator {

	public static void main(String[] args) {
		
		//Test for å se om kalkulatormetodene er riktige:
		int addSvar = addisjon(3, 4);
		int subSvar = subtraksjon(5, 2);
		int helDivSvar = heltallsdivisjon(10, 3);
		double divSvar = divisjon(10, 3);
		
		System.out.println("addSvar = " + addSvar);
		System.out.println("subSvar = "+ subSvar);
		System.out.println("helDivSvar = " + helDivSvar);
		System.out.println("divSvar = " + divSvar);
		
	}
	//Oppgave 4.3a)
	static int addisjon(int a, int b){
		return a + b;
	}
	
	//Oppgave 4.3b)
	static int subtraksjon(int a, int b){
		return a - b;
	}
	
	//Oppgave 4.3c)
	static int heltallsdivisjon(int a, int b){
		return a / b;
	}
	
	//Oppgave 4.3d)
	static double divisjon(double a, double b){
		return a / b;
	}
}
