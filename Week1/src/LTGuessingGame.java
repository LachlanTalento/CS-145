// Programmer(s): Lachlan Talento
// Date:          4/9/2022
// Course:        CS&145
// Lab:           Guessing Game
//
// This program will do the following: run a game where the program comes up with a random
// number for the user to guess.
//
// For this new rendition of this lab, I made sure there were no bugs in the program;
// whenever the users input is asked there will be no errors, even if their input is not valid.
// I also made sure to add comments when needed, to make the code more readable.

import java.util.*;

public class LTGuessingGame {

    public static void main(String[] Args) {

        Scanner input = new Scanner(System.in);// Initializes Scanner class
        // Initializes variables
        int bestGuess = 9999;
        int numGames = 0;
        int totalGuesses = 0;
        char playAgain = 'y';

        intro();// Displays the intro

        while (playAgain != 'n' && playAgain != 'N') {

            int guesses = game();// Runs the game

            if (guesses < bestGuess) {

                bestGuess = guesses;

            }// End of if statement

            totalGuesses += guesses;
            numGames++;

            System.out.print("Do you want to play again? ");
            String userIn = input.next();
            playAgain = userIn.charAt(0);

            while (playAgain != 'y' && playAgain != 'Y' && playAgain != 'n' && playAgain != 'N') {

                System.out.println("Please type a word beginning with \"n\" or \"y\"");
                System.out.print("Do you want to play again? ");
                userIn = input.next();
                playAgain = userIn.charAt(0);
                System.out.println();

            }// End of while loop

        }// End of While loop

        results(bestGuess, numGames, totalGuesses);

    }// End of main method

    // Displays the introduction
    public static void intro() {// Gives introduction of the game to the user

        System.out.println("""
                This Program allow you to play a Guessing game.
                I will be thinking of a number between 1 and
                100 and will allow you to guess until
                you get it. For each guess, I will tell you
                whether the right answer is higher or lower
                than your guess.
                """);

    }// End of intro method

    // Runs the game
    public static int game() {

        Scanner input = new Scanner(System.in);// Initializes Scanner class
        Random random = new Random();// Initializes Random class

        // Initializing Variables
        int guess = 101;
        int count;
        boolean numberOrNot = false;

        System.out.println("I'm thinking of a number between 1 and 100...");
        int randNum = random.nextInt(100);// Creates a number between 1 and 100
        // System.out.println("Random number: " + randNum);// Prints the random number

        // Starts the game
        for (count = 0; guess != randNum; count++) {

            System.out.print("Your guess? ");
            String userIn = input.next();

            // Makes sure the user is typing an integer
            while (!numberOrNot) {

                try {

                    guess = Integer.parseInt(userIn);// Turns the users input into an integer
                    numberOrNot = true;

                } catch (NumberFormatException ex) {

                    System.out.print("Please type a valid integer: ");
                    userIn = input.next();

                }// End of catch statement

            }// End of while statement

            // Tells the user whether the random number is higher or lower than their guess
            if (guess > randNum) {

                System.out.println("It's lower.");

            }else if (guess < randNum) {

                System.out.println("It's Higher.");

            }// End of else statement

        numberOrNot = false;

        }// End of For loop

        // Makes guess plural if the user had more than one guesses
        if (count == 1) {

            System.out.println("You got it right in " + count + " guess!");

        } else {

            System.out.println("You got it right in " + count + " guesses!");

        }// End of else statement
        System.out.println();

        return count;

    }// End of game method

    // Displays the results
    public static void results(int bestGuess, int numGames, int totalGuesses) {

        System.out.printf("total games   = %d\n" +
                           "total guesses = %d\n" +
                           "guess/game    = " + (double) totalGuesses / (double) numGames + "\n" +
                           "best game     = %d", numGames, totalGuesses, bestGuess);

    }// End of results method

}// End of Class
