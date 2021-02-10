package Sudoku;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3,3));
        JPanel[][] grid = new JPanel[3][3];
        Border blackborder = new LineBorder(Color.black, 1);
        gridPanel.setBorder(blackborder);
        
        JPanel numPad = new JPanel();
        numPad.setBackground(Color.white);
        numPad.setLayout(new GridLayout(3,3));
        numPad.setBorder(new LineBorder(Color.black, 2));
        
        JPanel overall = new JPanel();
//        JLabel title = new JLabel("Welcome to Sudoku");
//        title.setHorizontalTextPosition(JLabel.CENTER);
//        title.setVerticalTextPosition(JLabel.CENTER);
//        title.setSize(500, 500);
//        overall.add(title);
        overall.setBackground(Color.decode("#CCCCCC"));
    
       
        for(int b = 1; b < 10; b++) {
        	userButton choose = new userButton(b);
        	choose.setBackground(Color.blue);
        	choose.addActionListener(new clicks(this));
        	numPad.add(choose);
        }
     
        
        // i = outerRow, j = outerCol, k = innerRow, l = innerCol   
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		JPanel square = new JPanel();
        		grid[i][j] = square;
        		grid[i][j].setBorder(blackborder);
        		grid[i][j].setLayout(new GridLayout(3,3));
        	
        		for(int k = 0; k < grid.length; k++) {
        			for(int l = 0; l < grid[0].length; l++) {
        				button single = new button(numbers[i*3+k][j*3+l], fill[i*3+k][j*3+l]);
        				//System.out.println("["+(i*3+k)+ ", "+ (j*3+l) + "] " + "["+ numbers[i*3+k][j*3+l]+", "+ fill[i*3+k][j*3+l] +"]");
        				single.setOpaque(true);        				
        				if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1) ) {
        					if(fill[i*3+k][j*3+l]) {
        						single.setBackground(Color.decode("#D5F9F5"));
            				}
        					else{
        						single.setBackground(Color.decode("#E6FFFC"));
        					}
                		}
                		else  {
                			if(fill[i*3+k][j*3+l]) {
        						single.setBackground(Color.decode("#F5F5F5"));
            				}
        					else{
        						single.setBackground(Color.white);
        					}
                			
                 		}
        				single.addActionListener(new clicks(this));
        				buttons[i*3+k][j*3+l] = single;
                		grid[i][j].add(single);
        				}
        			}
        		gridPanel.add(grid[i][j]);
        	}
        }
        // padding empty border? or strut? 
        overall.add(gridPanel);
        overall.add(Box.createHorizontalStrut(50));
        overall.add(numPad);
        overall.add(Box.createHorizontalStrut(50));
        
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
		
	public int getCurrentNum() {
		return currentNum;
	}
	
	public void setCurrentNum(int num) {
		currentNum = num;
	}
	
	public boolean checkWin(button b) {
		boolean check = true;
		//System.out.println("Your input: " + b.getInput() + " Correct Num: " + b.getAns());
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[0].length; j++) {
				if(numbers[i][j] == b.getAns()) {
					check = false;
				}
			}
		}
		if(b.getAns() == b.getInput())
			return true;
		return false;
	}
	public static void main(String[] args) {			
			sudoku game = new sudoku();

	}

}
