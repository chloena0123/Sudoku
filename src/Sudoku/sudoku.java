package Sudoku;

public class sudoku {
	
	public static void main(String[] args) {
			int[][] grid = {{8,2,7,1,5,4,3,9,6},
							{9,6,5,3,2,7,1,4,8},
							{3,4,1,6,8,9,7,5,2},
							{5,9,3,4,6,8,2,7,1}, 
							{4,7,2,5,1,3,6,8,9}, 
							{6,1,8,9,7,2,4,3,5}, 
							{7,8,6,2,3,5,9,1,4}, 
							{1,5,4,7,9,6,8,2,3}, 
							{2,3,9,8,4,1,5,6,7}};
			
			boolean[][] fill = {{false,true,false,false,false,true,true,false,false},
								{true,false,false,false,true,false,false,false,true},
								{false,false,false,true,false,true,false,true,false},
								{false,false,false,false,false,false,false,false,true},
								{false,true,true,true,false,true,true,true,false},
								{true,false,false,false,false,false,false,false,false},
								{false,true,false,true,false,true,false,false,false},
								{true,false,false,false,true,false,false,false,true},
								{false,false,true,true,false,false,false,true,false}};
			
			
			for (int i = 0; i < 9; i++) {
				for(int j = 0; j < 9 ; j++) {
					if (fill[i][j]) {
						System.out.print(grid[i][j] + " ");
					}else {
						System.out.print(" " + " ");
					}
				}
				System.out.println();
			}

	}

}
