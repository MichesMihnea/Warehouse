
public class Product {
	public int product_id;
	public String name;
	public String manufacturer;
	public int quantity;
	
	public Product(int product_id, String name, String manufacturer, int quantity) {
		this.product_id = product_id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
	}
	
	@DisplayAs(value = "Product ID", index = 0)
	
	public int getId() {
		return this.product_id;
	}
	
	@DisplayAs(value = "Product Name", index = 1)
	
	public String getName() {
		return this.name;
	}
	
	@DisplayAs(value = "Manufacturer", index = 2)
	
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	@DisplayAs(value = "Quantity", index = 3)
	
	public int getQuantity() {
		return this.quantity;
	}
	
}
