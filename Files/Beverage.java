
public class Beverage {
	
	String drinks = "";
	double price = 0.0;
	
	void setBeverage(String bev)
	{
		drinks = drinks + bev + "\n";
	}
	
	void addPrice(double dollar)
	{
		price = price + dollar;
	}
	
	String getBeverage()
	{
		return drinks;
	}
	
	double getPrice()
	{
		return price;
	}
	
	void clearBev()
	{
		drinks = "";
		price = 0.00;
	}

}
