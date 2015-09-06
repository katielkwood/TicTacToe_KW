package edu.jsu.mcis;

public class TicTacToe {

	//private TicTacToe t;
	//public enum Mark {XMARK, OMARK, EMPTY}
	private char[][] board = new char[3][3];
	
	public TicTacToe(){
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				board[row][col] = ' ';
			}
		}
	}
	public char getMark(int row, int col){
		return board[row][col];
	}
	
	public void setMark(int row, int col, char mark){
		if (board[row][col] == ' '){
			board[row][col] = mark;
		}
	}

	public static void main(String[] args) {
		
	}
	
	
}
