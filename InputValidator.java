import java.util.Scanner;
import java.io.*;

public class InputValidator{

	public boolean ValidWord(String word){

		if(word.length() != 5){
			System.out.println("Not a valid word");
			return false;
		}
		try{
			File file = new File("wordleWords.txt");

			return (new Scanner(file).useDelimiter("\\Z").next()).contains(word);
		}catch(FileNotFoundException e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		return true;
	}
}
