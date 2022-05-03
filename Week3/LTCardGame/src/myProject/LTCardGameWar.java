// Programmer: Lachlan Talento
// Date:	   4/26/2022
// Course:     CS&145
// Lab:        Card Game
//
// This program will do the following: run a two player Card game called War.

package myProject;

import java.util.*;

public class LTCardGameWar {
	private final static int NUMBER_OF_CARDS = 52;

	public static void main(String[] args) throws IndexOutOfBoundsException {
		Scanner input = new Scanner(System.in);
		// Display instructions
		instructions();
		// Start the game
		int roundCount = playGame(input);
		// Display the game results
		results(roundCount);
	} // End of main method
	
	// Display the instructions
	public static void instructions() {
		System.out.println("This is the game of War!\n");
		System.out.println("War is a two player game, where the deck is divided evenly");
		System.out.println("between the two players (26 cards each).");
		System.out.println("Each player takes the top card from their deck and compares");
		System.out.println("their card to their opponent's card. The person who's card");
		System.out.println("has a higher rank, takes both cards that were played. If");
		System.out.println("both players have equal ranks, it is War! During a War,");
		System.out.println("both player take their top five cards and compare only");
		System.out.println("the last card drawn, with winner taking all cards that");
		System.out.println("were played. This can continue if both players keep");
		System.out.println("getting equal ranked cards. This game ends when one player");
		System.out.println("has no more cards to play, with them as the loser.\n");
	} // End of instructions method
	
	// Starts the Game
	public static int playGame(Scanner input) {
		// Initializing DeckOfCards
		DeckOfCards myDeckOfCards = new DeckOfCards();
		// Creates two separate decks for both players
		LinkedList<Card> playerOneDeck = new LinkedList<Card>();
		LinkedList<Card> playerTwoDeck = new LinkedList<Card>();
		// Initializing variables
		final int currentCard = 0;
		final int warCard = currentCard + 4;
		int playerOneTopCardFace;
		int playerTwoTopCardFace;
		String playerOneTopCard;
		String playerTwoTopCard;
		int playerOneDeckSize = playerOneDeck.size();;
		int playerTwoDeckSize = playerTwoDeck.size();;
		boolean isEqual = true;
		String in;
		int roundCount = 0;
		
		myDeckOfCards.shuffle(); // Place Cards in a random order
		
		// Separates the deck into two separate decks for both players
		for (int count = 0; count <= NUMBER_OF_CARDS - 1; count++) {
			if (count % 2 == 0) {
				playerTwoDeck.add(myDeckOfCards.dealCard());
			} else {
				playerOneDeck.add(myDeckOfCards.dealCard());
			} // End of if/else statement
		} // End of for loop
		
		// Begins the Game
		do {
		System.out.println("Player One Drew a " + playerOneDeck.get(currentCard));
		System.out.println("Player Two Drew a " + playerTwoDeck.get(currentCard));
		
		playerOneTopCard = "" + playerOneDeck.get(currentCard);
		playerTwoTopCard = "" + playerTwoDeck.get(currentCard);
		// System.out.println(playerOneTopCard);
		playerOneTopCardFace = getValue(playerOneTopCard); // Gets the face value for player One
		playerTwoTopCardFace = getValue(playerTwoTopCard); // Gets the face value for player Two
		System.out.println();
		
		if (playerOneTopCardFace > playerTwoTopCardFace) { // If Player One Wins
			// Adds player Two's Card to player One
			playerOneDeck.add(playerTwoDeck.get(currentCard));
			// Removes that Card from player Two's deck
			playerTwoDeck.remove(playerTwoDeck.get(currentCard));
			playerOneDeckSize = playerOneDeck.size();
			playerTwoDeckSize = playerTwoDeck.size();
			System.out.printf("Player One Wins a card +1 (%d)%n", playerOneDeckSize);
			System.out.printf("Player Two Loses a card +1 (%d)%n" , playerTwoDeckSize);
		} else if (playerOneTopCardFace < playerTwoTopCardFace) { // If Player Two Wins
			// Adds player One's Card to player Two
			playerTwoDeck.add(playerOneDeck.get(currentCard));
			// Removes that Card from player One's deck
			playerOneDeck.remove(playerOneDeck.get(currentCard));
			playerTwoDeckSize = playerTwoDeck.size();
			playerOneDeckSize = playerOneDeck.size();
			System.out.printf("Player One Loses a Card -1 (%d)%n", playerOneDeckSize);
			System.out.printf("Player Two Wins a Card +1 (%d)%n" , playerTwoDeckSize);
		} else { // If both players have equal value Cards
			isEqual = true;
			
			while (isEqual == true) { 
				System.out.println("I Declare WAR!\n");
				System.out.println("Player One Drew a " + playerOneDeck.get(warCard));
				System.out.println("Player Two Drew a " + playerTwoDeck.get(warCard));
				
				playerOneTopCard = "" + playerOneDeck.get(warCard);
				playerTwoTopCard = "" + playerTwoDeck.get(warCard);
				playerOneTopCardFace = getValue(playerOneTopCard);
				playerTwoTopCardFace = getValue(playerTwoTopCard);
				System.out.println();
				if (playerOneDeckSize >= 4) {
					if (playerOneTopCardFace > playerTwoTopCardFace) { // If Player One Wins
						for (int i = 0; i <= 4; i++) { // Removes and Adds 4 Cards
							playerOneDeck.add(playerTwoDeck.get(currentCard + i));
							playerTwoDeck.remove(playerTwoDeck.get(currentCard + i));
						} // End of for loop
						playerOneDeckSize = playerOneDeck.size();
						playerTwoDeckSize = playerTwoDeck.size();
						System.out.printf("Player One Wins Four Cards +1 (%d)%n", 
								playerOneDeckSize);
						System.out.printf("Player Two Loses Four Cards +1 (%d)%n" ,
								playerTwoDeckSize);
						isEqual = false;
					} else if (playerOneTopCardFace < playerTwoTopCardFace) { // If Player Two Wins
						for (int i = 0; i <= 4; i++) { // Removes and adds 4 Cards
							playerTwoDeck.add(playerOneDeck.get(currentCard + i));
							playerOneDeck.remove(playerOneDeck.get(currentCard + i));
						} // End of for loop
						playerTwoDeckSize = playerTwoDeck.size();
						playerOneDeckSize = playerOneDeck.size();
						System.out.printf("Player One Loses Four Cards -4 (%d)%n",
								playerOneDeckSize);
						System.out.printf("Player Two Wins Four Cards +4 (%d)%n" ,
								playerTwoDeckSize);
						isEqual = false;
					} else {} // End of if/else statement
				} else {
					playerOneDeckSize = 0; // Stops the Game
				}// End of if/else statement
			} // End of while loop
		} // End of if/else statement
		System.out.println("\nType in Anything to Continue"); // Adds a break between each round
		in = input.next();
		roundCount++;
		} while (playerOneDeckSize != 0 && playerTwoDeckSize != 0);
		return roundCount;
	} // End of playGame method
	
	// Gets the value for each Card
	public static int getValue(String playerOneTopCard) {
		int value;
		
		String[] words = playerOneTopCard.split(" ");
		String faces = words[0];
		
		switch (faces) {
			case "Ace": 
				value = 1;
				break;
			case "Two":
				value = 2;
				break;
			case "Three":
				value = 3;
				break;
			case "Four":
				value = 4;
				break;
			case "Five":
				value = 5;
				break;
			case "Six":
				value = 6;
				break;
			case "Seven":
				value = 7;
				break;
			case "Eight":
				value = 8;
				break;
			case "Nine":
				value = 9;
				break;
			case "Ten":
				value = 10;
				break;
			case "Jack":
				value = 11;
				break;
			case "Queen":
				value = 12;
				break;
			default:
				value = 13;
				break;
		} // End of switch/case statement
		return value;
	} // End of getValue method
	
	// Displays the game results
	public static void results(int roundCount) {
		System.out.printf("You Played %d Rounds This Game\n\n", roundCount);
		System.out.println("Thank You for Playing!");
	} // End of results method
} // End of LTCardGameWar