package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
public class TicTacToeGame {

	public static void main(String[] args) {
	
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TicTacToePanel panel = new TicTacToePanel();
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
}
