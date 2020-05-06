import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewProductView extends JFrame {
	
	public Connection con;
	public ProductView pv;
	public JTextField n_name = new JTextField(20);
	public JTextField n_manufacturer = new JTextField(20);
	public JTextField n_quantity = new JTextField(20);
	public JButton n_add = new JButton("Add");
	public NewProductView (Connection con, ProductView pv){
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
		content.add(new JLabel("Add a new product"), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		content.add(new JLabel("Name: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 10;
		content.add(n_name, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 50;
		content.add(new JLabel("Manufacturer: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 50;
		content.add(n_manufacturer, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 100;
		content.add(new JLabel("Quantity: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 100;
		content.add(n_quantity, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 150;
		content.add(n_add, gbc);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(content);
		this.setSize(220, 170);
		this.setTitle("Warehouse");
		this.setVisible(true);
		pv.setVisible(false);
	}
	
	public void addNewProductListener(ActionListener pNewProduct) {
		n_add.addActionListener(pNewProduct);
	}
	
}