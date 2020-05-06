import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveClientView extends JFrame {

	public Connection con;
	public ClientView cv;
	public JTextField r_field = new JTextField(40);
	public JButton r_removeId = new JButton("ID");
	public JButton r_removeName = new JButton("Name");
	public JButton r_removeAddr = new JButton("Address");
	public JButton r_removePhone = new JButton("Phone");
	public RemoveClientView (Connection con, ClientView cv){
		this.con = con;
		this.cv = cv;
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		content.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 0;
		content.add(new JLabel("Remove a client"), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		content.add(new JLabel("Attribute: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 10;
		content.add(r_field, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 15;
		gbc.gridwidth = 4;
		content.add(new JLabel("Remove by: "), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 10;
		gbc.gridy = 20;
		content.add(r_removeId, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 15;
		gbc.gridy = 20;
		content.add(r_removeName, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 20;
		gbc.gridy = 20;
		content.add(r_removeAddr, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 25;
		gbc.gridy = 20;
		content.add(r_removePhone, gbc);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(content);
		this.setSize(330, 150);
		this.setTitle("Warehouse");
		this.setVisible(true);
		cv.setVisible(false);
	}
	
	public void addRemoveIdListener(ActionListener pRemoveId) {
		r_removeId.addActionListener(pRemoveId);
	}
	
	public void addRemoveNameListener(ActionListener pRemoveName) {
		r_removeName.addActionListener(pRemoveName);
	}
	
	public void addRemovePhoneListener(ActionListener pRemovePhone) {
		r_removePhone.addActionListener(pRemovePhone);
	}
	
	public void addRemoveAddrListener(ActionListener pRemoveAddr) {
		r_removeAddr.addActionListener(pRemoveAddr);
	}
	
}
