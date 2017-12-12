package bank;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Bank extends Funds {

	String name;
	Set<Account> accounts = new HashSet<>();

	public Bank(String name) {
		this.name = name;
	}

	public boolean add(Account account) {
		return accounts.add(account);
	}
	
	public BigDecimal getBalance() {
		return accounts.stream().map(Account::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
