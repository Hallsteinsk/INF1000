
public class Isbod {
	private String[] ansatte = new String[10];
	private int antallAnsatte, i;
	
	public Isbod(){
		antallAnsatte = 0;
	}
	
	public void ansett(String navn){
		if(antallAnsatte >= 10){
			System.out.println("Du har 10 ansatte og kan ikke ansette fler.");
		}
		else{
			ansatte[antallAnsatte] = navn;
			antallAnsatte++;
		}
	}
	
	public void giSistemanSparken(){
		if(antallAnsatte > 0){
			System.out.println(ansatte[antallAnsatte-1] + " fikk sparken.");
			ansatte[antallAnsatte] = null;
			antallAnsatte--;
		}
		else{
			System.out.println("Du har ingen ansatte, og kan derfor ikke sparke noen.");
		}

	}
	
	public void printAlleAnsatte(){
		System.out.println("Her er alle ansatte:");
		for(i = 0; i < antallAnsatte; i++){
			System.out.println(ansatte[i]);
		}
	}

}
