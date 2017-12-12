package bank;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
	public void displayHistory(Comparator<Operation> sorter) {
		System.out.println(" ~ Displaying " + name + " history ~");
		List<Operation> operations = new LinkedList<>();
		accounts.forEach(a -> operations.addAll(a.operations));
		if (sorter != null) {
			operations.sort(sorter);
		}
		operations.forEach(operation -> System.out.println(operation.account.client.name + ": " + operation));
	}

	public boolean openAccount(Client client, BigDecimal balance, int password) {
		return accounts.add(new Account(client, balance, password));
	}

	public boolean openAccount(Account account) {
		return accounts.add(account);
	}
}
