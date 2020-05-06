import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class RestockProductView extends JFrame {
	
	public Connection con;
	public ProductView pv;
	public JComboBox <String> n_products = new JComboBox <String> ();
	public JTextField n_quantity = new JTextField(5);
	public JButton n_restock = new JButton("Restock");
	public RestockProductView (Connection con, ProductView pv){
		this.con = con;
		this.pv = pv;
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		content.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 21;
		gbc.gridy = 0;
		content.add(new JLabel("Restock a product"), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		content.add(new JLabel("Product: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from mydb.product");
		while (rs.next()) {  

		     n_products.addItem(rs.getInt("product_id") + "  " + rs.getString("name") + " " + rs.getString("manufacturer") + rs.getString("quantity"));  
		 }
		content.add(n_products, gbc);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		gbc.gridx = 10;
		gbc.gridy = 20;
		gbc.gridwidth = 4;
		content.add(new JLabel("Quantity: "), gbc);
		gbc.gridx = 20;
		gbc.gridy = 20;
		gbc.gridwidth = 4;
		content.add(n_quantity, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 350;
		content.add(n_restock, gbc);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(content);
		this.setSize(250, 200);
		this.setTitle("Warehouse");
		this.setVisible(true);
		pv.setVisible(false);
	}
	
	public void addRestockProductListener(ActionListener pRestock) {
		n_restock.addActionListener(pRestock);
	}
	
}