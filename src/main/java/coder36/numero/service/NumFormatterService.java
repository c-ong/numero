package coder36.numero.service;

/**
 * Service to handle the formatting of numbers.  This service could be set up as a spring bean, or
 * statless session bean and injected where needed.  I've also provided a factory method to show an
 * alternative (none Jee/spring) appraoch.
 * @author Mark Middleton
 */
public interface NumFormatterService {
	
	/**
	 * Convert an integer into words
	 * eg. 
	 *      333 -> three hundred and thirty three
	 *    15667 -> fifteen thousand six hundred and sixty seven  
	 * @param num The number
	 * @return formatted string
	 */
	public String format( int num );	
}
