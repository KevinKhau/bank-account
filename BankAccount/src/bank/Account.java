package bank;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Account implements Funds {

	public Client client;
	public BigDecimal balance;
	int password;
	public List<Operation> operations = new LinkedList<>();

	public Account(Client client, BigDecimal balance, int password) {
		this.balance = balance;
		this.client = client;
		this.password = password;
	}

	public void withdraw(BigDecimal amount) {
		new Withdrawal(amount, this);
	}

	public void deposit(BigDecimal amount) {
		new Deposit(amount, this);
	}

	public void withdraw(int amount) {
		withdraw(new BigDecimal(amount));
	}

	public void deposit(int amount) {
		deposit(new BigDecimal(amount));
	}

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [" + client + ", balance=" + balance.floatValue() + "]";
	}

	@Override
	public void displayHistory(Comparator<Operation> sorter) {
		System.out.println(" ~ Displaying history of client " + client.name + " ~");
		if (sorter != null) {
			operations.sort(sorter);
		}
		operations.forEach(operation -> System.out.println(operation));
	}

}
