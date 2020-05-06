import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CalculateStatus {
		
	Connection con;
	public CalculateStatus(Connection con) {
		this.con = con;
	}
	
	public String checkOrder(Order o) {
		try {
		Statement stmt = con.createStatement();
		int sum = 0;
		ResultSet rs = stmt.executeQuery("select sum(quantity) as sum from mydb.product where product_id = " + o.product_product_id);
		if(rs.next())
			sum = rs.getInt("sum");
		String name = "";
		rs = stmt.executeQuery("select name from mydb.product where product_id = " + o.product_product_id);
		if(rs.next())
			name = rs.getString("name");
		if(sum > o.quantity)
			return "Order " + o.order_id + " of " + o.quantity + " " + name + " is ok\n";
		else return "Order " + o.order_id + " requires " + (o.quantity - sum) + " more of " + name + "\n";
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String checkDate(Order o) {
		try {
			Statement stmt = con.createStatement();
			Date date = null;
			ResultSet rs = stmt.executeQuery("select expected_arrival as date from mydb.order where order_id = " + o.order_id);
			if(rs.next())
				date = rs.getDate("date");
			Date currDate = new Date(System.currentTimeMillis());
			if(currDate.compareTo(date) >= 0)
				return "Order " + o.order_id + " is due!\n";
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public Boolean checkOk(Order o) {
		
		try {
			Statement stmt = con.createStatement();
			int sum = 0;
			ResultSet rs = stmt.executeQuery("select sum(quantity) as sum from mydb.product where product_id = " + o.product_product_id);
			if(rs.next())
				sum = rs.getInt("sum");
			if(sum > o.quantity)
				return true;
			else return false;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
			
	}
}
