
public class FinalOrder {
	
	String Phone = " ";
	String Order;
	double Price;
	
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
	
	double getPrice()
	{
		return Price;
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
