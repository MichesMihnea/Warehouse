import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProductView extends JFrame{
	
		Connection con;
		AccessProduct access;
		JButton add_btn = new JButton("Add Product");
		JButton del_btn = new JButton("Remove Product");
		JButton restock_btn = new JButton("Restock Product");
		
	public ProductView (Connection con){
		this.con = con;
		this.access = new AccessProduct(con);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel content = new JPanel();
		try {
		PreparedStatement preparedStmt = this.con.prepareStatement("select * from mydb.product");
		ResultSet rs;
		rs = preparedStmt.executeQuery();
	    JTable table;
	    TableModel <Product> tableModel = new DisplayableTableModel <> (Product.class);
	    List <Product> products = new ArrayList <> ();
	    while(rs.next()) {
	    	int product_id = rs.getInt("product_id");
	    	String name = rs.getString("name");
	    	String manufacturer = rs.getString("manufacturer");
	    	int quantity = rs.getInt("quantity");
	    	Product p = new Product(product_id, name, manufacturer, quantity);
	    	products.add(p);
	    }
	    tableModel.setObjectRows(products);
	    table = new JTable(tableModel);
		JScrollPane jp = new JScrollPane(table);
		content.add(jp);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		content.add(add_btn);
		content.add(del_btn);
		content.add(restock_btn);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(content);
		this.setSize(500, 500);
		this.setTitle("Warehouse");
		this.setVisible(false);
	}
	
	public void addAddProductListener(ActionListener pAddProduct) {
		add_btn.addActionListener(pAddProduct);
	}
	
	public void addRemoveProductListener(ActionListener pRemoveProduct) {
		del_btn.addActionListener(pRemoveProduct);
	}
	
	public void addRestockProductListener(ActionListener pRestockProduct) {
		restock_btn.addActionListener(pRestockProduct);
	}

}
	