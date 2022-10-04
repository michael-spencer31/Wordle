import java.util.Scanner;
import java.io.*;

public class InputValidator{

	//this function checks if the word the user enters is a valid "wordle" word 
	public boolean ValidWord(String word){

		//if the word is not long enough return false
		if(word.length() != 5){
			System.out.println("Not a valid word");
			return false;
		}
		try{
			//open the file that contains valid words
			File file = new File("wordleWords.txt");

			//check if the word the user enters is found in the file and return
			return (new Scanner(file).useDelimiter("\\Z").next()).contains(word);
		}catch(FileNotFoundException e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		return true;
	}
}
