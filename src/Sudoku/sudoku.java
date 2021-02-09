package Sudoku;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class sudoku extends JFrame {
	int[][] numbers;
	boolean[][] fill;
	button [][] buttons;
	int currentNum;
	
	public sudoku() {
		super("Sudoku");
		
		//initialize instance variables
		numbers = getArr();
		fill = toDisplay();
		printGrid();
		buttons = new button[9][9];
			
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel overall = new JPanel();
        overall.setLayout(new GridLayout(3,3));
        JPanel[][] grid = new JPanel[3][3];
        Border blackborder = BorderFactory.createLineBorder(Color.black);
        overall.setBorder(blackborder);
        
        JPanel user = new JPanel();
        user.setLayout(new GridLayout(3,3));
       
        for(int b = 1; b < 10; b++) {
        	userButton choose = new userButton(b);
        	user.add(choose);
        }
       // currentNum = choose.getVal();
        
        // i = outerRow, j = outerCol, k = innerRow, l = innerCol   
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		grid[i][j] = new JPanel();
        		grid[i][j].setBorder(blackborder);
        		grid[i][j].setLayout(new GridLayout(3,3));
        	
        		for(int k = 0; k < grid.length; k++) {
        			for(int l = 0; l < grid[0].length; l++) {
        				button single = new button(numbers[i*3+k][j*3+l], fill[i*3+k][j*3+l]);
        				//System.out.println("["+(i*3+k)+ ", "+ (j*3+l) + "] " + "["+ numbers[i*3+k][j*3+l]+", "+ fill[i*3+k][j*3+l] +"]");
        				single.addActionListener(new clicks(this));
        				buttons[i*3+k][j*3+l] = single;
                		grid[i][j].add(single);
        				}
        			}
        		overall.add(grid[i][j]);
        	}
        }
        this.add(overall);
        this.pack();
		
	}
	
	public void printGrid() {
		for (int i = 0; i < 9; i++) {
			for(int j = 0; j < 9 ; j++) {
				if (fill[i][j]) {
					System.out.print(numbers[i][j] + " ");
				}else {
					System.out.print(" " + " ");
				}
			}
			System.out.println();
		}
	}
	
	public int[][] getArr() {
		int[][] numbers = {{8,2,7,1,5,4,3,9,6},
				{9,6,5,3,2,7,1,4,8},
				{3,4,1,6,8,9,7,5,2},
				{5,9,3,4,6,8,2,7,1}, 
				{4,7,2,5,1,3,6,8,9}, 
				{6,1,8,9,7,2,4,3,5}, 
				{7,8,6,2,3,5,9,1,4}, 
				{1,5,4,7,9,6,8,2,3}, 
				{2,3,9,8,4,1,5,6,7}};
		return numbers;
	}
	
	public boolean[][] toDisplay() {
		boolean[][] fill = {{false,true,false,false,false,true,true,false,false},
				{true,false,false,false,true,false,false,false,true},
				{false,false,false,true,false,true,false,true,false},
				{false,false,false,false,false,false,false,false,true},
				{false,true,true,true,false,true,true,true,false},
				{true,false,false,false,false,false,false,false,false},
				{false,true,false,true,false,true,false,false,false},
				{true,false,false,false,true,false,false,false,true},
				{false,false,true,true,false,false,false,true,false}};
		return fill;
	}
	
	public int getNum() {
		return currentNum;
	}
	public static void main(String[] args) {			
			sudoku game = new sudoku();

	}

}
