import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccessOrder {
	
	Connection con;
	
	public AccessOrder(Connection con) {
		this.con = con;
	}
	
	public void add(Order o) {
		String query = " insert into mydb.order (order_id, client_client_id, product_product_id, quantity, price, date_created, expected_arrival)" + " values (?, ?, ?, ?, ?, ?, ?)";
		try {
		PreparedStatement preparedStmt = this.con.prepareStatement(query);
		preparedStmt.setInt (1, o.order_id);
	    preparedStmt.setInt (2, o.client_client_id);
	    preparedStmt.setInt(3, o.product_product_id);
	    preparedStmt.setInt    (4, o.quantity);
	    preparedStmt.setFloat    (5, o.price);
	    preparedStmt.setDate(6, o.dateCreated);
	    preparedStmt.setDate(7, o.expectedArrival);
	    preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String attribute) throws NumberFormatException {
		try {
		PreparedStatement preparedStmt = this.con.prepareStatement("DELETE FROM mydb.order WHERE order_id = ?");
		preparedStmt.setInt(1, Integer.parseInt(attribute));
		preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}