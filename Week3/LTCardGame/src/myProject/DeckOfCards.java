// Programmer: Lachlan Talento
// Date:	   4/26/2022
// Course:     CS&145
// Lab:        Card Game
//
// This class will do the following: 

package myProject;

import java.security.*;

public class DeckOfCards {
	// Random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int NUMBER_OF_CARDS = 52;
	
	private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
	private int currentCard = 0; // Index of next Card to be dealt (0-51)
	
	// Constructor fills deck of Cards
	public DeckOfCards() {
		String[] faces = {"Ace", "Two", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suit = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		// Populate deck with Card objects
		for (int count = 0; count < deck.length; count++) {
			deck[count] =
					new Card(faces[count % 13], suit[count / 13]);
		} // End of for loop
	} // End of DeckOfCards Constructor
	
	// Shuffle deck of Cards with one-pass algorithm
	public void shuffle() {
		// Next call to method should start at deck[0] again
		currentCard = 0;
		
		// For each Card, pick another random Card (0-51) and swap them
		for (int first = 0; first < deck.length; first++) {
			// Select a random number between 0 and 51
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			// Swap current Card with randomly selected Card
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		} // End of for loop
	} // End of shuffle method
	
	// Deal one Card
	public Card dealCard() {
		// Determine whether Cards remain to be dealt
		if (currentCard < deck.length) {
			return deck[currentCard++]; // return current Card in array
		} else {
			return null; // return null to indicate all Cards were dealt
		} // End of if/else statement
	} // End of dealCard method
} // End of class DeckOfCards
