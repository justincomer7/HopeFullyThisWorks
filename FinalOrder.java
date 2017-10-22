import java.text.DecimalFormat;

public class FinalOrder {
	
	String Phone;
	String Order;
	double Price;
	
	FinalOrder(){
		Phone = "";
		Order = "";
		Price = 0.0;
		
	}
	
	void setNumber(String num)
	{
		Phone = num;
	}
	void setUser(String User)
	{
		Order = User;
	}
	
	void setOrder(String order)
	{
		Order = Order + order;
	}
	
	void setNewPrice(double price)
	{
		Price = Price + price;
	}
	
	String getOrder()
	{
		return Order;
	}
	
	String getPrice()
	{
		//limits the number of decimal places so it represents a monetary price 
		DecimalFormat numberformat = new DecimalFormat("#.00");
		return numberformat.format(Price);
	}
	
	String getNumber()
	{
		return Phone;
	}
	
	/* void clearOrder()
	{
		String Order = "";
		double Price = 0.00;
	}*/

}
