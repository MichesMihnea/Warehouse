import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
public class NewOrderView extends JFrame {
	
	public Connection con;
	public OrderView ov;
	public JComboBox <String> n_client = new JComboBox <String> ();
	public JComboBox <String> n_product = new JComboBox <String> ();
	public JTextField n_quantity = new JTextField(20);
	public JTextField n_price = new JTextField(20);
	public JButton n_add = new JButton("Add");
	public JSpinner timeSpinner;
	public NewOrderView (Connection con, OrderView ov){
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
		content.add(new JLabel("Add a new order"), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		content.add(new JLabel("Client: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select name from client");
		while (rs.next()) {  

		     n_client.addItem(rs.getString("name"));  
		 }
		content.add(n_client, gbc);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 50;
		content.add(new JLabel("Product ID: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 50;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select name from mydb.product");
			while (rs.next()) {  

			     n_product.addItem(rs.getString("name"));  
			 }
			content.add(n_product, gbc);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 100;
		content.add(new JLabel("Quantity: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 100;
		content.add(n_quantity, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 150;
		content.add(new JLabel("Price: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 150;
		content.add(n_price, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 200;
		content.add(new JLabel("Expected arrival: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 200;
		Date date = new Date(System.currentTimeMillis());
	    SpinnerDateModel dateModel = new SpinnerDateModel(date, null, null, Calendar.DAY_OF_MONTH);
	    timeSpinner = new JSpinner(dateModel);
	    content.add(timeSpinner, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 250;
		content.add(n_add, gbc);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(content);
		this.setSize(250, 200);
		this.setTitle("Warehouse");
		this.setVisible(true);
		ov.setVisible(false);
	}
	
	public void addNewOrderListener(ActionListener pNewOrder) {
		n_add.addActionListener(pNewOrder);
	}
	
}