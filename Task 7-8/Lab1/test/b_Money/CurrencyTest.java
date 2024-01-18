package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals(" The name should be SEK.", "SEK", SEK.getName());
		assertEquals(" The name should be DKK.", "DKK", DKK.getName());
		assertEquals(" The name should be EUR.", "EUR", EUR.getName());
	}
	
	@Test
	public void testGetRate() {
		
		assertEquals("The rate should be 0.15", Double.valueOf(0.15), SEK.getRate());
		assertEquals("The rate should be 0.20", Double.valueOf(0.20), DKK.getRate());
		assertEquals("The rate should be 1.5", Double.valueOf(1.5), EUR.getRate());
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(3.0);
		assertEquals("The rate should be 3", Double.valueOf(3),SEK.getRate() );
		DKK.setRate(4.0);
		assertEquals("The rate should be 4", Double.valueOf(4),DKK.getRate() );
		EUR.setRate(1.0);
		assertEquals("The rate should be 1", Double.valueOf(1),EUR.getRate() );
	}
	
	@Test
	public void testGlobalValue() {
		assertEquals("The global value should be 300",Integer.valueOf(300),SEK.universalValue(2000));
		assertEquals("The global value should be 400",Integer.valueOf(400),DKK.universalValue(2000));
		assertEquals("The global value should be 3000",Integer.valueOf(3000),EUR.universalValue(2000));
	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals("The value should be 2000",Double.valueOf(2000),SEK.valueInThisCurrency(1500,DKK));
		assertEquals("The value should be 15000",Double.valueOf(15000),DKK.valueInThisCurrency(2000,EUR));
		assertEquals("The value should be 400",Double.valueOf(300),EUR.valueInThisCurrency(3000,SEK));
	}
	
}
