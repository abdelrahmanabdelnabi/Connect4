package backend;

public class Connect4 {
	int CurrentPlayer; //either 1 or 2
	//array grows toward lower addresses
	//this is typically perfect array
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
	//insert
	public int insertCoin(int where,int ){
		
		return getWinner();
	}
	//returns the winner or returns 0 otherwise
	int getWinner(){
		int i,j;
		for(i=0;i<6;i++)
			for(j=0;j<7;j++){
				if (Array[i][j]==0)
					continue;
				if(j+3<6)
					if(Array[i][j] == Array[i][j+1] && 
					   Array[i][j] == Array[i][j+2] &&
					   Array[i][j] == Array[i][j+3])
						return Array[i][j];
				if(i+3<7)
					if(Array[i][j] == Array[i+1][j] &&
					   Array[i][j] == Array[i+2][j] &&
					   Array[i][j] == Array[i+3][j])
						return Array[i][j];
				if(i+3<7 &&j+3<6)
					if(Array[i][j] == Array[i+1][j+1] &&
					   Array[i][j] == Array[i+2][j+2] &&
					   Array[i][j] == Array[i+3][j+3])
						return Array[i][j];
				if(i+3<7 &&j-3>=0)
					if(Array[i][j] == Array[i+1][j-1] &&
					   Array[i][j] == Array[i+2][j-2] &&
					   Array[i][j] == Array[i+3][j-3])
						return Array[i][j];
			}
		return 0;
	}
	Connect4(){
		Array = new int[6][7]; //defaults to zero
		
	}
}
