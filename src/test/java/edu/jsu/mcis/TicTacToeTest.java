package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;

public class TicTacToeTest {


	
	@Test
	public void testInitialBoardIsEmpty() {
		TicTacToePanel t = new TicTacToePanel();
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				assertEquals(" ", t.getMark(row,col));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToePanel t = new TicTacToePanel();
		t.setMark(0, 2);
		assertEquals("X", t.getMark(0, 2)); 
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToePanel t = new TicTacToePanel();
		t.setMark(0, 0);
		t.setMark(2, 0);
		assertEquals("O", t.getMark(2, 0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		TicTacToePanel t = new TicTacToePanel();
		Random randInt = new Random();
		int row = randInt.nextInt(3);
		int col = randInt.nextInt(3);
		t.setMark(row, col);
		t.setMark(row, col);
		assertEquals("X", t.getMark(row, col));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToePanel t = new TicTacToePanel();
		Random randInt = new Random();
		int row = randInt.nextInt(3);
		int col = randInt.nextInt(3);
		t.setMark(row, col);
		assertEquals(TicTacToePanel.GameResult.STILLPLAYING, t.getGameResult());
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToePanel t = new TicTacToePanel();
		t.setMark(0, 0); //X
		t.setMark(1, 1); //O
		t.setMark(0, 1); //X
		t.setMark(1, 0); //O
		t.setMark(0, 2); //x
		assertEquals(TicTacToePanel.GameResult.XWIN, t.getGameResult());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToePanel t = new TicTacToePanel();
		t.setMark(0, 0);
		t.setMark(0, 1);
		t.setMark(0, 2);
		t.setMark(1, 0); 
		t.setMark(1, 1);
		t.setMark(2, 0);
		t.setMark(2, 1);
		t.setMark(2, 2);
		t.setMark(1, 2);
		assertEquals(TicTacToePanel.GameResult.TIE, t.getGameResult());
	}
	
	@Test
	public void testLabelUpdatesAfterFirstMove(){
		TicTacToePanel t = new TicTacToePanel();
		t.setMark(0, 0);
		assertEquals("Player 0, place your mark.", t.label.getText());
	}	
}
