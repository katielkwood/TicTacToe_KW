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
	
	public boolean gameWonByX(){
		boolean result = false;
		for (int row = 0; row < 3; row++){
			if (getMark(row, 0) == getMark(row, 1) && getMark(row, 1) == getMark(row, 2) && 
				getMark(row, 0) == 'X'){
				result = true;
			}
		}
		for (int col = 0; col < 3; col++){
			if (getMark(0, col) == getMark(1, col) && getMark(1, col) == getMark(2, col) &&
				getMark(0, col) == 'X'){
				result = true;
			}
		}
		if (getMark(0, 0) == getMark(1, 1) && getMark(1, 1) == getMark(2, 2) && 
			getMark(0, 0) == 'X'){
			result = true;
		}
		else if (getMark(2, 0) == getMark(1, 1) && getMark(1, 1) == getMark(0, 2) &&
					getMark(2, 0) == 'X'){
			result = true;
		}
		return result;
	}
	
	public boolean gameWonByO(){
		boolean result = false;
		for (int row = 0; row < 3; row++){
			if (getMark(row, 0) == getMark(row, 1) && getMark(row, 1) == getMark(row, 2) && 
				getMark(row, 0) == 'O'){
				result = true;
			}
		}
		for (int col = 0; col < 3; col++){
			if (getMark(0, col) == getMark(1, col) && getMark(1, col) == getMark(2, col) &&
				getMark(0, col) == 'O'){
				result = true;
			}
		}
		if (getMark(0, 0) == getMark(1, 1) && getMark(1, 1) == getMark(2, 2) && 
			getMark(0, 0) == 'O'){
			result = true;
		}
		else if (getMark(2, 0) == getMark(1, 1) && getMark(1, 1) == getMark(0, 2) &&
					getMark(2, 0) == 'O'){
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
		if (gameWonByX() == true){
			result = true;
		}
		else if (gameWonByO() == true){
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

	public static void main(String[] args) {
		
	}
	
	
}
