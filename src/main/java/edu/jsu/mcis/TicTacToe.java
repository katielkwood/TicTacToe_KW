package edu.jsu.mcis;

import java.io.*;
public class TicTacToe {

	//private TicTacToe t;
	//public enum Mark {XMARK, OMARK, EMPTY}
	private char[][] board = new char[3][3];
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
		if (/*gameOver() == false && */board[row][col] == ' '){
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
	/*
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
	}*/
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
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe");
	}
	
	
}
