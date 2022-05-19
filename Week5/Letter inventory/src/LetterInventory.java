// Programmer: Lachlan Talento
// Date:	   5/19/2022
// Course:     CS&145
// Lab:        Letter Inventory
//
// This class will do the following: create a inventory object that stores characters 
// from a string.
//
// I got all this working, but I wasn't able to fix a bug with sum and subtract: it 
// does not take into account the characters that were added with the set method, otherwise
// it still adds and subtracts the two objects.

public class LetterInventory {
	
	private final int alphabet = 26;
	private String data;
	private String inventory = "";

	// Constructs the inventory that ignores non alphabetic letters and case of letters
	public LetterInventory(String data) {
		
		this.data = data;
		
		int length = data.length();
		char temp;
		
		// Makes an inventory for data
		for(int i = 0; i < length; i++) {
			
			temp = data.charAt(i);
			
			// Ignores non alphabetic letters
			if (temp >= 'a' && temp <= 'z') {
			
				this.inventory += temp;
				
			// Ignores case of letter
			} else if (temp >= 'A' && temp <= 'Z') {
				
				temp = Character.toLowerCase(temp);
				
				this.inventory += temp;
				
			} // End of if/else statement
		} // End of for loop
	} // End of LetterInventory constructor
	
	// Returns the number of a letter in the inventory
	public int get(char letter) throws IllegalArgumentException{
		
		int length = data.length();
		int count = 0;
		
		letter = Character.toLowerCase(letter);

		for(int i = 0; i < length; i++) {
			
			if (inventory.charAt(i) == letter) {
				
				count++;
				
			} // End of if statement
		} // End of for loop
		
		return count;
		
	} // End of get method
	
	// Sets the number of a letter in the inventory
	public void set(char letter, int value) throws IllegalArgumentException {
		
		int count = get(letter);
		int count2 = 0;
		int length = inventory.length();
		boolean flag = false;
		String temp = "";
		
		// Checks if it should subtract
		if(count > value ) {
				
			// Checks each character in the inventory
			for(int i = 0; i < length; i++) {
							
				// Checks if the character is not equal to the letter or
				// if it has already been removed from the inventory
				if (inventory.charAt(i) != letter || flag) {
								
					temp += inventory.charAt(i);
								
				} else {
							
					count2++;
							
					if(count2 == count - value) {
								
						flag = true;
								
					} // End of if statement
				} // End of if/else statement
			} // End of for loop
			
			inventory = temp;
		
		// Checks if it should add	
		} else if (count < value) {
			
			// Makes sure it does not add too many or not enough letters
			for(int i = 0; i < value - count; i++) {
				
				inventory += letter;
				
			} // End of for loop
		} // End of if/else statement
	} // End of set method
	
	// Returns the inventory size
	public int size() {
		
		return inventory.length();
		
	} // End of size method
	
	// Checks if inventory is empty
	public boolean isEmpty() {
		
		if(inventory.length() == 0) {
			
			return true;
			
		} else {
			
			return false;
			
		} // End of if/else statement
	} // End of isEmpty method
	
	// Formats the inventory into a string
	public String toString() {
		
		int length = inventory.length();
		String list = "";
		
		// Goes through letter in the alphabet
		for (int x = 'a'; x < alphabet + 'a'; x++) {
			
			// Goes through each character in the inventory
			for(int i = 0; i < length; i++) {
				
				// Adds the character to the String list if the character is equal to the letter
				if (inventory.charAt(i) == x) {
					
					list += inventory.charAt(i);
					
				} // End of if statement
			} // End of for loop
		} // End of for loop
		
		inventory = list;
		
		return inventory;
		
	} // End of toString method
	
	// Returns a sum of the other inventory and this inventory
	public LetterInventory add(LetterInventory other) {
		
		LetterInventory sum = new LetterInventory("");
		
		sum.inventory = this.inventory + other.inventory;
		
		return sum;
		
	} // End of add constructor
	
	// Returns a subtraction of the other inventory and this inventory
	public LetterInventory subtract(LetterInventory other) {
		
		LetterInventory difference = new LetterInventory("");
		
		String list = inventory;
		String temp = "";
		int length = list.length();
		int otherLength = other.inventory.length();
		
		// Goes through character in the other inventory
		for (int x = 0; x < otherLength; x++) {
			
			// Goes through each character in this inventory
			for(int i = 0; i < length; i++) {
				
				// Adds only characters from other inventory to temp if it's not in this inventory
				if (list.charAt(i) != other.inventory.charAt(x)) {
					
					temp += list.charAt(i);
					
				} // End of if statement
			} // End of for loop
			
			if(temp != list) {
				
				list = temp;
				length = list.length();
				
				temp = "";
				
			} // End of if statement
			
			temp = "";
			
		} // End of for loop
		
		difference.inventory = list;
		
		return difference;
		
	} // End of subtract constructor
} // End of LetterInventory class