package bank;

import java.util.UUID;

public class Client {

	String uniqueID = UUID.randomUUID().toString();
	public String name;
	
	public Client(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "name=" + name;
	}
}
