import java.util.Arrays;
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
    public HangmanGame() {
        word = Words[random.nextInt(Words.length)];
        wordArray = word.toCharArray();
        displayArray = new char[word.length()];
        wrongGuesses = 0;
        gameWon = false;

        for (int i = 0; i < word.length(); i++) {
            displayArray[i] = '_';
        }
    }
    public void play() {
        while (wrongGuesses < HANGMAN_PICS.length - 1 && !gameWon) {

            System.out.println(HANGMAN_PICS[wrongGuesses]);
            System.out.println("Mot actuel: " + new String(displayArray));
            System.out.print("Entrez une lettre: ");
            char guess = scanner.nextLine().charAt(0);

            boolean guessCorrect = false;
            for (int i = 0; i < wordArray.length; i++) {
                if (wordArray[i] == guess) {
                    displayArray[i] = guess;
                    guessCorrect = true;
                }
            }

            if (!guessCorrect) {
                wrongGuesses++;
            }

            if (new String(displayArray).equals(word)) {
                gameWon = true;
            }
        }

        if (gameWon) {
            System.out.println("Félicitations! Vous avez deviné le mot: " + word);
        } else {
            System.out.println(HANGMAN_PICS[HANGMAN_PICS.length - 1]);
            System.out.println("Jeu terminé! Le mot était: " + word);
        }

        scanner.close();
    }



}
