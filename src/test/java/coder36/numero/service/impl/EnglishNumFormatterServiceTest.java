package coder36.numero.service.impl;


import org.junit.Before;
import org.junit.Test;

import coder36.numero.service.NumFormatterService;
import coder36.numero.service.impl.EnglishNumFormatterServiceImpl;

import static org.junit.Assert.*;

/**
 * Test suite for EnglishNumFormatterServiceImpl.  
 * @author Mark Middleton
 */
public class EnglishNumFormatterServiceTest {

	private NumFormatterService svc;
	
	@Before
	public void setUp() {
		svc = new EnglishNumFormatterServiceImpl();
	}

	/**
	 * The puzzle came supplied with 5 sample numbers.  Test these.
	 */
	@Test
	public void testPuzzleSamples() {		
		assertEquals( svc.format(1), "one" );
		assertEquals( svc.format(33), "thirty three" );
		assertEquals( svc.format(635), "six hundred and thirty five" );
		assertEquals( svc.format(76876586), "seventy six million eight hundred and seventy six thousand five hundred and eighty six" );
		assertEquals( svc.format(999999999), "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" );
	}

	/**
	 * Test numbers between 1-999.  Here we are looking to prove the spelling of all the
	 * numbers, and prove that the algorithm to generate numbers 1-999 works.
	 */
	@Test
	public void testDecode999() {
		assertEquals( "zero", svc.format(0));
		assertEquals( "one", svc.format(1));
		assertEquals( "two", svc.format(2));
		assertEquals( "three", svc.format(3));
		assertEquals( "four", svc.format(4));
		assertEquals( "five", svc.format(5));
		assertEquals( "six", svc.format(6) );
		assertEquals( "seven", svc.format(7) );
		assertEquals( "eight", svc.format(8) );
		assertEquals( "nine", svc.format(9) );

		assertEquals( "eleven", svc.format(11));
		assertEquals( "twelve", svc.format(12));
		assertEquals( "thirteen", svc.format(13));
		assertEquals( "fourteen", svc.format(14));
		assertEquals( "fifteen", svc.format(15));
		assertEquals( "sixteen", svc.format(16) );
		assertEquals( "seventeen", svc.format(17) );
		assertEquals( "eighteen", svc.format(18) );
		assertEquals( "nineteen", svc.format(19) );
		
		assertEquals( "ten", svc.format(10) );
		assertEquals( "twenty", svc.format(20) );
		assertEquals( "thirty", svc.format(30) );
		assertEquals( "forty", svc.format(40) );
		assertEquals( "fifty", svc.format(50) );
		assertEquals( "sixty", svc.format(60) );
		assertEquals( "seventy", svc.format(70) );
		assertEquals( "eighty", svc.format(80) );
		assertEquals( "ninety", svc.format(90) );
				
		assertEquals( "twenty one", svc.format(21) );		
		assertEquals( "ninety nine", svc.format(99) );
		assertEquals( "one hundred", svc.format(100));
		assertEquals( "nine hundred", svc.format(900) );
		assertEquals( "one hundred and one", svc.format(101)  );
		assertEquals( "nine hundred and ninety nine", svc.format(999)  );
	}	

	/**
	 * Test numbers between 1000-999,999
	 */
	@Test
	public void testDecodeThousand() {
		assertEquals( "one thousand", svc.format(1000));
		// this is a special case
		assertEquals( "one thousand and one", svc.format(1001));
		assertEquals( "one thousand and ninety nine", svc.format(1099));
		assertEquals( "one thousand nine hundred and ninety nine", svc.format(1999));
		assertEquals( "one hundred thousand", svc.format(100000));
		assertEquals( "nine hundred and ninety nine thousand nine hundred and ninety nine", svc.format(999999) );
	}	
	
	/**
	 * Test numbers between 1,000,000 - 999,999,9999
	 */
	@Test
	public void testDecodeMillion() {
		assertEquals( "one million", svc.format(1000000));
		// this is a special case
		assertEquals( "one million and one", svc.format(1000001));
		assertEquals( "one million one hundred", svc.format(1000100));
		assertEquals( "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", svc.format(999999999) );
	}	
	
	/**
	 * Test negative number results in an exception
	 */
	@Test( expected=IllegalArgumentException.class)	
	public void testNegativeNumber() {
		svc.format( -1 );
	}

	/**
	 * Test number > 999999999 results in an exception
	 */
	@Test( expected=IllegalArgumentException.class)	
	public void testLargeNumber() {
		svc.format( 1000000000 );
	}	
}
