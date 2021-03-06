package backend;
public class Connect4 {
	
	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	int CurrentPlayer; //either 1 or 2
	//array grows toward lower addresses
	//this is typically perfect array 
	//regardless to the fact that the
	//ones and twos are not even
	//0 0 0 0 0 0 0
	//0 0 0 0 0 0 0
	//1 0 2 0 1 0 0
	//2 0 1 0 1 0 0
	//1 2 1 2 1 0 0
	//1 2 2 2 1 0 0
	int [][] Array;
	//  [6][7]
	public int[][] getArray(){
		return Array;
	}
	//inserts a coin in the right place then
	//returns -2 if it is impossible to insert the coin
	//switch the players color and check for winner
	public int insertCoin(int here){
		int i;
		for (i=ROWS-1;i>0;i--)
			if(Array[i][here]==0)
				break;
		if (Array[i][here]!=0)
			return -2;	
		Array[i][here] = CurrentPlayer;
		switchPlayer();
		return getWinner();
	}
	void switchPlayer(){
		CurrentPlayer = 3- CurrentPlayer;
	}
	public int getPlayer(){
		return CurrentPlayer;
	}
	//returns the winner or -1 if the array is
	//full with no winner returns 0 otherwise	
	public int getWinner(){
		int i,j;
		for(i=0;i<ROWS;i++)
			for(j=0;j<COLUMNS;j++){
				if (Array[i][j]==0)
					continue;
				if(j+3<COLUMNS)
					if(Array[i][j] == Array[i][j+1] && 
					   Array[i][j] == Array[i][j+2] &&
					   Array[i][j] == Array[i][j+3])
						return Array[i][j];
				if(i+3<ROWS)
					if(Array[i][j] == Array[i+1][j] &&
					   Array[i][j] == Array[i+2][j] &&
					   Array[i][j] == Array[i+3][j])
						return Array[i][j];
				if(i+3<ROWS &&j+3<COLUMNS)
					if(Array[i][j] == Array[i+1][j+1] &&
					   Array[i][j] == Array[i+2][j+2] &&
					   Array[i][j] == Array[i+3][j+3])
						return Array[i][j];
				if(i+3<ROWS &&j-3>=0)
					if(Array[i][j] == Array[i+1][j-1] &&
					   Array[i][j] == Array[i+2][j-2] &&
					   Array[i][j] == Array[i+3][j-3])
						return Array[i][j];
			}
		int zeros=0;
		for(j=0;j<COLUMNS;j++)
			if(Array[0][j]==0)
				zeros++;
		return zeros ==0? -1 :0;
	}
	public Connect4(){
		Array = new int[ROWS][COLUMNS]; //defaults to zero
		CurrentPlayer=1;
		
	}
}
