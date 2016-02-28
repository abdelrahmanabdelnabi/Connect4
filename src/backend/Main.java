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
			for(i=0;i<6;i++){
				for(j=0;j<7;j++)
					System.out.print(Array[i][j]+" ");
				System.out.println("");
			}
		}while(state==0);
		Input.close();
		
	}
}
