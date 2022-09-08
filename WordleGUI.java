import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class WordleGUI extends JFrame implements ActionListener{

    private static JPanel panel;
    private static JFrame frame;

    private static JLabel Title;
    private static JLabel stats;
    private static JTextField userText1;
    private static JLabel[] labels;

    public Scanner scan = new Scanner(System.in);

    public String[] possibleWords;
    static int tries;
    static char[] input;
    static long startTime;
    static char[] answer;
    static boolean done;
    static String answerChosen;

    public static String wordle;

    private static final ColourPicker[] rows = new ColourPicker[6];

    public static void main(String[] args){

        WordleGenerator generator = new WordleGenerator();

        wordle = generator.getWordle();

        tries = 0;

        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(220, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Wordle");
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        stats = new JLabel("Type a five letter word: ");
        stats.setBounds(10, 50, 180, 25);
        panel.add(stats);

        userText1 = new JTextField();
        userText1.addActionListener(new WordleGUI());
        userText1.setBounds(40, 80 + (0 * 25), 80, 25);
        panel.add(userText1);

        JButton button = new JButton("Enter");
        button.setBounds(100, 20, 80, 25);
        button.addActionListener(new WordleGUI());
        panel.add(button);

        labels = new JLabel[6];
        for(int i = 0; i < 6; i++){
            labels[i] = new JLabel("<html><font size='5' color=blue> ----- </font> <font");
            labels[i].setBounds(44, 80 + (i * 25), 80, 25);
            panel.add(labels[i]);
        }
        frame.setVisible(true);
        StartWordle();
    }
    /**
     * this function is called either when the user guesses the word 
     * correctly or runs out of tries. Displays the result of game.
    */
    public static void gameOver(){

        userText1.setEnabled(false);
        userText1.setVisible(false);

        if(done){

            stats.setText("You got it in " + tries + " guesses!");
        }else{
            stats.setText("You lost! The wordle was: " + wordle);
        }
    }
    /**
     * this function listens for a button press on the gui
    */
    @Override
    public void actionPerformed(ActionEvent e){

        CheckWord();
    }
    //start the game by setting the number of tries to 0
    public static void StartWordle(){

        tries = 0;
    }
    public static void CheckWord(){

        //reset the text and box colour each time the function runs
        stats.setText("Type a five letter word: ");
        userText1.setForeground(Color.BLACK);

        //get a word from the user text box and then create an 
        //InputValidator to check if the word is real
        String word = userText1.getText();
        InputValidator check = new InputValidator();

        //if the word is valid, we can start the logic of the game
        if(check.ValidWord(word)){
            ButtonPressed();
        }else{
            userText1.setForeground(Color.RED);
            stats.setText("Invalid word - please try again");
        }
    }
    public static void ButtonPressed(){

        userText1.setBounds(40, 80 + ((tries + 1) * 25), 80, 25);
        String userInput = userText1.getText();
        tries++;

        System.out.println(wordle);

        Letter[] cells = new Letter[wordle.length()];

        rows[0] = new ColourPicker(wordle);
        cells = rows[0].getColour(wordle, userInput);

        done = true;

        //if the user guesses correctly end the game
        if(!wordle.equals(userInput)){
            done = false;
        }

        if(done || tries > 5){
            gameOver();
        }
        //creates a string using the state of each 'cell' 
        //(i.e. the colour) and set the colour of each letter in word
        String finalString = (
        "<html><font size='5' color=" + cells[0].getState() + "> " + userInput.charAt(0) + "</font> <font            " + 
        "<html><font size='5' color=" + cells[1].getState() + "> " + userInput.charAt(1) + "</font> <font            " + 
        "<html><font size='5' color=" + cells[2].getState() + "> " + userInput.charAt(2) + "</font> <font            " + 
        "<html><font size='5' color=" + cells[3].getState() + "> " + userInput.charAt(3) + "</font> <font            " + 
        "<html><font size='5' color=" + cells[4].getState() + "> " + userInput.charAt(4) + "</font> <font            ");
        setNextLabel(finalString);

        userText1.setText("");
    }
    public static void setNextLabel(String string){
        labels[tries - 1].setText(string);
    }
}