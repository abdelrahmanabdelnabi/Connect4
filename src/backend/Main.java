package backend;

public class Main {
	//got from here
	//http://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	static final String ANSI_RESET = "\u001B[0m";
	static final String ANSI_BLACK = "\u001B[30m";
	static final String ANSI_RED = "\u001B[31m";
	static final String ANSI_GREEN = "\u001B[32m";
	static final String ANSI_YELLOW = "\u001B[33m";
	static final String ANSI_BLUE = "\u001B[34m";
	static final String ANSI_PURPLE = "\u001B[35m";
	static final String ANSI_CYAN = "\u001B[36m";
	static final String ANSI_WHITE = "\u001B[37m";
	static void welcome(){
		System.out.println(ANSI_GREEN);
		System.out.println("       _/_/_/                                                      _/        _/  _/");
		System.out.println("     _/         _/_/    _/_/_/    _/_/_/      _/_/      _/_/_/  _/_/_/_/    _/  _/");
		System.out.println("    _/       _/    _/  _/    _/  _/    _/  _/_/_/_/  _/          _/        _/_/_/_/");
		System.out.println("   _/       _/    _/  _/    _/  _/    _/  _/        _/          _/            _/");
		System.out.println("    _/_/_/   _/_/    _/    _/  _/    _/    _/_/_/    _/_/_/      _/_/        _/");
		System.out.println(ANSI_RESET);
	          
	}
	public static void main(String[] argv){
		welcome();
		Connect4 NewGame = new Connect4
	}
}
