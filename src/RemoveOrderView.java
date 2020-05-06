import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveOrderView extends JFrame {

	public Connection con;
	public OrderView ov;
	public JTextField r_id = new JTextField(40);
	public JButton r_remove = new JButton("Remove");
	
	public RemoveOrderView (Connection con, OrderView ov){
		this.con = con;
		this.ov = ov;
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		content.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 0;
		content.add(new JLabel("Remove an order"), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		content.add(new JLabel("Order ID: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 10;
		content.add(r_id, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 20;
		content.add(r_remove, gbc);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(content);
		this.setSize(330, 150);
		this.setTitle("Warehouse");
		this.setVisible(true);
		ov.setVisible(false);
	}
	
	public void addRemoveOrderListener(ActionListener pRemove) {
		r_remove.addActionListener(pRemove);
	}
	
}