import java.awt.*;

public class ColourPicker{

	private final Letter[] cells;

	public ColourPicker(String cellValues){

		cells = new Letter[5];
		for(int i = 0; i < 5; i++){
			cells[i] = new Letter(cellValues.charAt(i));
		}
	}
	public Letter[] getColour(String wordleIn, String wordIn){

		String wordle = wordleIn;
		String word = wordIn;

		char[] wordleTemp = new char[wordle.length()];
		char[] wordTemp = new char[wordle.length()];

		for(int i = 0; i < wordle.length(); i++){

			wordleTemp[i] = wordle.charAt(i);
			wordTemp[i] = word.charAt(i);
		}
		//check if correct letter and correct space (green spaces)
		for(int i = 0; i < wordle.length(); i++){

			Letter cell = cells[i];

			if(wordTemp[i] != '_' && wordleTemp[i] == wordTemp[i]){

				wordleTemp[i] = '_';
				cell.setState(State.GREEN);
			}
		}
		//check if correct letter and incorrect space (yellow spaces)
		for(int i = 0; i < wordle.length(); i++){

			Letter cell = cells[i];

			if(cell.getState() != State.GREEN && wordTemp[i] != '_' && yellow(wordTemp, wordleTemp, wordle, i)){

				cell.setState(State.ORANGE);
			}
		}
		//check if incorrect letter and incorrect space (gray spaces)
		for(int i = 0; i < wordle.length(); i++){

			Letter cell = cells[i];

			if(cell.getState() == null){
				cell.setState(State.GRAY);
			}
		}
		return cells;
	}
	//helper function to determine the "yellow" characters
	private static boolean yellow(char[] rowTemp, char[] wordleTemp, String wordle, int i){

		char c = rowTemp[i];

		if(c == '_'){
			return false;
		}
		for(int j = 0; j < wordle.length(); j++){

			if(i != j && c == wordleTemp[j]){

				wordleTemp[j] = '_';
				return true;
			}
		}
		return false;
	}
}
