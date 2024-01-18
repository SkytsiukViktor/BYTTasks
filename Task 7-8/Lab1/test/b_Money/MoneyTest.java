package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(" The number should be 10000.", Integer.valueOf(10000), SEK100.getAmount());
		assertEquals(" The number should be 1000.", Integer.valueOf(1000), EUR10.getAmount());
		assertEquals(" The number should be 20000.", Integer.valueOf(20000), SEK200.getAmount());
		assertEquals(" The number should be 2000.", Integer.valueOf(2000), EUR20.getAmount());
		assertEquals(" The number should be 0.", Integer.valueOf(0), SEK0.getAmount());
		assertEquals(" The number should be 0.", Integer.valueOf(0), EUR0.getAmount());
		assertEquals(" The number should be -10000.", Integer.valueOf(-10000), SEKn100.getAmount());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(" The name should be SEK.", SEK, SEK100.getCurrency());
		assertEquals(" The name should be EUR.", EUR, EUR10.getCurrency());
		assertEquals(" The name should be SEK.", SEK, SEK200.getCurrency());
		assertEquals(" The name should be EUR.", EUR, EUR20.getCurrency());
		assertEquals(" The name should be SEK.", SEK, SEK0.getCurrency());
		assertEquals(" The name should be EUR.", EUR, EUR0.getCurrency());
		assertEquals(" The name should be SEK.", SEK, SEKn100.getCurrency());	}

	@Test
	public void testToString() {
		assertEquals(" should be 100 SEK.", "100 SEK", SEK100.toString());
		assertEquals(" should be 10 EUR.", "10 EUR", EUR10.toString());
		assertEquals(" should be 200 SEK.", "200 SEK", SEK200.toString());
		assertEquals(" should be 20 EUR.","20 EUR", EUR20.toString());
		assertEquals(" should be 0 SEK.","0 SEK", SEK0.toString());
		assertEquals(" should be 0 EUR.", "0 EUR", EUR0.toString());
		assertEquals(" should be -100 SEK.", "-100 SEK", SEKn100.toString());	}

	@Test
	public void testGlobalValue() {
		assertEquals(" value should be 1500.", Integer.valueOf(1500), SEK100.universalValue());
		assertEquals(" value should be 1500.", Integer.valueOf(1500), EUR10.universalValue());
		assertEquals(" value should be 3000.", Integer.valueOf(3000) , SEK200.universalValue());
		assertEquals(" value should be 3000.", Integer.valueOf(3000), EUR20.universalValue());
		assertEquals(" value should be 0", Integer.valueOf(0), SEK0.universalValue());
		assertEquals(" value should be 0 ", Integer.valueOf(0), EUR0.universalValue());
		assertEquals(" value should be -1500 ", Integer.valueOf(-1500), SEKn100.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		String a="wrong result";
		assertTrue(a, SEK100.equals(EUR10));
		assertTrue(a, SEK200.equals(EUR20));
		assertTrue(a, SEK0.equals(EUR0));
		assertFalse(a, SEKn100.equals(EUR20));
		assertFalse(a, SEKn100.equals(SEK200));
	}
	
	@Test
	public void testAdd() {
		String a="wrong result";
		assertTrue(a, new Money(20000,SEK).equals (SEK100.add(EUR10)));
		assertTrue(a, new Money(30000,SEK).equals (SEK100.add(SEK200)));
		assertTrue(a, new Money(3000,EUR).equals (EUR10.add(EUR20)));
		assertTrue(a, new Money(0,SEK).equals (SEKn100.add(EUR10)));
		assertTrue(a, new Money(0,SEK).equals (SEK0.add(EUR0)));
	}
	
	@Test
	public void testSub() {
		String a="wrong result";
		assertTrue(a, new Money(0,SEK).equals (SEK100.sub(EUR10)));
		assertTrue(a, new Money(10000,SEK).equals (SEK200.sub(SEK100)));
		assertTrue(a, new Money(1000,EUR).equals (EUR20.sub(EUR10)));
	}

	@Test
	public void testIsZero() {
		String a="wrong result";
		assertFalse(a,SEK100.isZero() );
		assertTrue(a,SEK0.isZero() );
		assertFalse(a,SEKn100.isZero() );
		assertFalse(a,EUR10.isZero() );
		assertTrue(a,EUR0.isZero() );
	}
	@Test
	public void testNegate() {
		String a="wrong result";
		assertTrue(a, new Money(0,SEK).equals (SEK0.negate()));
		assertTrue(a, new Money(10000,SEK).equals (SEKn100.negate()));
		assertTrue(a, new Money(-1000,EUR).equals (EUR10.negate()));
	}

	@Test
	public void testCompareTo() {
		String a="wrong result";
		assertEquals(a, 0,(SEK100.compareTo(EUR10)));
		assertEquals(a, 0,(EUR20.compareTo(SEK200)));
		assertEquals(a, -1,(SEK100.compareTo(EUR20)));
		assertEquals(a, 1,(SEK200.compareTo(SEK100)));
		
	}
}
