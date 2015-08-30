package DebugConsole;
import java.util.ArrayList;

public class Logging {
	
	public Logging( ){
		DebugPrint("Debugging enabled.");
	}
	
	public static void DebugPrint( String Message ) {
		System.out.println("Debug: " + Message );
	}
	
	public static void DebugTable( ArrayList<String> messages, String Iterator ) {
		String CheckIterator = ParseIterator(Iterator);
		for( int i = 0; i < messages.size(); i++ ) {
			if( CheckIterator == "Numbers" ) {
				DebugPrint(i + " - " + messages.get(i) );
			} else {
				DebugPrint( CheckIterator + " - " + messages.get(i) );
			}
		}
	}
	
	private static String ParseIterator( String Iterator ) {
		switch( Iterator ) {
		case("+"):
			return "+";
		case("#"):
			return "Numbers";
		default:
			return Iterator;
		
		}
	}
}