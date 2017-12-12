package bank;

import java.util.LinkedList;
import java.util.List;

public abstract class Funds {

	double balance;
	List<Operation> operations = new LinkedList<>();
	
	void displayHistory() {
		// TODO
	}
	
}
