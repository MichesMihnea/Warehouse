import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StatusView extends JFrame{

	Connection con;
	CalculateStatus cs;
	JTextArea s_status = new JTextArea(10, 20);
	String status;
	
	public StatusView (Connection con){
		this.con = con;
		this.status = new String();
		this.cs = new CalculateStatus(con);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JPanel content = new JPanel();
		content.add(s_status);
		s_status.setText("asdf");
		this.setContentPane(content);
		this.setSize(250, 220);
		this.setTitle("Warehouse");
		this.setVisible(true);
	}
	
	public void refresh() {
		try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from mydb.order");
		Order o = null;
		while(rs.next()) {
			o = new Order(rs.getInt("order_id"), rs.getInt("client_client_id"), rs.getInt("product_product_id"), rs.getInt("quantity"), rs.getFloat("price"), rs.getDate("date_created"), rs.getDate("expected_arrival"));
			status += cs.checkOrder(o);
			status += cs.checkDate(o);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		s_status.setText(status);
	}
	
}