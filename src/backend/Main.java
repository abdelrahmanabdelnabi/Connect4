package backend;
import java.util.Scanner;
public class Main {
	static void welcome(){
		System.out.println("       _/_/_/                                                      _/        _/  _/");
		System.out.println("     _/         _/_/    _/_/_/    _/_/_/      _/_/      _/_/_/  _/_/_/_/    _/  _/");
		System.out.println("    _/       _/    _/  _/    _/  _/    _/  _/_/_/_/  _/          _/        _/_/_/_/");
		System.out.println("   _/       _/    _/  _/    _/  _/    _/  _/        _/          _/            _/");
		System.out.println("    _/_/_/   _/_/    _/    _/  _/    _/    _/_/_/    _/_/_/      _/_/        _/");
	         
	}
	public static void main(String[] argv){
		welcome();
		Connect4 NewGame = new Connect4();
		int state;
		Scanner Input = new Scanner(System.in);
		do{
			System.out.println("player"+NewGame.getPlayer()+":");
			int IntInput = Input.nextInt();
			state = NewGame.insertCoin(IntInput);
			int [][] Array = NewGame.getArray();
			int i,j;
			for(i=0;i<Connect4.ROWS;i++){
				System.out.println("+-+-+-+-+-+-+-+");
				System.out.print("|");
				for(j=0;j<Connect4.COLUMNS;j++)
					System.out.print((Array[i][j]==0?" ":Array[i][j])+"|");
				System.out.println("");
			}
			System.out.println("+-+-+-+-+-+-+-+");

		}while(state==0 || state==-2);
		Input.close();
		System.out.println(state!=-1?"Winner is player" + state:"Draw!");
		
	}
}
