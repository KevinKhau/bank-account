package bank;

import java.util.UUID;

public class Client {

	String uniqueID = UUID.randomUUID().toString();
	String name;
	
	public Client(String name) {
		super();
		this.name = name;
	}
	
}
