import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClientView extends JFrame{
	
		Connection con;
		AccessClient access;
		JTable table;
		JButton add_btn = new JButton("Add Client");
		JButton del_btn = new JButton("Remove Client");
		JButton update_btn = new JButton("Update Client");
		
	public ClientView (Connection con){
		this.con = con;
		this.access = new AccessClient(con);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel content = new JPanel();
		try {
		PreparedStatement preparedStmt = this.con.prepareStatement("select * from client");
		ResultSet rs;
		rs = preparedStmt.executeQuery();
		this.table = new JTable();
		TableModel <Client> tableModel = new DisplayableTableModel <> (Client.class);
	    List <Client> clients = new ArrayList <> ();
	    while(rs.next()) {
	    	int client_id = rs.getInt("client_id");
	    	String name = rs.getString("name");
	    	String phone = rs.getString("phone");
	    	String address = rs.getString("address");
	    	Client c = new Client(client_id, name, phone, address);
	    	clients.add(c);
	    }
	    tableModel.setObjectRows(clients);
	    table = new JTable(tableModel);
		JScrollPane jp = new JScrollPane(table);
		content.add(jp);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		content.add(add_btn);
		content.add(del_btn);
		content.add(update_btn);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(content);
		this.setSize(500, 500);
		this.setTitle("Warehouse");
		this.setVisible(false);
	}
	
	
	public void addAddClientListener(ActionListener pAddClient) {
		add_btn.addActionListener(pAddClient);
	}
	
	public void addRemoveClientListener(ActionListener pRemoveClient) {
		del_btn.addActionListener(pRemoveClient);
	}
	
	public void addUpdateClientListener(ActionListener pUpdateClient) {
		update_btn.addActionListener(pUpdateClient);
	}

}
	