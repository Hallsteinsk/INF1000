
// Food class. Contains name and price of a grocery article
public class Food {

	private String name;
	private double price;
	
	public Food(String aname, double aPrice){
		name = aname;
		price = aPrice;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
}
