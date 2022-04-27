// Programmer: Lachlan Talento
// Date:	   4/26/2022
// Course:     CS&145
// Lab:        Card Game
//
// This class will do the following: 

package myProject;

public class DeckOfCardsTest {
	// Execute application
	public static void main(String[] args) {
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // Place Cards in a random order
		
		// Print all 52 Cards in the order in which they are dealt
		for (int i = 1; i <= 52; i++) {
			// Deal and display a Card
			System.out.printf("%-19s", myDeckOfCards.dealCard());
			
			if (i % 4 == 0) { // Output a new line after every fourth Card
				System.out.println();
			} // End of if statement
		} // End of for loop
	} // End of main method
} // End of DeckOfCardsTest class