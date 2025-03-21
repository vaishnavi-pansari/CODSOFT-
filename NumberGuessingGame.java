package CodeSoft;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            roundsPlayed++;
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int maxAttempts = selectDifficulty(scanner);

            System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (guess < lowerBound || guess > upperBound) {
                    System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += Math.max(0, maxAttempts - attempts);
                    break;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game Over! You played " + roundsPlayed + " rounds with a total score of " + score + ".");
        scanner.close();
    }

    private static int selectDifficulty(Scanner scanner) {
        System.out.println("Select difficulty level:");
        System.out.println("1. Easy (15 attempts)");
        System.out.println("2. Medium (10 attempts)");
        System.out.println("3. Hard (5 attempts)");

        while (true) {
            System.out.print("Enter your choice (1/2/3): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": return 15;
                case "2": return 10;
                case "3": return 5;
                default: System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
    }
}
