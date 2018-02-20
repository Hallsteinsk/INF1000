import java.util.ArrayList;

//Class for simulating a cash register.
public class CashRegister {
	
	private ArrayList<Food> receipt = new ArrayList();
	private int i;
	private double sum;
	
	//Method for adding one item
	public void addItem(String name, double price){
		receipt.add(new Food(name, price));
		sum+= price;
	}
	
	//Method for adding more than one of an item
	public void addItems(int amount, String name, double price){
		for(i = 0; i < amount + 1; i++){
			receipt.add(new Food(name, price));
			sum+= price;
		}
	}
	
	//Method for printing receipt in the terminal
	public void printReceipt(){
		for(i = 0; i < receipt.size(); i++){
			System.out.println(receipt.get(i).getName() + " " + receipt.get(i).getPrice() + "$");
		}
		System.out.println("Total: " + sum + "$");
	}
	
}
