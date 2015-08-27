import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main( String[] args ) {
    	Debugging.DebugPrint( "Hello World!" );
    	List<String> Messages = new ArrayList<String>();
    	Messages.add("Hello");
    	Messages.add("World");
    	Messages.add("!");
    	
    	Debugging.DebugTable(Messages, "Debug Table Test");

    }


}
