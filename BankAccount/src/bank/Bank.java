package bank;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Bank implements Funds {

	public String name;
	public Set<Account> accounts = new HashSet<>();

	public Bank(String name) {
		this.name = name;
	}

	@Override
	public BigDecimal getBalance() {
		return accounts.stream().map(Account::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public void displayHistory() {
		System.out.println("Displaying " + name + " history:");
		accounts.forEach(Account::displayHistory);
	}

	public boolean openAccount(Client client, BigDecimal balance, int password) {
		return accounts.add(new Account(client, balance, password));
	}
}
