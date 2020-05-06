
public class Client {
	public int client_id;
	public String name;
	public String phone;
	public String address;
	
	public Client(int client_id, String name, String phone, String address) {
		this.client_id = client_id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
@DisplayAs(value = "Client ID", index = 0)
	
	public int getId() {
		return this.client_id;
	}
	
	@DisplayAs(value = "Name", index = 1)
	
	public String getName() {
		return this.name;
	}
	
	@DisplayAs(value = "Phone", index = 2)
	
	public String getPhone() {
		return this.phone;
	}
	
	@DisplayAs(value = "Address", index = 3)
	
	public String getAddress() {
		return this.address;
	}
	
}
