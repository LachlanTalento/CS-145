// Programmer: Lachlan Talento
// Date:	   5/24/2022
// Course:     CS&145
// Lab:        Towers of Hanoi
//
// This program will do the following: Gives directions to solve the Towers of Hanoi puzzle.
//
// The Towers of Hanoi puzzle: this is a puzzle consisting of three rods and an x number of discs.
// The objective of the puzzle is to move the entire stack to another rod, obeying the following rules:
// 		1. Only one disc can be moved at a time
//		2. A larger disc cannot be stacked on top of a smaller disc
// 		3. Only the disc on the uppermost part of the stack can be moved
//
// I got all this working, but I wasn't able to make it so it works for more than 3 discs.

public class TowerOfHanoi {
		
	public static void main(String[] arg) {
		
		// The size of the disc gets larger after each disc count (1, smallest and 3, biggest)
		int numDisc = 3; // Must be set to 3 or less
		
		moveDiscs(numDisc, 'A', 'B', 'C'); // A, B, and C are rods
		
	} // End of main method
	
	// Moves the discs to another rod according to the rules set
	public static void moveDiscs(int numDisc, char src, char extra, char dest) {
		
		if(numDisc == 1) {
			
			System.out.printf("Move disc from rod %c to rod %c%n", src, dest);
			return;
			
		} else {
			
			moveDiscs(numDisc - 1, src, dest, extra); // Swaps the destination rod and extra rod
			moveDiscs(1, src, extra, dest); // Swaps the destination rod and extra rod again
			moveDiscs(numDisc - 1, extra, src, dest); // Swaps the source rod and the extra rod
			
		} // End of if/else statement
	} // End of moveDiscs method
} // End of TowerOfHanoi class
