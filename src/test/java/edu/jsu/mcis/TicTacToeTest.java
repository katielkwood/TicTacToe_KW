package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	//make an object t
	/*@Before 
	public void setUp(){
		TicTacToe t = new TicTacToe;
	}
	*/
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
		assertTrue(false);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		assertTrue(false);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		assertTrue(false);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		assertTrue(false);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		assertTrue(false);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		assertTrue(false);
	}	
}
