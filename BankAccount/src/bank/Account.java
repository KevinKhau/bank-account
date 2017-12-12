package bank;

import java.math.BigDecimal;
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

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [" + client + ", balance=" + balance.floatValue() + "]";
	}

	@Override
	public void displayHistory() {
		// TODO Auto-generated method stub
		
	}

}