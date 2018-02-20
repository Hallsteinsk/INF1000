
public class Oppgave54 {

	public static void main(String[] args) {
		Isbod isbodenMin = new Isbod();
		
		isbodenMin.ansett("Odd Ronny Hansen");
		isbodenMin.ansett("Johnny Reidar Petterson");
		isbodenMin.ansett("Trude Margit Larsen");
		
		isbodenMin.printAlleAnsatte();
		
		System.out.println();
		
		isbodenMin.giSistemanSparken();
		
		System.out.println();
		
		isbodenMin.printAlleAnsatte();
		
		

	}

}
