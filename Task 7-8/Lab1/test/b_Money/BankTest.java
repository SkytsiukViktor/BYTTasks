package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		String errormsg="result is inccorect";
		assertEquals(errormsg, "SweBank", SweBank.getName());
		assertEquals(errormsg, "DanskeBank", DanskeBank.getName());
		
	}

	@Test
	public void testGetCurrency() {
		String errormsg="result is inccorect";
		assertEquals(errormsg, SEK, SweBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		
		SweBank.openAccount("Ulrika");
		
		
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		
		SweBank.deposit("Ulrika", new Money(2000,SEK));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.withdraw("Ulrika", new Money(2000,SEK));
	}
	
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		SweBank.getBalance("Ulrika");
	}
	
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.transfer("Ulrika", "Bob", null);
	}
	
	@Test
	//public void addTimedPayment(String accountid, String payid, Integer interval, Integer next, Money amount, Bank tobank, String toaccount) {
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Ulrika", "pay1", 500, 10, new Money(1000,SEK), DanskeBank, "Gertrud");
		SweBank.removeTimedPayment("Ulrika", "pay1");
	}
}
