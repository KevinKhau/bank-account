package bank;

import java.math.BigDecimal;

public class Account extends Funds {

	Client client;
	int password;
	
	public Account(Client client, BigDecimal balance, int password) {
		this.balance = balance;
		this.client = client;
		this.password = password;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
}
