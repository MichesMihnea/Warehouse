import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccessProduct {

	Connection con;
	
	public AccessProduct(Connection con) {
		this.con = con;
	}
	
	public void add(Product p) {
		String query = " insert into mydb.product (product_id, name, manufacturer, quantity)" + " values (?, ?, ?, ?)";
		try {
		PreparedStatement preparedStmt = this.con.prepareStatement(query);
		preparedStmt.setInt (1, p.product_id);
	    preparedStmt.setString (2, p.name);
	    preparedStmt.setString(3, p.manufacturer);
	    preparedStmt.setInt    (4, p.quantity);
	    preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String attribute, int mode) throws NumberFormatException{
		try {
		if(mode == 1) {
		PreparedStatement preparedStmt = this.con.prepareStatement("DELETE FROM mydb.product WHERE product_id = ?");
		preparedStmt.setInt(1, Integer.parseInt(attribute));
		preparedStmt.executeUpdate();
		}
		if(mode == 2) {
			PreparedStatement preparedStmt = this.con.prepareStatement("DELETE FROM mydb.product WHERE name = ?");
			preparedStmt.setString(1, attribute);
			preparedStmt.executeUpdate();
		}
		if(mode == 3) {
			PreparedStatement preparedStmt = this.con.prepareStatement("DELETE FROM mydb.product WHERE manufacturer = ?");
			preparedStmt.setString(1, attribute);
			preparedStmt.executeUpdate();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
