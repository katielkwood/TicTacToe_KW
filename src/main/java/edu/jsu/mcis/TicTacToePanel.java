package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToePanel extends JPanel{

	public enum Mark {XMARK, OMARK, EMPTY};
	public enum GameResult {XWIN, OWIN, TIE, STILLPLAYING};
	private Mark[][] board = new Mark[3][3];
	private int moveCounter;
	private JButton Location00;
	private JButton Location01;
	private JButton Location02;
	private JButton Location10;
	private JButton Location11;
	private JButton Location12;
	private JButton Location20;
	private JButton Location21;
	private JButton Location22;
	protected JLabel label;
	private JPanel buttonPanel;
	
	private void TicTacToe(){
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				board[row][col] = Mark.EMPTY;
			}
		}
		moveCounter = 0;
	}
	public String getMark(int row, int col){
		if (board[row][col] == Mark.XMARK){
			return "X";
		}
		else if (board[row][col] == Mark.OMARK){
			return "O";
		}
		else if (board[row][col] == Mark.EMPTY){
			return " ";
		}
		else return "";
	}
	
	public void setMark(int row, int col){
		if (board[row][col] == Mark.EMPTY){
			if(moveCounter == 0){
				board[row][col] = Mark.XMARK;
				moveCounter++;
			}
			else {
				board[row][col] = Mark.OMARK;
				moveCounter--;	
			}
		}
		GameResult result = getGameResult();
		updateLabel(result);
	}
	
	
	private boolean gameWon(){
		boolean result = false;
		for (int row = 0; row < 3; row++){
			if (getMark(row, 0) == getMark(row, 1) && getMark(row, 1) == getMark(row, 2) &&
				getMark(row, 0) != " "){
				result = true;
			}
		}
		for (int col = 0; col < 3; col++){
			if (getMark(0, col) == getMark(1, col) && getMark(1, col) == getMark(2, col) &&
				getMark(0, col) != " "){
				result = true;
			}
		}
		if (getMark(0, 0) == getMark(1, 1) && getMark(1, 1) == getMark(2, 2) && 
			getMark(0, 0) != " "){
			result = true;
		}
		else if (getMark(2, 0) == getMark(1, 1) && getMark(1, 1) == getMark(0, 2) &&
					getMark(2, 0) != " "){
			result = true;
		}
		return result;
	}
	
	private boolean tieGame(){
		boolean result = true;
		if (gameWon() == false){
			for (int row = 0; row < 3; row++){
				for (int col = 0; col < 3; col++){
					if (board[row][col] == Mark.EMPTY){
						result = false;
					}
				}
			}
		}
		return result;
	}
	
	private boolean gameOver(){
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
	
	public GameResult getGameResult(){
		GameResult result = GameResult.STILLPLAYING;
		if (gameOver() == true){
			if (gameWon() == true){
				if (moveCounter == 1){
					result = GameResult.XWIN;
				}
				else {result = GameResult.OWIN;}
			}
			else if(tieGame() == true){result = GameResult.TIE;}
			else{}
		}
		else {result = GameResult.STILLPLAYING;}
		
		return result;
	}
	
	private void updateLabel(GameResult result){
		if(result == GameResult.STILLPLAYING){
			if(moveCounter == 0){
				label.setText("Player X, place your mark.");
			}
			else{
				label.setText("Player 0, place your mark.");
			}
		}
		/*else if(result == GameResult.XWIN){
			label.setText("Player X wins!");
		}
		else if(result == GameResult.OWIN){
			label.setText("Player O wins!");
		} 
		else if(result == GameResult.TIE){
			label.setText("TIE");
		}
		else{
			label.setText("Error");
		}*/
	}
	private String dialogMessage(GameResult result){
		String message = "";
		if (result == GameResult.XWIN){
			message = "The winner is X";
		}
		else if (result == GameResult.OWIN){
			message = "The winner is O";
		} 
		else if (result == GameResult.TIE){
			message = "The winner is TIE";
		}
		else{
			message = "Error";
		}
		return message;
	}	
	
	public TicTacToePanel(){
		TicTacToe();
		
		Location00 = new JButton(getMark(0, 0));
		Location01 = new JButton(getMark(0, 1));
		Location02 = new JButton(getMark(0, 2));
		Location10 = new JButton(getMark(1, 0));
		Location11 = new JButton(getMark(1, 1));
		Location12 = new JButton(getMark(1, 2));
		Location20 = new JButton(getMark(2, 0));
		Location21 = new JButton(getMark(2, 1));
		Location22 = new JButton(getMark(2, 2));
			
		ButtonListener listener = new ButtonListener();
		Location00.addActionListener(listener);
		Location01.addActionListener(listener);
		Location02.addActionListener(listener);
		Location10.addActionListener(listener);
		Location11.addActionListener(listener);
		Location12.addActionListener(listener);
		Location20.addActionListener(listener);
		Location21.addActionListener(listener);
		Location22.addActionListener(listener);
			
		label = new JLabel("Player X, place your mark.");
			
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setPreferredSize(new Dimension(400, 400));
		buttonPanel.setBackground(Color.pink);
		buttonPanel.add(Location00);
		buttonPanel.add(Location01);
		buttonPanel.add(Location02);
		buttonPanel.add(Location10);
		buttonPanel.add(Location11);
		buttonPanel.add(Location12);
		buttonPanel.add(Location20);
		buttonPanel.add(Location21);
		buttonPanel.add(Location22);
			
		setPreferredSize(new Dimension(400, 450));
		setBackground(Color.white);
		add(label);
		add(buttonPanel);
	}
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(gameOver() == false){
				GameResult result;
				if (event.getSource() == Location00){
					setMark(0, 0);
					Location00.setText(getMark(0, 0));
					result = getGameResult();
					if (result == GameResult.STILLPLAYING){
						//updateLabel(result);
					}
					else {
						JOptionPane.showMessageDialog(buttonPanel, dialogMessage(result));
					}
				}
				else if (event.getSource() == Location01){
					setMark(0, 1);
					Location01.setText(getMark(0, 1));
					result = getGameResult();
					if (result == GameResult.STILLPLAYING){
						updateLabel(result);
					}
					else {
						JOptionPane.showMessageDialog(buttonPanel, dialogMessage(result));
					}
				}
				else if (event.getSource() == Location02){
					setMark(0, 2);
					Location02.setText(getMark(0, 2));
					result = getGameResult();
					if (result == GameResult.STILLPLAYING){
						updateLabel(result);
					}
					else {
						JOptionPane.showMessageDialog(buttonPanel, dialogMessage(result));
					}
				}
				else if (event.getSource() == Location10){
					setMark(1, 0);
					Location10.setText(getMark(1, 0));
					result = getGameResult();
					if (result == GameResult.STILLPLAYING){
						updateLabel(result);
					}
					else {
						JOptionPane.showMessageDialog(buttonPanel, dialogMessage(result));
					}
				}
				else if (event.getSource() == Location11){
					setMark(1, 1);
					Location11.setText(getMark(1, 1));
					result = getGameResult();
					if (result == GameResult.STILLPLAYING){
						updateLabel(result);
					}
					else {
						JOptionPane.showMessageDialog(buttonPanel, dialogMessage(result));
					}
				}
				else if (event.getSource() == Location12){
					setMark(1, 2);
					Location12.setText(getMark(1, 2));
					result = getGameResult();
					if (result == GameResult.STILLPLAYING){
						updateLabel(result);
					}
					else {
						JOptionPane.showMessageDialog(buttonPanel, dialogMessage(result));
					}
				}
				else if (event.getSource() == Location20){
					setMark(2, 0);
					Location20.setText(getMark(2, 0));
					result = getGameResult();
					if (result == GameResult.STILLPLAYING){
						updateLabel(result);
					}
					else {
						JOptionPane.showMessageDialog(buttonPanel, dialogMessage(result));
					}
				}
				else if (event.getSource() == Location21){
					setMark(2, 1);
					Location21.setText(getMark(2, 1));
					result = getGameResult();
					if (result == GameResult.STILLPLAYING){
						updateLabel(result);
					}
					else {
						JOptionPane.showMessageDialog(buttonPanel, dialogMessage(result));
					}
				}
				else{
					setMark(2,2);
					Location22.setText(getMark(2, 2));
					result = getGameResult();
					if (result == GameResult.STILLPLAYING){
						updateLabel(result);
					}
					else {
						JOptionPane.showMessageDialog(buttonPanel, dialogMessage(result));
					}
				}
			}
		}
	}
}