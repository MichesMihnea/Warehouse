import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrderView extends JFrame{
	
	Connection con;
	AccessOrder access;
	public JButton o_add = new JButton("Add order");
	public JButton o_remove = new JButton("Remove order");
	public JButton o_fulfill = new JButton("Fulfill order");
		
	public OrderView (Connection con){
		this.con = con;
		this.access = new AccessOrder(con);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel content = new JPanel();
		try {
		PreparedStatement preparedStmt = this.con.prepareStatement("select * from mydb.order");
		ResultSet rs;
		rs = preparedStmt.executeQuery();
	    JTable table;
	    TableModel <Order> tableModel = new DisplayableTableModel <> (Order.class);
	    List <Order> orders = new ArrayList <> ();
	    while(rs.next()) {
	    	int order_id = rs.getInt("order_id");
	    	int client_id = rs.getInt("client_client_id");
	    	int product_id = rs.getInt("product_product_id");
	    	int quantity = rs.getInt("quantity");
	    	float price = rs.getFloat("price");
	    	Date created = rs.getDate("date_created");
	    	Date due = rs.getDate("expected_arrival");
	    	Order o = new Order(order_id, client_id, product_id, quantity, price, created, due);
	    	orders.add(o);
	    }
	    tableModel.setObjectRows(orders);
	    table = new JTable(tableModel);
		JScrollPane jp = new JScrollPane(table);
		content.add(jp);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		content.add(o_add);
		content.add(o_remove);
		content.add(o_fulfill);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(content);
		this.setSize(500, 500);
		this.setTitle("Warehouse");
		this.setVisible(false);
	}
	
	public void addAddOrderListener(ActionListener pAddOrder) {
		o_add.addActionListener(pAddOrder);
	}
	
	public void addRemoveOrderListener(ActionListener pRemoveOrder) {
		o_remove.addActionListener(pRemoveOrder);
	}
	
	public void addFulfillOrderListener(ActionListener pFulfillOrder) {
		o_fulfill.addActionListener(pFulfillOrder);
	}
	
}
	