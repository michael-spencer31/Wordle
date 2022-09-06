import java.util.Scanner;

public class UserIn{

	public String getWord(){

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter your word: ");
		String word = scan.next();

		while(word.length() != 5){

			System.out.println("Invalid word. Please try again: ");
			word = scan.next();
		}
		return word;
	}
}