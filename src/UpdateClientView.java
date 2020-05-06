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
public class UpdateClientView extends JFrame {
	
	public Connection con;
	public ClientView cv;
	public JComboBox <String> n_clients = new JComboBox <String> ();
	public JTextField n_phone = new JTextField(5);
	public JTextField n_address = new JTextField(5);
	public JButton n_phoneBtn = new JButton("Update Phone");
	public JButton n_addrBtn = new JButton("Update Address");
	public UpdateClientView (Connection con, ClientView cv){
		this.con = con;
		this.cv = cv;
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		content.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 21;
		gbc.gridy = 0;
		content.add(new JLabel("Edit a client"), gbc);
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
		ResultSet rs = stmt.executeQuery("select * from mydb.client");
		while (rs.next()) {  

		     n_clients.addItem(rs.getInt("client_id") + "  " + rs.getString("name"));  
		 }
		content.add(n_clients, gbc);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		gbc.gridx = 10;
		gbc.gridy = 20;
		gbc.gridwidth = 4;
		content.add(new JLabel("Phone: "), gbc);
		gbc.gridx = 20;
		gbc.gridy = 20;
		gbc.gridwidth = 4;
		content.add(n_phone, gbc);
		gbc.gridx = 10;
		gbc.gridy = 30;
		gbc.gridwidth = 4;
		content.add(new JLabel("Address: "), gbc);
		gbc.gridx = 20;
		gbc.gridy = 30;
		gbc.gridwidth = 4;
		content.add(n_address, gbc);
		gbc.gridx = 20;
		gbc.gridy = 40;
		gbc.gridwidth = 4;
		content.add(n_phoneBtn, gbc);
		gbc.gridx = 20;
		gbc.gridy = 50;
		gbc.gridwidth = 4;
		content.add(n_addrBtn, gbc);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(content);
		this.setSize(250, 200);
		this.setTitle("Warehouse");
		this.setVisible(true);
		cv.setVisible(false);
	}
	
	public void addUpdatePhoneListener(ActionListener pPhone) {
		n_phoneBtn.addActionListener(pPhone);
	}
	
	public void addUpdateAddressListener(ActionListener pAddr) {
		n_addrBtn.addActionListener(pAddr);
	}
	
}