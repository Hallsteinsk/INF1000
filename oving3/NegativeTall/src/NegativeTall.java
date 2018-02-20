
public class NegativeTall {

	public static void main(String[] args) {
		
		//Oppgave 3.4a
		//Array of integer from task specification
		int[] heltall = {1, 4, 5, -2, -4, 6, 10, 3, -2};
		
		int index = 0;
		int numberOfNegative = 0;
		
		while(index < heltall.length){
			if(heltall[index] < 0){
				numberOfNegative++;
			}
			index++;
		}
		
		System.out.println("Number of negatice numbers: " + numberOfNegative);

		//Oppgave 3.4b
		index = 0;
		while(index < heltall.length){
			if(heltall[index] < 0){
				heltall[index] = index;
			}
			//Oppgave 3.4c
			System.out.printf("heltall[%d] = %d\n", index, heltall[index]);
			index++;
		}
		
	}

}
