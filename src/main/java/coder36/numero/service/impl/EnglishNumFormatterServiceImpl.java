package coder36.numero.service.impl;

import coder36.numero.service.NumFormatterService;

/**
 * English language implementation of NumFormatterService
 * Can handle numbers from 0 to 999999999
 * 
 * Notes:
 * The trick to this puzzle is to spot the pattern and break it up into 
 * repeatable chunks: 
 * In general any number can be written as:
 * [1-999] million [1-999] thousand [1-999] 
 * 
 * -----------
 * [1-999] can be written as:
 * X hundred and AB  ie. one hundred and fifty six
 * X can take a value of one,two...nine
 * 
 * Breaking AB up:
 * 'A' can take a value of ten,twenty...ninety or blank if 0,
 * 'B' can take a value of one,two...nine
 * Except when AB is between 11-19 then it becomes eleven,twelve...nineteen.
 *-------------
 * 
 * Another case to consider is:
 * X million and NN ie. 10 million and one
 * X thousand and NN ie. 10 thousand and one
 * 
 * 
 * The implementation is as clear and concise as I can make it - I find this 
 * coding style tends to reduce the defects simply because there is less code.
 * 
 * The algorithm I used is all about working out a series of indexes from the number, then 
 * using this to directly access the english language arrays, building up a string.
 * 
 * @author Mark Middleton
 */
public class EnglishNumFormatterServiceImpl implements NumFormatterService {
	
	// English language arrays.  Note that the first element is blank.
	private String [] units = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	private String [] teens = { "", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	private String [] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	
	/**
	 * {@inheritDoc}
	 */
	public String format( int num ) {	
		// check boundaries
		if ( num < 0 | num > 999999999 ) {
			throw new IllegalArgumentException( "Only values between 0 and 999999999 are allowed" );
		}
		if ( num == 0 ) return "zero";
		String s = decode( num, 1000000, "million" ) + decode( num, 1000, "thousand" ); 
						
		String d = decode( num, 1, "" );
		// handle "one million and one" case
		if( num % 1000 < 100 && !s.isEmpty() && ! d.isEmpty() ) {
			s += "and ";
		}
		s+= d;		
		
		return s.trim();
	}

	/**
	 * Decode number into thousands and millions
	 * @param num The number
	 * @param scale eg 1,     1000,     1000000
	 * @param unit eg. blank, thousand, million
	 * @return
	 */
	private String decode( int num, int scale, String unit ) {
		String b = decode999( num / scale );
		return b.isEmpty() ? "" : b + " " + unit + " ";
	}
	
	/**
	 * Decode numbers between 1 and 999.
	 * Implementation takes the number then uses modulus arithmetic to extract an index which 
	 * is then used to access the units[], teens[] and tens[] arrays.  
	 * @param num This can be any number, but only the first 3 digits are decoded.
	 * @return String representation of num
	 */
	private String decode999( int num ) {
		String s = "";		
		// work out hundreds : numbers 100-900
		int n = num % 1000;   // extract the first 3 digits from num
		if ( n >=100 ) s += units[ n / 100 ] + " hundred";		
		if ( n>=100 && n % 100 != 0 ) s+= " and ";
		
		// numbers 1-99
		n = num % 100;  // extract the first 2 digits from num
		if ( n < 10 ) s+= units[ n % 10 ];
		// special case numbers 11-19
		if ( n >= 11 && n <=19 ) s+= teens[ n % 10 ];
		// everything else
		if ( n==10 || n>=20 ) {
			s += tens[ (n/10) % 10 ];		
			if ( n % 10 != 0 ) s += " " + units[ n % 10 ];
		}		
		return s;		
	}		
}