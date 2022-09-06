public class ColourPicker{

	public char[] getColour(String wordleIn, String wordIn){

		String wordle = wordleIn;
		String word = wordIn;

		char[] wordleTemp = new char[wordle.length()];
		char[] wordTemp = new char[wordle.length()];

		for(int i = 0; i < wordle.length(); i++){

			wordleTemp[i] = wordle.charAt(i);
			wordTemp[i] = word.charAt(i);
		}
		//check if correct letter and correct space
		for(int i = 0; i < wordle.length(); i++){

			if(wordTemp[i] != '_' && wordleTemp[i] == wordTemp[i]){

				wordleTemp[i] = '_';
				//System.out.println("True - green");
				//set something green here
			}
		}
		//check if correct letter and incorrect space
		for(int i = 0; i < wordle.length(); i++){

			if(wordTemp[i] != '_' && yellow(wordTemp, wordleTemp, wordle, i)){

				//System.out.println("True - yellow");
				//set something yellow here
			}
		}
		//check if incorrect letter and incorrect space
		for(int i = 0; i < wordle.length(); i++){

			char c = word.charAt(i);

			if(wordle.indexOf(c) == -1){

				//System.out.println("True - gray");
				//set something gray here
			}
		}
		return wordleTemp;
	}
	//helper function to determine the "yellow" characters
	private static boolean yellow(char[] rowTemp, char[] wordleTemp, String wordle, int i){

		char c = rowTemp[i];

		if(c == '_'){
			return false;
		}
		for(int j = 0; j < wordle.length(); j++){

			if(i != j && c == wordleTemp[j]){

				wordleTemp[i] = '!';
				return true;
			}
		}
		return false;
	}
}