import java.sql.Date;

public class Order {
	public int order_id;
	public int client_client_id;
	public int product_product_id;
	public int quantity;
	public float price;
	public Date dateCreated;
	public Date expectedArrival;
	
	public Order(int order_id, int client_client_id, int product_product_id, int quantity, float price, Date dateCreated, Date expectedArrival) {
		this.order_id = order_id;
		this.client_client_id = client_client_id;
		this.product_product_id = product_product_id;
		this.quantity = quantity;
		this.price = price;
		this.dateCreated = dateCreated;
		this.expectedArrival = expectedArrival;
	}
	
	@DisplayAs(value = "Order ID", index = 0)
	
	public int getId() {
		return this.order_id;
	}
	
	@DisplayAs(value = "Client ID", index = 1)
	
	public int getClientId() {
		return this.client_client_id;
	}
	
	@DisplayAs(value = "Product ID", index = 2)
	
	public int getProductId() {
		return this.product_product_id;
	}
	
	@DisplayAs(value = "Quantity", index = 3)
	
	public int getQuantity() {
		return this.quantity;
	}
	
	@DisplayAs(value = "Price", index = 4)
	
	public float getPrice() {
		return this.price;
	}

	@DisplayAs(value = "Created", index = 5)

	public Date getDateCreated() {
		return this.dateCreated;
	}

	@DisplayAs(value = "Due", index = 6)

	public Date getDateArrival() {
		return this.expectedArrival;
	}
	
}
