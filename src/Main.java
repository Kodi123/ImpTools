import DebugConsole.Console;

public class Main {
	public static void main(String[] args) {
		Console Console = new Console();

		Console.setVisible(true);
		Console.DebugPrint("Logging Started!");
		while(true) {
			System.out.println(Console.getHeight());
		}
	}
}
