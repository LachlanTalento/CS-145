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

#include <stdio.h>

int main(void) {

	// The size of the disc depends on the number (1, smallest and 3, biggest)
	int numDisc = 3; // Only works with 3 or less discs

	moveDisc(numDisc, 'A', 'B', 'C'); // A, B, and C are rods

	return 0;

} // End of main function

// Moves the discs to another rod according to the rules set
void moveDisc(int numDisc, char src, char extra, char dest) {

	if(numDisc == 1) {

		printf("Move disc from rod %c to rod %c\n", src, dest);
		return;

	} else {

		moveDisc(numDisc - 1, src, dest, extra); // Swaps destination rod and extra rod
		moveDisc(1, src, extra, dest); // Swaps destination rod and extra rod again
		moveDisc(numDisc - 1, extra, src, dest); // Swaps source rod and extra rod

	} // End of if/else statement
} // End of moveDiscs function
