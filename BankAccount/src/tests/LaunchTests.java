package tests;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.Test;

import bank.Account;
import bank.Bank;
import bank.Client;

public class LaunchTests {

	Bank axileo = new Bank("Axileo");
	Client julien = new Client("Julien");
	Client charles = new Client("Charles");
	Account first = new Account(julien, new BigDecimal(5000), 8495);
	Account second = new Account(charles, new BigDecimal(3582.16), 4565);
	
	public LaunchTests() {
		axileo.openAccount(first);
		axileo.openAccount(second);
	}

	@Test
	public void randomTests() {
		Currency currency = Currency.getInstance(Locale.FRANCE);
		System.out.println(currency.getDisplayName());
	}
	
	@Test
	public void displayBalances() {
		axileo.accounts.stream().sorted((a1, a2) -> a2.balance.compareTo(a1.balance)).forEach(a -> System.out.println(a));
		System.out.println("Fonds de " + axileo.name + " : " + axileo.getBalance().floatValue());
	}
	
	@Test
	public void testDeposits() {
		first.deposit(new BigDecimal(20));
		second.deposit(new BigDecimal(3000));
//		displayBalances();
	}
	
	@Test
	public void testWithdrawals() {
		first.withdraw(new BigDecimal(300));
		displayBalances();
	}

}
