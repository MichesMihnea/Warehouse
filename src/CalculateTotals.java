import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CalculateTotals {
		
		Connection con;
		
		public CalculateTotals(Connection con) {
			this.con = con;
		}
		
		public int getClients() {
			try {
				ResultSet rs;
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("select count(*) as count from mydb.client");
				if(rs.next())
					return rs.getInt("count");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		public int getOrders() {
			try {
				ResultSet rs;
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("select count(*) as count from mydb.order");
				if(rs.next())
					return rs.getInt("count");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		public int getProducts() {
			try {
				ResultSet rs;
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("select count(*) as count from mydb.product");
				if(rs.next())
					return rs.getInt("count");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		public float getIncome() {
			try {
				ResultSet rs;
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("select sum(price) as sum from mydb.order");
				if(rs.next())
					return rs.getFloat("sum");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		public int getStock() {
			try {
				ResultSet rs;
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("select sum(quantity) as sum from mydb.product");
				if(rs.next())
					return rs.getInt("sum");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
}
