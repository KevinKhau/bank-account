package bank;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public abstract class Funds {

	protected BigDecimal balance;
	public List<Operation> operations = new LinkedList<>();
	
	void displayHistory() {
		// TODO
	}
	
	abstract BigDecimal getBalance();
	
}
