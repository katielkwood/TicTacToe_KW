import edu.jsu.mcis.*;

public class TicTacToeKeywords {

	private TicTacToe t;
	
	public void startNewGame() {
		t = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		t.setMark(row, col);
	}
	
	public char getMark(int row, int col) {
		return t.getMark(row, col);
		//return m;
	}
    
	public String getWinner() {
		return t.getWinner();
	}
}
