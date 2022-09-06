import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordleGenerator{

	public String getWordle(){

		try{

			Scanner scan = new Scanner(new File("wordles.txt"));

			int size = 2089;
			int r = (int)(Math.random() * size);
			int i = 0;

			while((i++) < r)
				scan.nextLine();

			String word = scan.nextLine();
			scan.close();

			return word;
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
}