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
	Account first = new Account(julien, new BigDecimal("5E+3"), 8495);
	Account second = new Account(charles, new BigDecimal(3582.16), 4565);
	
	@Test
	public void test() {
		Currency currency = Currency.getInstance(Locale.FRANCE);
		System.out.println(currency.getDisplayName());
	}
	
	@Test
	public void launchTest() {
		axileo.add(first);
		axileo.add(second);
		System.out.println(first.getBalance().floatValue());
		System.out.println(second.getBalance().floatValue());
		System.out.println(axileo.getBalance().floatValue());
	}

}
