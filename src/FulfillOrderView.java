import java.awt.Component;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
public class FulfillOrderView extends JFrame {
	
	public Connection con;
	public OrderView ov;
	public JComboBox <String> n_orders = new JComboBox <String> ();
	public JButton n_fulfill = new JButton("Fulfill");
	public FulfillOrderView (Connection con, OrderView ov){
		this.con = con;
		this.ov = ov;
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		content.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 21;
		gbc.gridy = 0;
		content.add(new JLabel("Fulfill an order"), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		content.add(new JLabel("Order: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select order.order_id, client.name, product.name from mydb.client join mydb.order on client.client_id = order.client_client_id join mydb.product on product.product_id = order.product_product_id");
		while (rs.next()) {  

		     n_orders.addItem(rs.getInt("order.order_id") + "  " + rs.getString("client.name") + " " + rs.getString("product.name"));  
		 }
		content.add(n_orders, gbc);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 250;
		content.add(n_fulfill, gbc);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(content);
		this.setSize(250, 200);
		this.setTitle("Warehouse");
		this.setVisible(true);
		ov.setVisible(false);
	}
	
	public void addFulfillOrderListener(ActionListener pFulfillOrder) {
		n_fulfill.addActionListener(pFulfillOrder);
	}
	
	public void exportBill(Order o) {
		String fileName = new String();
		fileName = (new Date(System.currentTimeMillis())).toString() + "-" + o.order_id + ".txt";
		try {
			try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select order.order_id, order.quantity, order.price, client.name, product.name from mydb.client join mydb.order on client.client_id = order.client_client_id join mydb.product on product.product_id = order.product_product_id");
			if(rs.next()) {
				PrintWriter writer = new PrintWriter(fileName, "UTF-8");
				writer.println("Bill #" + rs.getInt("order.order_id"));
				writer.println("Date: " + new Date(System.currentTimeMillis()).toString());
				writer.println("Client name: " + rs.getString("client.name"));
				writer.println("Acquired a quantity of " + rs.getInt("order.quantity") + " of product " + rs.getString("product.name"));
				writer.println("Amount paid: " + rs.getFloat("order.price"));
				writer.close();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}