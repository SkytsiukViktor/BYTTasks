package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
			testAccount.addTimedPayment("2", 100,100, new Money(100,SEK), DanskeBank, "Alice");
			assertTrue("error",testAccount.timedPaymentExists("2"));
			testAccount.removeTimedPayment("2");
			assertFalse("error",testAccount.timedPaymentExists("2"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
			
		testAccount.addTimedPayment("2", 100,100, new Money(100,SEK), DanskeBank, "Alice");
		testAccount.tick();
			
	}

	@Test
	public void testAddWithdraw() {
		Account test=new Account("ABC",SEK);
		test.deposit(new Money(1000,SEK));
		assertTrue("error",test.getBalance().equals(new Money(1000,SEK)));
		assertFalse("error",test.getBalance().equals(new Money(1000,SEK)));
		test.withdraw(new Money(500,SEK));
		assertTrue("error",test.getBalance().equals(new Money(500,SEK)));
		assertFalse("error",test.getBalance().equals(new Money(1000,SEK)));
	}
	
	@Test
	public void testGetBalance() {
		Account test=new Account("ABC",SEK);
		test.deposit(new Money(1000,SEK));
		assertTrue("error",test.getBalance().equals(new Money(10001000,SEK)));
		assertFalse("error",test.getBalance().equals(new Money(800,SEK)));
	}
	
}
