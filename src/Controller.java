import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
	
	ClientView cv;
	OrderView ov;
	ProductView pv;
	TotalsView tv;
	MainView mv;
	
	public Controller(MainView mv) {
		this.cv = mv.cv;
		this.ov = mv.ov;
		this.pv = mv.pv;
		this.tv = mv.tv;
		this.mv = mv;
		this.mv.addClientViewListener(new ClientViewListener());
		this.mv.addOrderViewListener(new OrderViewListener());
		this.mv.addProductViewListener(new ProductViewListener());
		this.mv.addTotalsViewListener(new TotalsViewListener());
		this.mv.addStatusViewListener(new StatusViewListener());
		this.mv.cv.addAddClientListener(new AddClientViewListener());
		this.mv.cv.addRemoveClientListener(new RemoveClientViewListener());
		this.mv.cv.addUpdateClientListener(new UpdateClientViewListener());
		this.mv.ov.addAddOrderListener(new AddOrderViewListener());
		this.mv.ov.addRemoveOrderListener(new RemoveOrderViewListener());
		this.mv.ov.addFulfillOrderListener(new FulfillOrderViewListener());
		this.mv.pv.addAddProductListener(new AddProductViewListener());
		this.mv.pv.addRemoveProductListener(new RemoveProductViewListener());
		this.mv.pv.addRestockProductListener(new RestockProductViewListener());
		
	}
	
	class ClientViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.cv.setVisible(true);
		}
		
	}
	
	class OrderViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.ov.setVisible(true);
		}
		
	}
	
	class ProductViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.pv.setVisible(true);
		}
		
	}
	
	class AddClientViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.cv.setVisible(false);
			cv.setVisible(false);
			mv.ncv = new NewClientView(mv.con, mv.cv);
			mv.ncv.addNewClientListener(new AddNewClientListener());
		}
		
	}
	
	class RemoveClientViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.cv.setVisible(false);
			cv.setVisible(false);
			mv.rcv = new RemoveClientView(mv.con, mv.cv);
			mv.rcv.addRemoveIdListener(new RemoveIdListener());
			mv.rcv.addRemoveNameListener(new RemoveNameListener());
			mv.rcv.addRemovePhoneListener(new RemovePhoneListener());
			mv.rcv.addRemoveAddrListener(new RemoveAddrListener());
		}
		
	}
	
	class AddNewClientListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.cv.dispatchEvent(new WindowEvent(mv.cv, WindowEvent.WINDOW_CLOSING));
			String name = mv.ncv.n_name.getText();
			String phone = mv.ncv.n_phone.getText();
			String address = mv.ncv.n_address.getText();
			Client c = new Client(0, name, phone, address);
			cv.access.add(c);
			mv.cv = new ClientView(mv.con);
			mv.cv.addAddClientListener(new AddClientViewListener());
			mv.cv.addRemoveClientListener(new RemoveClientViewListener());
			mv.cv.setVisible(true);
			mv.ncv.dispatchEvent(new WindowEvent(mv.ncv, WindowEvent.WINDOW_CLOSING));
		}
		
	}
	
	class RemoveIdListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.cv.dispatchEvent(new WindowEvent(mv.cv, WindowEvent.WINDOW_CLOSING));
			try {
			String attribute = mv.rcv.r_field.getText();
			cv.access.delete(attribute, 1);
			mv.cv = new ClientView(mv.con);
			mv.cv.addAddClientListener(new AddClientViewListener());
			mv.cv.addRemoveClientListener(new RemoveClientViewListener());
			mv.cv.setVisible(true);
			mv.rcv.dispatchEvent(new WindowEvent(mv.rcv, WindowEvent.WINDOW_CLOSING));
			}catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(mv.ov, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class RemoveNameListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.cv.dispatchEvent(new WindowEvent(mv.cv, WindowEvent.WINDOW_CLOSING));
			try {
			String attribute = mv.rcv.r_field.getText();
			cv.access.delete(attribute, 2);
			mv.cv = new ClientView(mv.con);
			mv.cv.addAddClientListener(new AddClientViewListener());
			mv.cv.addRemoveClientListener(new RemoveClientViewListener());
			mv.cv.setVisible(true);
			mv.rcv.dispatchEvent(new WindowEvent(mv.rcv, WindowEvent.WINDOW_CLOSING));
			}catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(mv.ov, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class RemovePhoneListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.cv.dispatchEvent(new WindowEvent(mv.cv, WindowEvent.WINDOW_CLOSING));
			try {
			String attribute = mv.rcv.r_field.getText();
			cv.access.delete(attribute, 3);
			mv.cv = new ClientView(mv.con);
			mv.cv.addAddClientListener(new AddClientViewListener());
			mv.cv.addRemoveClientListener(new RemoveClientViewListener());
			mv.cv.setVisible(true);
			mv.rcv.dispatchEvent(new WindowEvent(mv.rcv, WindowEvent.WINDOW_CLOSING));
			}catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(mv.ov, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class RemoveAddrListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.cv.dispatchEvent(new WindowEvent(mv.cv, WindowEvent.WINDOW_CLOSING));
			try {
			String attribute = mv.rcv.r_field.getText();
			cv.access.delete(attribute, 4);
			mv.cv = new ClientView(mv.con);
			mv.cv.addAddClientListener(new AddClientViewListener());
			mv.cv.addRemoveClientListener(new RemoveClientViewListener());
			mv.cv.setVisible(true);
			mv.rcv.dispatchEvent(new WindowEvent(mv.rcv, WindowEvent.WINDOW_CLOSING));
			}catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(mv.ov, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class AddOrderViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.ov.setVisible(false);
			ov.setVisible(false);
			mv.nov = new NewOrderView(mv.con, mv.ov);
			mv.nov.addNewOrderListener(new AddNewOrderListener());
		}
		
	}
	
	class AddNewOrderListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.ov.dispatchEvent(new WindowEvent(mv.ov, WindowEvent.WINDOW_CLOSING));
			String client_name = (String) mv.nov.n_client.getSelectedItem();
			int cid = 0, pid = 0;
			try {
				PreparedStatement stmt = mv.con.prepareStatement("select client_id from mydb.client where name = \"" + client_name + "\"");
				ResultSet rs = null;
				rs = stmt.executeQuery();
				if(rs.next())
				cid = rs.getInt("client_id");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String product_name = (String) mv.nov.n_product.getSelectedItem();
			try {
				PreparedStatement stmt = mv.con.prepareStatement("select product_id from mydb.product where name = \"" + product_name + "\"");
				ResultSet rs = null;
				rs = stmt.executeQuery();
				if(rs.next())
				pid = rs.getInt("product_id");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			try {
			int quantity = Integer.parseInt(mv.nov.n_quantity.getText());
			float price = Float.parseFloat(mv.nov.n_price.getText());
			
			Date arrival = null;
			java.util.Date d = (java.util.Date) mv.nov.timeSpinner.getValue();
			arrival = new Date(d.getTime());
			Order o = new Order(0, cid, pid, quantity, price, new Date(System.currentTimeMillis()), arrival);
			ov.access.add(o);
			mv.ov = new OrderView(mv.con);
			mv.ov.addAddOrderListener(new AddOrderViewListener());
			mv.ov.addRemoveOrderListener(new RemoveOrderViewListener());
			mv.ov.addFulfillOrderListener(new FulfillOrderViewListener());
			mv.ov.setVisible(true);
			mv.nov.dispatchEvent(new WindowEvent(mv.nov, WindowEvent.WINDOW_CLOSING));
			}catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(mv.ov, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class RemoveOrderViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.ov.setVisible(false);
			ov.setVisible(false);
			mv.rov = new RemoveOrderView(mv.con, mv.ov);
			mv.rov.addRemoveOrderListener(new RemoveOrderListener());
		}
		
	}
	
	class RemoveOrderListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.ov.dispatchEvent(new WindowEvent(mv.ov, WindowEvent.WINDOW_CLOSING));
			String attribute = mv.rov.r_id.getText();
			try {
			ov.access.delete(attribute);
			mv.ov = new OrderView(mv.con);
			mv.ov.addAddOrderListener(new AddOrderViewListener());
			mv.ov.addRemoveOrderListener(new RemoveOrderViewListener());
			mv.ov.setVisible(true);
			mv.rov.dispatchEvent(new WindowEvent(mv.rov, WindowEvent.WINDOW_CLOSING));
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(mv.ov, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class AddProductViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.pv.setVisible(false);
			pv.setVisible(false);
			mv.npv = new NewProductView(mv.con, mv.pv);
			mv.npv.addNewProductListener(new AddNewProductListener());
		}
		
	}
	
	class AddNewProductListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.pv.dispatchEvent(new WindowEvent(mv.pv, WindowEvent.WINDOW_CLOSING));
			try {
			String name = mv.npv.n_name.getText();
			String manufacturer = mv.npv.n_manufacturer.getText();
			String quantity = mv.npv.n_quantity.getText();
			Product p = new Product(0, name, manufacturer, Integer.parseInt(quantity));
			pv.access.add(p);
			mv.pv = new ProductView(mv.con);
			mv.pv.addAddProductListener(new AddProductViewListener());
			mv.pv.addRemoveProductListener(new RemoveProductViewListener());
			mv.pv.addRestockProductListener(new RestockProductViewListener());
			mv.pv.setVisible(true);
			mv.npv.dispatchEvent(new WindowEvent(mv.npv, WindowEvent.WINDOW_CLOSING));
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(mv.ov, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class RemoveProductViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.pv.setVisible(false);
			pv.setVisible(false);
			mv.rpv = new RemoveProductView(mv.con, mv.pv);
			mv.rpv.addRemoveIdListener(new RemoveProductIdListener());
			mv.rpv.addRemoveNameListener(new RemoveProductNameListener());
			mv.rpv.addRemoveManListener(new RemoveProductManufacturerListener());
		}
		
	}
	
	class RemoveProductIdListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			try {
			mv.pv.dispatchEvent(new WindowEvent(mv.pv, WindowEvent.WINDOW_CLOSING));
			String attribute = mv.rpv.r_field.getText();
			pv.access.delete(attribute, 1);
			mv.pv = new ProductView(mv.con);
			mv.pv.addAddProductListener(new AddProductViewListener());
			mv.pv.addRemoveProductListener(new RemoveProductViewListener());
			mv.pv.addRestockProductListener(new RestockProductViewListener());
			mv.pv.setVisible(true);
			mv.rpv.dispatchEvent(new WindowEvent(mv.rpv, WindowEvent.WINDOW_CLOSING));
			}catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(mv.ov, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class RemoveProductNameListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			try {
			mv.pv.dispatchEvent(new WindowEvent(mv.pv, WindowEvent.WINDOW_CLOSING));
			String attribute = mv.rpv.r_field.getText();
			pv.access.delete(attribute, 2);
			mv.pv = new ProductView(mv.con);
			mv.pv.addAddProductListener(new AddProductViewListener());
			mv.pv.addRemoveProductListener(new RemoveProductViewListener());
			mv.pv.addRestockProductListener(new RestockProductViewListener());
			mv.pv.setVisible(true);
			mv.rpv.dispatchEvent(new WindowEvent(mv.rpv, WindowEvent.WINDOW_CLOSING));
			}catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(mv.ov, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class RemoveProductManufacturerListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			try {
			mv.pv.dispatchEvent(new WindowEvent(mv.pv, WindowEvent.WINDOW_CLOSING));
			String attribute = mv.rpv.r_field.getText();
			pv.access.delete(attribute, 3);
			mv.pv = new ProductView(mv.con);
			mv.pv.addAddProductListener(new AddProductViewListener());
			mv.pv.addRemoveProductListener(new RemoveProductViewListener());
			mv.pv.addRestockProductListener(new RestockProductViewListener());
			mv.pv.setVisible(true);
			mv.rpv.dispatchEvent(new WindowEvent(mv.rpv, WindowEvent.WINDOW_CLOSING));
			}catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(mv.ov, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class TotalsViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.tv = new TotalsView(mv.con);
			mv.tv.refresh();
		}
		
	}
	
	class StatusViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.sv = new StatusView(mv.con);
			mv.sv.refresh();
		}
		
	}
	
	class FulfillOrderViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.ov.setVisible(false);
			ov.setVisible(false);
			mv.fov = new FulfillOrderView(mv.con, mv.ov);
			mv.fov.addFulfillOrderListener(new FulfillOrderListener());
		}
		
	}
	
	class FulfillOrderListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			CalculateStatus cs = new CalculateStatus(mv.con);
			mv.ov.dispatchEvent(new WindowEvent(mv.ov, WindowEvent.WINDOW_CLOSING));
			String attribute = (String) mv.fov.n_orders.getSelectedItem();
			String id = new String();
			int i = 0;
			while(true) {
				if(attribute.charAt(i) == ' ') {
					break;
				}
				else id += attribute.charAt(i);
				i++;
			}
			try {
			Statement stmt = mv.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from mydb.order where order_id = " + Integer.parseInt(id));
			if(rs.next()) {
				int order_id = rs.getInt("order_id");
				int client_id = rs.getInt("client_client_id");
				int product_id = rs.getInt("product_product_id");
				int quantity = rs.getInt("quantity");
				float price = rs.getFloat("price");
				Date created = rs.getDate("date_created");
				Date due = rs.getDate("expected_arrival");
				Order o = new Order(order_id, client_id, product_id, quantity, price, created, due);
				int currQuantity = 0;
				rs = stmt.executeQuery("select quantity from mydb.product where product_id = " + product_id);
				if(rs.next()) {
					currQuantity = Integer.parseInt(rs.getString("quantity"));
				}
				if(cs.checkOk(o))
				{
					mv.fov.exportBill(o);
					ov.access.delete(Integer.toString(order_id));
					PreparedStatement pstmt = mv.con.prepareStatement("update mydb.product set product.quantity = " + (currQuantity - quantity) + " where product_id = " + product_id);
					pstmt.executeUpdate();
				}
				else 		
					JOptionPane.showMessageDialog(mv.ov, cs.checkOrder(o), "Inconvenience", JOptionPane.INFORMATION_MESSAGE);

			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			mv.ov = new OrderView(mv.con);
			mv.ov.addAddOrderListener(new AddOrderViewListener());
			mv.ov.addRemoveOrderListener(new RemoveOrderViewListener());
			mv.ov.addFulfillOrderListener(new FulfillOrderViewListener());
			mv.ov.setVisible(true);
			mv.pv.dispatchEvent(new WindowEvent(mv.pv, WindowEvent.WINDOW_CLOSING));
			mv.pv = new ProductView(mv.con);
			mv.pv.addAddProductListener(new AddProductViewListener());
			mv.pv.addRemoveProductListener(new RemoveProductViewListener());
			mv.pv.addRestockProductListener(new RestockProductViewListener());
			//mv.pv.setVisible(true);
			//mv.rpv.dispatchEvent(new WindowEvent(mv.rpv, WindowEvent.WINDOW_CLOSING));
			mv.fov.dispatchEvent(new WindowEvent(mv.fov, WindowEvent.WINDOW_CLOSING));
		}
		
	}
	
	class RestockProductViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.pv.setVisible(false);
			pv.setVisible(false);
			mv.rspv = new RestockProductView(mv.con, mv.pv);
			mv.rspv.addRestockProductListener(new RestockProductListener());
		}
		
	}
	
	class RestockProductListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.pv.dispatchEvent(new WindowEvent(mv.pv, WindowEvent.WINDOW_CLOSING));
			int quantity = Integer.parseInt(mv.rspv.n_quantity.getText());
			String attribute = (String) mv.rspv.n_products.getSelectedItem();
			String id = new String();
			int i = 0;
			while(true) {
				if(attribute.charAt(i) == ' ') {
					break;
				}
				else id += attribute.charAt(i);
				i++;
			}
			try {
				Statement stmt = mv.con.createStatement();
				int currQuantity = 0;
				ResultSet rs = stmt.executeQuery("select quantity as quantity from mydb.product where product_id = " + Integer.parseInt(id));
				if(rs.next())
					currQuantity = rs.getInt("quantity");
				quantity += currQuantity;
				stmt.executeUpdate("update mydb.product set product.quantity = " + quantity + " where product_id =" + Integer.parseInt(id));
			}catch (SQLException e) {
				e.printStackTrace();
			}
			mv.pv = new ProductView(mv.con);
			mv.pv.addAddProductListener(new AddProductViewListener());
			mv.pv.addRemoveProductListener(new RemoveProductViewListener());
			mv.pv.addRestockProductListener(new RestockProductViewListener());
			mv.pv.setVisible(true);
			mv.rspv.dispatchEvent(new WindowEvent(mv.rspv, WindowEvent.WINDOW_CLOSING));
		}
		
	}
	
	class UpdateClientViewListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			mv.cv.setVisible(false);
			cv.setVisible(false);
			mv.ucv = new UpdateClientView(mv.con, mv.cv);
			mv.ucv.addUpdatePhoneListener(new UpdatePhoneListener());
			mv.ucv.addUpdateAddressListener(new UpdateAddressListener());
		}
		
	}
	
	class UpdatePhoneListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			try {
			mv.cv.dispatchEvent(new WindowEvent(mv.cv, WindowEvent.WINDOW_CLOSING));
			String phone = mv.ucv.n_phone.getText();
			String id = new String();
			String attribute = (String) mv.ucv.n_clients.getSelectedItem();
			int i = 0;
			while(true) {
				if(attribute.charAt(i) == ' ') {
					break;
				}
				else id += attribute.charAt(i);
				i++;
			}
			try {
			Statement stmt = mv.con.createStatement();
			stmt.executeUpdate("update mydb.client set client.phone = " + "\"" + phone + "\"" + " where client_id =" + Integer.parseInt(id));
			}catch (SQLException e) {
				e.printStackTrace();
			}
			mv.cv = new ClientView(mv.con);
			mv.cv.addAddClientListener(new AddClientViewListener());
			mv.cv.addRemoveClientListener(new RemoveClientViewListener());
			mv.cv.addUpdateClientListener(new UpdateClientViewListener());
			mv.cv.setVisible(true);
			}catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(mv.cv, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	class UpdateAddressListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			try {
			mv.cv.dispatchEvent(new WindowEvent(mv.cv, WindowEvent.WINDOW_CLOSING));
			String address = mv.ucv.n_address.getText();
			String id = new String();
			String attribute = (String) mv.ucv.n_clients.getSelectedItem();
			int i = 0;
			while(true) {
				if(attribute.charAt(i) == ' ') {
					break;
				}
				else id += attribute.charAt(i);
				i++;
			}
			try {
			Statement stmt = mv.con.createStatement();
			stmt.executeUpdate("update mydb.client set client.address = " + "\"" + address + "\"" + " where client_id =" + Integer.parseInt(id));
			}catch (SQLException e) {
				e.printStackTrace();
			}
			mv.cv = new ClientView(mv.con);
			mv.cv.addAddClientListener(new AddClientViewListener());
			mv.cv.addRemoveClientListener(new RemoveClientViewListener());
			mv.cv.addUpdateClientListener(new UpdateClientViewListener());
			mv.cv.setVisible(true);
			}catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(mv.cv, "Bad input!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	
}
