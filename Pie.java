
public class Pie {
	
	String PhoneNumber;
	String Size;
	String Sauce;
	String Crust;
	String Toppings;
	String Extras;
	Double Price = 0.00;
	
	Pie(){
		PhoneNumber = "";
		Size = "";
		Sauce = "";
		Crust = "";
		Toppings = "";
		Extras = "";
	}
	
	void setPrice(double price)
	{
		Price = Price + price;
	}
	
	void setPhoneNumber(String number)
	{
		PhoneNumber = number;
	}
	
	void setSize(String size)
	{
		Size = size;
	}
	
	void setSauce(String sauce)
	{
		Sauce = sauce;
	}
	
	void setCrust(String crust)
	{
		Crust = crust;
	}
	
	void setToppings(String toppings)
	{
		Toppings = Toppings + toppings + " ";
	}
	
	void setExtras(String extras)
	{
		Extras = Extras + extras + " ";
	}
	
	String getPizza()
	{
		return ("Size: " + Size+"\nSauce: "+Sauce+"\nCrust: "+Crust+"\nToppings: "+Toppings+"\nExtras: " + Extras+"\n");
		
	}
	
	double getPrice()
	{
		return Price;
	}
	
	void clearPizza()
	{
		Toppings = "";
		PhoneNumber = "";
		Size = "";
		Sauce = "";
		Crust = "";
		Extras = "";
	}

}
