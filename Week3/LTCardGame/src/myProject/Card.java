// Programmer: Lachlan Talento
// Date:	   4/26/2022
// Course:     CS&145
// Lab:        Card Game
//
// This class will do the following: 

package myProject;

public class Card {
	// Initializing variables
	private final String face; // Face of the Card
	private final String suit; // Suit of the Card
	
	// Two-argument constructor initializes card's face and suit
	public Card(String cardFace, String cardSuit) {
		this.face = cardFace; // Initializes face of Card
		this.suit = cardSuit; // Initializes suit of Card
	} // End of Card Constructor
	
	// Return String representation of Card
	public String toString() {
		return face + " of " + suit;
	} // End of toString method
} // End of class card