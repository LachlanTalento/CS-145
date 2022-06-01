// Programmer: Lachlan Talento
// Date:       5/31/2022
// Course:     CS&145
// Lab:        Word Search Generator
//
// This program will do the following: Generate a crossword puzzle

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class LTWordSearchGenerator {

	public static void main(String[] args) {
		
		LTWordSearchGenerator crossword = new LTWordSearchGenerator(); 
		
		crossword.printIntro();
		
	} // End of main method
	
	public void printIntro() {
		
		Scanner input = new Scanner(System.in);
		
		// Size of crossword puzzle
		final int row = 20; // Height
		final int column = 20; // Width
		
		boolean run = true;
		boolean generated = false;
		char option;
		char[][] crossWord = null;
		
		System.out.println("Welcome!");
		System.out.println("This program will generate a crossword puzzle based off of");
		System.out.println("the words you would like to add.");
		
		do {
			
			System.out.println();
			System.out.println("Please type one of the following: ");
			System.out.println();
			System.out.println("[g] Generates a new crossword puzzle");
			System.out.println("[p] Prints the crossword puzzle");
			System.out.println("[s] Prints the solution for the puzzle");
			System.out.println("[x] To exit out of the program");
			System.out.println();
			
			option = input.next().charAt(0);
			
			switch(option) {
			
				case 'g':
					
					crossWord = generate(input, row, column);
					
					generated = true;
					
					break;
				case 'p':
					
					if(generated == true) {
						
						print(crossWord, row, column);
						
					} else {
					
						System.out.println("\nYou must Generate a crossword puzzle first");
					
					} // End of if/else statement
					break;
				case 's':
					
					if(generated == true) {
						
						showSolution(crossWord, row, column);
					
					} else {
					
						System.out.println("\nYou must Generate a crossword puzzle first");
					
					} // End of if/else statement
					break;
				case 'x':
					
					System.out.println("\nExiting program...");
					
					run = false;
					
					break;
				default:
					
					System.out.println("\nError!");
					
					break;
			
			} // End of switch case statement
		} while(run); // End of do while loop
	} // End of printIntro method
	
	public char[][] generate(Scanner input, final int row, final int column) {
		
		ArrayList<String> wordsToAdd = new ArrayList<String>();
		Random rand = new Random();

		int tempRow;
		int tempColumn;
		int type;
		int length;
		int numWords = 0;
		boolean error = true;
		boolean exit = false;
		boolean valid = false;
		boolean abc = true;
		String yesOrNo;
		String userIn;
		char[][] crossWord = new char[row][column];
		
		// Gets the number of words and the words they want to add
		do {
            try {
            	
            	System.out.print("\nHow many words would you like to add?: ");
    			numWords = input.nextInt();
    			
                error = false;
            } 
            catch (Exception e) {
            	
                System.out.println("\nError!");
                
                input.reset();
                input.next();
    			
            }
        } while (error);
		
		do {
			
			for(int i = 0; i < numWords; i++) {
				
				do {
					
					System.out.print("\nPlease type a word you want to add: ");
					
					userIn = input.next().toLowerCase();
					
					for(int y = 0; y < userIn.length(); y++) {
						
						// Ignores non alphabetic letters
						if (userIn.charAt(y) <= 'a' && userIn.charAt(y) >= 'z') {
							
							abc = false;
							
						} // End of if statement
					} // End of for loop
						
						if(abc == true) {
							
							// Ignores case of letter
							wordsToAdd.add(input.next().toLowerCase());
							
							abc = false;
							
						} else {
							
							System.out.println("\nError!");
							
						} // End of if/else statement
						
				} while(abc); // End of do while loop
				
			} // End of for loop
		
			do {
			
				System.out.println("\nIndex: " + wordsToAdd);
				System.out.print("\nAre you sure these are the words you want?: ");
				yesOrNo = input.next().toLowerCase();
				
				// Checks if the user wants to keep the words they chose
				if(yesOrNo.charAt(0) == 'y') { // If yes
					
					valid = true;
					exit = true;
					
				} else if (yesOrNo.charAt(0) == 'n') {// If no
					
					wordsToAdd.removeAll(wordsToAdd);
					
					exit = true;
					
				} else {
					
					System.out.println("\nError!");
					
					input.reset();
					
				} // End of if/else statement
			} while(exit == false);
		} while(valid == false);
		
		System.out.println("\nGenerating crossword puzzle...");
		
		// Loops until all words are added
		for(int i = 0; i < wordsToAdd.size(); i ++) {
			
			length = wordsToAdd.get(i).length(); // Gets the length of the word at the index
			
			tempColumn = rand.nextInt(column - length + 1); // Generates a random column
			tempRow = rand.nextInt(row - length + 1); // Generates a random row
			type = rand.nextInt(3); // Generates a random word formation type
			
			if(type == 0) { // Horizontal
				
				// Checks if a word can be placed where it is assigned
				for(int x = 0; x < length; x++) { 
					
					while(crossWord[tempRow][tempColumn + x] != 0 && crossWord[tempRow]
							[tempColumn + x] != wordsToAdd.get(i).charAt(x)) {
						
						tempRow = rand.nextInt(column - length + 1);
						x = 0;
						
					} // End of if statement
				} // End of for loop
				
				// Adds words horizontally
				for(int x = 0; x < length; x++) { 
					
					crossWord[tempRow][tempColumn + x] = wordsToAdd.get(i).charAt(x);
					
				} // End of for loop
			} else if (type == 1){ // Vertical
				
				// Checks if a word can be placed where it is assigned
				for(int x = 0; x < length; x++) { 
					
					while(crossWord[tempRow + x][tempColumn] != 0 && crossWord[tempRow + x]
							[tempColumn] != wordsToAdd.get(i).charAt(x)) {
						
						tempColumn = rand.nextInt(row - length + 1);
						x = 0;
						
					} // End of if statement
				} // End of for loop
				
				// Adds words Vertically
				for(int x = 0; x < length; x++) { 
					
					crossWord[tempRow + x][tempColumn] = wordsToAdd.get(i).charAt(x);
					
				} // End of for loop
			} else if (type == 2){ // Diagonal
				
				// Checks if a word can be placed where it is assigned
				for(int x = 0; x < length; x++) { 
					
					while(crossWord[tempRow + x][tempColumn + x] != 0 && crossWord[tempRow + x]
							[tempColumn + x] != wordsToAdd.get(i).charAt(x)) {
						
						tempRow = rand.nextInt(column - length + 1);
						x = 0;
						
					} // End of if statement
				} // End of for loop
				
				// Adds words diagonally
				for(int x = 0; x < length; x++) { 
					
					crossWord[tempRow + x][tempColumn + x] = wordsToAdd.get(i).charAt(x);
					
				} // End of for loop
			} // End of if/else statement
		} // End of for loop
		
		System.out.println("\nCrossword puzzle generated");
		
		return crossWord;
		
	} // End of generate method
	
	// Prints an unfinished crossword puzzle
	public void print(char[][] crossWord, final int row, final int column) {
		
		Random rand = new Random();
		
		char letter;
		char[][] crossWordSolve = new char[row][column];
		
		// Creates a temp unsolved crossword
		for(int i = 0; i < row; i++) {
			
			for(int x = 0; x < column; x++) {
				
				crossWordSolve[i][x] = crossWord[i][x];
				
			} // End of for loop
		} // End of for loop
		
		// Fills in all blank spaces with a random letter
		for(int x = 0; x < row; x++) {
			
			for(int y = 0; y < column; y++) {
				
				if(crossWordSolve[x][y] == 0) {
					
					letter = (char) (rand.nextInt(26) + 97);
					
					crossWordSolve[x][y] = letter;
					
				} // End of for loop
			} // End of for loop	
		} // End of for loop

		// Prints the crossword puzzle
		for(int i = 0; i < row; i++) {
			
			for(int x = 0; x < column; x++) {
				
				System.out.print(crossWordSolve[i][x] + " ");
				
			} // End of for loop
			
			System.out.println();
			
		} // End of for loop
		
	} // End of print method
	
	// Shows the solution
	public void showSolution(char[][] crossWord, final int row, final int column) {
		
		char[][] crossWordSolution = new char[row][column];
		
		// Creates a temp solution for the crossword puzzle
		for(int i = 0; i < row; i++) {
			
			for(int x = 0; x < column; x++) {
				
				crossWordSolution[i][x] = crossWord[i][x];
				
			} // End of for loop
		} // End of for loop
		
		// Fills in all blank spaces with x's
		for(int x = 0; x < row; x++) {
			
			for(int y = 0; y < column; y++) {
				
				if(crossWordSolution[x][y] == 0) {
					
					crossWordSolution[x][y] = 'x';
					
				} // End of for loop
			} // End of for loop	
		} // End of for loop
		
		// Prints the solution for the crossword puzzle
		for(int i = 0; i < row; i++) {
			
			for(int x = 0; x < column; x++) {
				
				System.out.print(crossWordSolution[i][x] + " ");
				
			} // End of for loop
			
			System.out.println();
			
		} // End of for loop
	} // End of showSolution method
} // End of LTWordSearchGenerator class
