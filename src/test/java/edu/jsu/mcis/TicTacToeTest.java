package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;

public class TicTacToeTest {

	//private TicTacToe t;
	//public enum Mark {XMARK, OMARK, EMPTY};
	
	/*@Before 
	public void setUp(){
		TicTacToe t = new TicTacToe();
	}*/
	
	@Test
	public void testInitialBoardIsEmpty() {
		TicTacToe t = new TicTacToe();
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				assertEquals(' ', t.getMark(row,col));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToe t = new TicTacToe();
		t.setMark(0, 2, 'X');
		assertEquals('X', t.getMark(0, 2)); 
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToe t = new TicTacToe();
		t.setMark(2, 0, 'O');
		assertEquals('O', t.getMark(2, 0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		TicTacToe t = new TicTacToe();
		Random randInt = new Random();
		int row = randInt.nextInt(3);
		int col = randInt.nextInt(3);
		t.setMark(row, col, 'O');
		t.setMark(row, col, 'X');
		assertEquals('O', t.getMark(row, col));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToe t = new TicTacToe();
		Random randInt = new Random();
		int row = randInt.nextInt(3);
		int col = randInt.nextInt(3);
		t.setMark(row, col, 'X');
		assertEquals(false, t.gameOver());
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToe t = new TicTacToe();
		t.setMark(0, 0, 'X');
		t.setMark(0, 1, 'X');
		t.setMark(0, 2, 'X');
		assertEquals(true, t.gameWonByX());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToe t = new TicTacToe();
		t.setMark(0, 0, 'X'); t.setMark(0, 1, 'O'); t.setMark(0, 2, 'X');
		t.setMark(1, 0, 'X'); t.setMark(1, 1, 'O'); t.setMark(1, 2, 'X');
		t.setMark(2, 0, 'O'); t.setMark(2, 1, 'X'); t.setMark(2, 2, 'O');
		assertEquals(true, t.tieGame());
	}	
}
