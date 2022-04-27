// Programmer: Lachlan Talento
// Date:	   4/26/2022
// Course:     CS&145
// Lab:        Card Game
//
// This program will do the following: 

package myProject;

import java.util.*;

public class LTCardGameWar {
	private static final int NUMBER_OF_CARDS = 52;

	public static void main(String[] args) throws IndexOutOfBoundsException {
		// Display instructions
		instructions();
		// Display menu
		// Start the game
		playGame();
		// Ask if the User Wants to play again
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
	
	public static int menu() {
		return 0;
	} // End of menu method
	
	public static void playGame() {
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // Place Cards in a random order
		
		LinkedList<Card> playerOneDeck = new LinkedList<Card>();
		LinkedList<Card> playerTwoDeck = new LinkedList<Card>();
		String playerOneTopCard = "" + playerOneDeck.get(0);
		String playerTwoTopCard = "" + playerTwoDeck.get(0);
		int playerOneTopCardFace;
		int playerTwoTopCardFace;
		
		for (int count = 0; count <= NUMBER_OF_CARDS; count++) {
			if (count % 2 == 0) {
				playerTwoDeck.add(myDeckOfCards.dealCard());
			} else {
				playerOneDeck.add(myDeckOfCards.dealCard());
			} // End of if/else statement
		} // End of for loop
		System.out.println(playerOneTopCard);
		System.out.println(playerTwoTopCard);
		
		playerOneTopCardFace = getValue(playerOneTopCard);
		playerTwoTopCardFace = getValue(playerTwoTopCard);
		
		if (playerOneTopCardFace > playerTwoTopCardFace) {
			System.out.println("Player One Wins!");
		} else if (playerOneTopCardFace < playerTwoTopCardFace) {
			System.out.println("Player Two Wins!");
		} else {
			System.out.println("Initiating War");
		}
		
	} // End of playGame method
	
	public static void war() {
		
	} // End of war method
	
	public static int getValue(String playerTopCard) throws IndexOutOfBoundsException {
		int value;
		
		String[] words = playerTopCard.split(" ");
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
} // End of LTCardGameWar


