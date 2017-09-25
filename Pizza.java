import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pizza {

    public Connection connect() {
        String url = "jdbc:sqlite:C:\\Users\\justin\\eclipse-workspace\\DatabaseConnection\\src\\info.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public String addUser(String phone, String name, String address, String charge) {
    	String ifuser = "SELECT * FROM Users WHERE phone =?";
    	String sql = "INSERT INTO Users (phone, name, address, charge) VALUES (?,?,?,?)";
        try (Connection conn = this.connect();
                PreparedStatement checstmt = conn.prepareStatement(ifuser); 
            PreparedStatement pstmt = conn.prepareStatement(sql)){ 
            	checstmt.setString(1, phone);
                ResultSet rs = checstmt.executeQuery();
                if (rs.next()) return "false";
            pstmt.setString(1, phone);
            pstmt.setString(2, name);
            pstmt.setString(3, address);
            pstmt.setString(4, charge);
            pstmt.executeUpdate();
            return "true";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "false";
    }
    
    public String selectUser(String num) {
        String sql = "SELECT phone, name, address FROM Users WHERE phone = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, num);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return (rs.getString("phone") + "\n" + rs.getString("name") + "\n" + rs.getString("address"));
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
        return " ";
    }
    
    public String selectCard(String num) {
    	String sql = "SELECT name, charge FROM Users WHERE phone = ?";
    	
    	try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, num);
            ResultSet rs = pstmt.executeQuery();
           if(rs.next())
        	   if(rs.getString("charge") == " ")
        		   return "";
        	   else
                return (rs.getString("charge"));
            
        } catch (SQLException e) {
            return e.getMessage();
        }
    	
    return " ";
    }

    public String updateUser(String phone, String name, String address) {
        String sql = "UPDATE Users SET name = ?, address = ?WHERE phone = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, address);
         
            pstmt.setString(3, phone);
            pstmt.executeUpdate();
            return "true";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "false";
    }
    
    public String updateCard(String phone, String charge) {
    	String sql = "UPDATE Users SET charge = ? WHERE phone = ?";
    	
    	try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, charge);
            pstmt.setString(2, phone);
            pstmt.executeUpdate();
            return "true";
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    return "false";
    }
    

    public String addAddress(String phone, String sub, String intersection, String landmark, String other) {
        String sql = "INSERT INTO Address (phone, subdivision, intersection, landmark, other) VALUES (?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, phone);
            pstmt.setString(2, sub);
            pstmt.setString(3, intersection);
            pstmt.setString(4, landmark);
            pstmt.setString(5, other);
            pstmt.executeUpdate();
            return "true";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "false";
    }

    public String selectAddress(String num) {
        String sql = "SELECT subdivision, intersection, landmark, other FROM Address WHERE phone = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, num);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return (rs.getString("subdivision") + "\n" + rs.getString("intersection") + "\n" + rs.getString("landmark") + "\n" + rs.getString("other"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "false";
    }

    public String updateAddress(String phone, String sub, String intersection, String landmark, String other) {
        String sql = "UPDATE Address SET subdivision = ?, intersection = ?, landmark = ?, other = ? WHERE phone = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sub);
            pstmt.setString(2, intersection);
            pstmt.setString(3, landmark);
            pstmt.setString(4, other);
            pstmt.setString(5, phone);
            pstmt.executeUpdate();
            return "true";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "false";
    }

    public String addReciept(String phone, String details) {
        String sql = "SELECT id FROM Reciepts";
        int id = 1;

        try (Connection conn = this.connect();
                Statement getid = conn.createStatement()) {
            ResultSet rs = getid.executeQuery(sql);
            while (rs.next()) {
                id++;
            }
            sql = "INSERT INTO Reciepts (id, phone, details) VALUES (?,?,?)";
            PreparedStatement pstmt;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, phone);
            pstmt.setString(3, details);
            pstmt.executeUpdate();
            return "true";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "false";
    }

    public String selectReciept(int id) {
        String sql = "SELECT phone FROM Reciepts WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return (rs.getInt("id") + "\t" + rs.getString("phone") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "false";
    }

	public static void main(String args[]) {
	    Pizza newpizza = new Pizza();
	    newpizza.addUser("6785551895", "Tom Brady", "My address here", " ");
	    newpizza.updateCard("6785551895", "1234123412341234");
	    String user = newpizza.selectUser("6785551895");
	    String card = newpizza.selectCard("6785551895");
	    System.out.println("*****" + card + "*****");
	    System.out.println(user);
	    newpizza.updateUser("6785551895", "Tom Phillips", "My address here");
	    user = newpizza.selectUser("6785551895");
	    System.out.println(user);
	    newpizza.addAddress("6785551895", "Eatshit", "i-20", "The big chicken", "Leave on front door");
	    String address = newpizza.selectAddress("6785551895");
	    System.out.println(address);
	    newpizza.updateAddress("6785551895", "Rockyroad", "hemingway and hankman", "the big chicken", "Wait for me.");
	    address = newpizza.selectAddress("6785551895");
	    System.out.println(address);
	    newpizza.addReciept("6785551895", "Thin crust % pepperoni % large");

}}

