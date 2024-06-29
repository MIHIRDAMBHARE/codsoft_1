import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("I'm thinking of a number between 1 and 100. You have 10 attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                    totalScore += maxAttempts - attempts + 1; // Score based on attempts left
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

            if (!playAgain) {
                System.out.println("Your total score is: " + totalScore);
                System.out.println("Thank you for playing!");
            }
        }

        scanner.close();
    }
}

