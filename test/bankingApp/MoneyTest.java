package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import bankingApp.Currency;
import bankingApp.Money;

public class MoneyTest {
	protected Currency CAD, HKD, NOK, EUR;
	protected Money CAD100, EUR10, CAD200, EUR20, CAD0, EUR0, CADnegative100;
	
	@Before
	public void setUp() throws Exception {
		// setup sample currencies
		CAD = new Currency("CAD", 0.75);
		HKD = new Currency("HKD", 0.13);
		EUR = new Currency("EUR", 1.14);
		
		// setup sample money amounts
		CAD100 = new Money(100, CAD);
		
		EUR10 = new Money(10, EUR);
		CAD200 = new Money(200, CAD);
		EUR20 = new Money(20, EUR);
		CAD0 = new Money(0, CAD);
		EUR0 = new Money(0, EUR);
		CADnegative100 = new Money(-100, CAD);
	}

	@Test
	public void testGetAmount() {
		
		assertEquals(100, CAD100.getAmount(), 0.01);
	
	}

	@Test
	public void testGetCurrency() {

		assertEquals(EUR, EUR10.getCurrency());
		
	}

	@Test
	public void testToString() {

		assertEquals("200.0 CAD", CAD200.toString());
	}

	@Test
	public void testGetUniversalValue() {

		assertEquals(11.4, EUR10.getUniversalValue(), 0.01);
	}

	@Test
	public void testEqualsMoney() {

		assertEquals(false, CAD100.equals(EUR10));
	}

	@Test
	public void testAdd() {
	
//		Money expectedMoney = new Money(185.5,CAD);
////		assertEquals(expectedMoney,actualMoney);
//		assertEquals(expectedMoney.toString(),actualMoney.toString());
//		
//		
////		Money test1 = new Money(1,new Currency("INR",0.01));
////		Money test2 = new Money(1,new Currency("INR",0.01));
////		assertEquals(test1.toString(),test2.toString());
		
		Money actualOutput = CAD100.add(EUR10);
		
		double expectedAmount = new Money(108.55,CAD).getAmount();
		Currency expectedCurrency = new Money(108.55,CAD).getCurrency();
		
		assertEquals(expectedAmount,actualOutput.getAmount(),0.01);
		assertEquals(expectedCurrency,actualOutput.getCurrency());
		
//		assertEquals(expectedOutput,actualOutput);
		
//		assertEquals(new Money(108.55,CAD),CAD100.add(EUR10));
		
	}

	@Test
	public void testSubtract() {
//		Money sub = new Money(100, EUR);
//		Money actualMoney = sub.subtract(new Money(100, EUR));
//		
//		
//		Money expectedMoney = new Money(0,EUR);
//		 assertEquals(expectedMoney,actualMoney);
////		assertEquals(expectedMoney.toString(),actualMoney.toString());
		
		// TODO : negative values , values less than current amount
		
		Money actualOutput = CAD100.subtract(EUR10);
		double expectedAmount = new Money(91.45,CAD).getAmount();
		Currency expectedCurrency = new Money(91.45,CAD).getCurrency();
		
		assertEquals(expectedAmount,actualOutput.getAmount(),0.01);
		assertEquals(expectedCurrency,actualOutput.getCurrency());
		
//		assertEquals(expectedOutput.toString(),actualOutput.toString());
		
		
//		assertEquals(new Money(91.45,CAD),CAD100.subtract(EUR10));
	}

	@Test
	public void testIsZero() {
		
		assertEquals(false, CAD100.isZero());
	}

	@Test
	public void testNegate() {
		
		Money expectedMoney = new Money(-100,CAD);
		assertEquals(expectedMoney.toString(), CAD100.negate().toString());
	}

	@Test
	public void testCompareTo() {
		
//		int expectedOutput = CAD.compareTo();
		assertEquals(-1,CAD100.compareTo(EUR0));
	}
}
