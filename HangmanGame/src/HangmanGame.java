import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class HangmanGame {

    private static final String[] HANGMAN_PICS = {
            "+---+\n    |\n    |\n    |\n   ===",
            "+---+\n O   |\n    |\n    |\n   ===",
            "+---+\n O   |\n |   |\n    |\n   ===",
            "+---+\n O   |\n/|   |\n    |\n   ===",
            "+---+\n O   |\n/|\\  |\n    |\n   ===",
            "+---+\n O   |\n/|\\  |\n/    |\n   ===",
            "+---+\n O   |\n/|\\  |\n/ \\  |\n   ==="
    };
    private static final String[] Words={"Java", "Computer", "Science", "Programming"};
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private char[] wordArray;
    private char[] displayArray;
    private String word;
    private boolean gameWon;
    private int wrongGuesses;
    public HangmanGame(){
        word = Words[random.nextInt(Words.length)];
        wordArray = word.toCharArray();
        displayArray = new char[word.length()];
        wrongGuesses = 0;
        gameWon = false;

        for (int i = 0; i < word.length(); i++) {
            displayArray[i] = '_';
        }

        while(wrongGuesses < HANGMAN_PICS.length - 1 && !gameWon){

            }



    }


}
