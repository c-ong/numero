package coder36.numero.factory;

import coder36.numero.service.NumFormatterService;
import coder36.numero.service.impl.EnglishNumFormatterServiceImpl;

/**
 * Factory to get instances of NumFormatService
 * @author Mark Middleton
 */
public class NumFormatterFactory {
	
	/**
	 * Get instance of NumFormatterService
	 * @return instance of NumFormatterService
	 */
	public static NumFormatterService getInstance() {		
		// the idea here is that different implementations could be
		// returned ie. a FrenchNumberFormatter.  This could be based on Locale
		return new EnglishNumFormatterServiceImpl();
	}
}
