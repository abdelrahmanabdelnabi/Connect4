package backend;

public class Connect4 {
	int [][] Array;
	public int[][] getArray(){
		return Array;
	}
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
