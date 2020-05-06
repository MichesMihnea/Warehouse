import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccessClient {
	
	Connection con;
	
	public AccessClient(Connection con) {
		this.con = con;
	}
	
	public void add(Client c) {
		String query = " insert into client (client_id, name, phone, address)" + " values (?, ?, ?, ?)";
		try {
		PreparedStatement preparedStmt = this.con.prepareStatement(query);
		preparedStmt.setInt (1, c.client_id);
	    preparedStmt.setString (2, c.name);
	    preparedStmt.setString(3, c.phone);
	    preparedStmt.setString    (4, c.address);
	    preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String attribute, int mode) throws NumberFormatException{
		try {
		if(mode == 1) {
		PreparedStatement preparedStmt = this.con.prepareStatement("DELETE FROM client WHERE client_id = ?");
		preparedStmt.setInt(1, Integer.parseInt(attribute));
		preparedStmt.executeUpdate();
		}
		if(mode == 2) {
			PreparedStatement preparedStmt = this.con.prepareStatement("DELETE FROM client WHERE name = ?");
			preparedStmt.setString(1, attribute);
			preparedStmt.executeUpdate();
		}
		if(mode == 3) {
			PreparedStatement preparedStmt = this.con.prepareStatement("DELETE FROM client WHERE phone = ?");
			preparedStmt.setString(1, attribute);
			preparedStmt.executeUpdate();
		}
		if(mode == 4) {
			PreparedStatement preparedStmt = this.con.prepareStatement("DELETE FROM client WHERE address = ?");
			preparedStmt.setString(1, attribute);
			preparedStmt.executeUpdate();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
