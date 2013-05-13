import coder36.numero.factory.NumFormatterFactory;
import coder36.numero.service.NumFormatterService;

/**
 * NumFormatter main class:
 * Usage: java NumFormatter <number>
 * @author Mark Middleton
 */
public class NumFormatter {

	public static void main( String [] args ) {
		
		NumFormatterService svc = NumFormatterFactory.getInstance();
		
		if ( args.length != 1 ) {
			exit();
		}
		
		int n = 0;
		try {
			n = Integer.parseInt( args[0] );
		}
		catch( NumberFormatException e ) {
			System.err.println( "Number must be between 0 and 999999999" );
			exit();
		}
					
		System.out.println( n + " --> " );
		System.out.println( svc.format(n) );
	}
	
	private static void exit() {
		System.err.println( "Usage: java NumFormatter <number>" );
		System.exit(1);		
	}
}
