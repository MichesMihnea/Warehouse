import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TotalsView extends JFrame{

	Connection con;
	private JTextField t_clientCount = new JTextField(5);
	private JTextField t_orderCount = new JTextField(5);
	private JTextField t_productCount = new JTextField(5);
	private JTextField t_currIncome = new JTextField(5);
	private JTextField t_stock = new JTextField(5);
	CalculateTotals ct;
	
	public TotalsView (Connection con){
		this.con = con;
		this.ct = new CalculateTotals(con);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		content.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		content.add(new JLabel("Number of clients: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		content.add(t_clientCount, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 100;
		gbc.gridwidth = 4;
		content.add(new JLabel("Number of orders: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 100;
		gbc.gridwidth = 4;
		content.add(t_orderCount, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 200;
		gbc.gridwidth = 4;
		content.add(new JLabel("Number of products: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 200;
		gbc.gridwidth = 4;
		content.add(t_productCount, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 250;
		gbc.gridwidth = 4;
		content.add(new JLabel("Current income: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 250;
		gbc.gridwidth = 4;
		content.add(t_currIncome, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 300;
		gbc.gridwidth = 4;
		content.add(new JLabel("Current stock: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 300;
		gbc.gridwidth = 4;
		content.add(t_stock, gbc);
		this.setContentPane(content);
		this.setSize(250, 160);
		this.setTitle("Warehouse");
		this.setVisible(true);
	}
	
	public void refresh() {
		this.t_clientCount.setText(Integer.toString(ct.getClients()));
		this.t_orderCount.setText(Integer.toString(ct.getOrders()));
		this.t_productCount.setText(Integer.toString(ct.getProducts()));
		this.t_currIncome.setText(Float.toString(ct.getIncome()));
		this.t_stock.setText(Integer.toString(ct.getStock()));
	}
	
}
