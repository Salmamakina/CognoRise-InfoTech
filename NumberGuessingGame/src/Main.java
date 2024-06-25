import java.util.Random ;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random randomData = new Random();
        int randomNumber = randomData.nextInt(1, 100 + 1);
        Scanner scanner = new Scanner(System.in);
        boolean guessedCorrectly = false;
        int attempts = 0;
        int maxAttempts = 10;
        while (!guessedCorrectly && attempts < maxAttempts) {
            System.out.println("Enter you guess:");
            int guessedNumber = scanner.nextInt();
            attempts++;
            if (guessedNumber < randomNumber) {
                System.out.println("Too Low !");
            }
            else if (guessedNumber > randomNumber) {
                System.out.println("Too High !");
            }
            else {
                System.out.println("Congratulations !");
                guessedCorrectly = true;
            }
        }
        if (!guessedCorrectly){
            System.out.println("Sorry you passed the attempts !");
        }
    }
}