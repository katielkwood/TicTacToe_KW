package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
public class TicTacToeGame {

	
	/*private char[][] board = new char[3][3];
	private int moveCounter;
	
	public TicTacToe(){
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				board[row][col] = ' ';
			}
		}
		moveCounter = 0;
	}
	public char getMark(int row, int col){
		return board[row][col];
	}
	
	public void setMark(int row, int col){
		if (board[row][col] == ' '){
			if(moveCounter%2 == 0){
				board[row][col] = 'X';
				moveCounter++;
			}
			else {
				board[row][col] = 'O';
				moveCounter++;	
			}
		}
	}
	
	public boolean gameWon(){
		boolean result = false;
		for (int row = 0; row < 3; row++){
			if (getMark(row, 0) == getMark(row, 1) && getMark(row, 1) == getMark(row, 2) &&
				getMark(row, 0) != ' '){
				result = true;
			}
		}
		for (int col = 0; col < 3; col++){
			if (getMark(0, col) == getMark(1, col) && getMark(1, col) == getMark(2, col) &&
				getMark(0, col) != ' '){
				result = true;
			}
		}
		if (getMark(0, 0) == getMark(1, 1) && getMark(1, 1) == getMark(2, 2) && 
			getMark(0, 0) != ' '){
			result = true;
		}
		else if (getMark(2, 0) == getMark(1, 1) && getMark(1, 1) == getMark(0, 2) &&
					getMark(2, 0) != ' '){
			result = true;
		}
		return result;
	}
	public boolean tieGame(){
		boolean result = true;
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				if (board[row][col] == ' '){
					result = false;
				}
			}
		}
		return result;
	}
	
	public boolean gameOver(){
		boolean result;
		if (gameWon() == true){
			result = true;
		}
		else if (tieGame() == true){
			result = true;
		}
		else {
			result = false;
		}
		return result;
	}
	
	public String getGameResult(){
		String result ="";
		if (gameOver() == true){
			if (gameWon() == true){
				if (moveCounter%2 == 1){
					result = "Player X wins";
				}
				else {result = "Player O wins";}
			}
			else if(tieGame() == true){result = "TIE";}
			else{result = "error";}
		}
		else {result = "still playing";}
		
		return result;
	}*/
	/*public class TicTacToePanel extends JPanel{
		private JButton row0col0;
		private JButton row0col1;
		private JButton row0col2;
		private JButton row1col0;
		private JButton row1col1;
		private JButton row1col2;
		private JButton row2col0;
		private JButton row2col1;
		private JButton row2col2;
		private JLabel label;
		private JPanel buttonPanel;
	
		public TicTacToePanel (){
			TicTacToe t = new TicTacToe();
		
			//row0col0 = new JButton(/*t.getMark(0, 0)*///);
			//row0col1 = new JButton(/*t.getMark(0, 1)*/);
			//row0col2 = new JButton(/*t.getMark(0, 2)*/);
			//row1col0 = new JButton(/*t.getMark(1, 0)*/);
			//row1col1 = new JButton(/*t.getMark(1, 1)*/);
			//row1col2 = new JButton(/*t.getMark(1, 2)*/);
			//row2col0 = new JButton(/*t.getMark(2, 0)*/);
			//row2col1 = new JButton(/*t.getMark(2, 1)*/);
			//row2col2 = new JButton(/*t.getMark(2, 2)*/);
			
			/*ButtonListener listener = new ButtonListener();
			row0col0.addActionListener(listener);
			row0col1.addActionListener(listener);
			row0col2.addActionListener(listener);
			row1col0.addActionListener(listener);
			row1col1.addActionListener(listener);
			row1col2.addActionListener(listener);
			row2col0.addActionListener(listener);
			row2col1.addActionListener(listener);
			row2col2.addActionListener(listener);
			
			label = new JLabel("Player X, place your mark.");
			
			buttonPanel = new JPanel();
			buttonPanel.setLayout(new GridLayout(3, 3));
			buttonPanel.setPreferredSize(new Dimension(400, 400));
			buttonPanel.setBackground(Color.blue);
			buttonPanel.add(row0col0);
			buttonPanel.add(row0col1);
			buttonPanel.add(row0col2);
			buttonPanel.add(row1col0);
			buttonPanel.add(row1col1);
			buttonPanel.add(row1col2);
			buttonPanel.add(row2col0);
			buttonPanel.add(row2col1);
			buttonPanel.add(row2col2);
			
			setPreferredSize(new Dimension(400, 450));
			setBackground(Color.white);
			add(label);
			add(buttonPanel);
		}
		private class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if (event.getSource() == row0col0){
					setMark(0, 0);
				}
			}
		}
	}*/

	public static void main(String[] args) {
	
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TicTacToePanel panel = new TicTacToePanel();
		//frame.getContentPane().add(new TicTacToePanel());
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		/*TicTacToe t = new TicTacToe();
		System.out.println("Welcome to Tic-Tac-Toe");
		while (t.gameOver() == false){
			System.out.println("   (0)(1)(2)");
			System.out.println("(0)["+t.board[0][0]+"]["+t.board[0][1]+"]["+t.board[0][2]+"]");
			System.out.println("(1)["+t.board[1][0]+"]["+t.board[1][1]+"]["+t.board[1][2]+"]");
			System.out.println("(2)["+t.board[2][0]+"]["+t.board[2][1]+"]["+t.board[2][2]+"]");
			if (t.moveCounter%2 == 0){
				System.out.println("Player X");
			}
			else {System.out.println("Player O");}
			System.out.println("Enter the row number of the space you want to play");
			Scanner inputScanner = new Scanner(System.in);
			int rowNum = inputScanner.nextInt();
			System.out.println("Enter the column number of the space you want to play");
			int colNum = inputScanner.nextInt();
			t.setMark(rowNum, colNum);
		}
		System.out.println(t.getGameResult());*/
	}
	
	
}
