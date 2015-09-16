import edu.jsu.mcis.*;

public class TicTacToeKeywords {

	private TicTacToePanel t;
	
	public void startNewGame() {
		t = new TicTacToePanel();
	}
	
	public void markLocation(int row, int col) {
		t.setMark(row, col);
	}
	
	public char getMark(int row, int col) {
		return t.getMark(row, col);
	}

public String getWinner() {
	String result = t.getGameResult();
		if (result == "Player X wins"){
			return "X";
		}
		else if (result == "Player O wins"){
			return "O";
		}
		else if (result == "TIE"){
			return "TIE";
		}
		else{return "";}
	}
}