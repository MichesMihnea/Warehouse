import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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

public class MainView extends JFrame{
	
		Connection con;
		ClientView cv;
		NewClientView ncv;
		RemoveClientView rcv;
		UpdateClientView ucv;
		OrderView ov;
		NewOrderView nov;
		RemoveOrderView rov;
		FulfillOrderView fov;
		ProductView pv;
		NewProductView npv;
		RemoveProductView rpv;
		RestockProductView rspv;
		TotalsView tv;
		StatusView sv;
		JButton client_btn = new JButton("View Clients");
		JButton order_btn = new JButton("View Orders");
		JButton product_btn = new JButton("View Products");
		JButton totals_btn = new JButton("View Totals");
		JButton status_btn = new JButton("View Status");
		
	public MainView (Connection con){
		this.con = con;
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		MainView frame = this;
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        frame, "Are you sure?");
                if( result==JOptionPane.OK_OPTION){
                	try {
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    // NOW we change it to dispose on close..
                    frame.setDefaultCloseOperation(
                            JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		content.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		content.add(new JLabel("Welcome to Warehouse Simulator!"), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 4;
		content.add(client_btn, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.gridwidth = 4;
		content.add(order_btn, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.gridwidth = 4;
		content.add(product_btn, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 20;
		gbc.gridwidth = 4;
		content.add(totals_btn, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 25;
		gbc.gridwidth = 4;
		content.add(status_btn, gbc);
		
		this.cv = new ClientView(con);
		this.ov = new OrderView(con);
		this.pv = new ProductView(con);
		this.setContentPane(content);
		this.setSize(230, 200);
		this.setTitle("Warehouse");
		this.setVisible(true);
	}
	
	public void addClientViewListener(ActionListener pClientView) {
		client_btn.addActionListener(pClientView);
	}
	
	public void addOrderViewListener(ActionListener pOrderView) {
		order_btn.addActionListener(pOrderView);
	}
	
	public void addProductViewListener(ActionListener pProductView) {
		product_btn.addActionListener(pProductView);
	}
	
	public void addTotalsViewListener(ActionListener pTotalsView) {
		totals_btn.addActionListener(pTotalsView);
	}
	
	public void addStatusViewListener(ActionListener pStatusView) {
		status_btn.addActionListener(pStatusView);
	}
	
}
	