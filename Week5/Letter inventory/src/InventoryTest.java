// Programmer: Lachlan Talento
// Date:	   5/19/2022
// Course:     CS&145
// Lab:        Letter Inventory
//
// This class will do the following: test the object
//
// I got all this working, but I wasn't able to fix a bug with sum and subtract: it 
// does not take into account the characters that were added with the set method, otherwise
// it still adds and subtracts the two objects.

public class InventoryTest {

	public static void main(String[] args) {
		
		LetterInventory inventory = new LetterInventory("Happy");
		LetterInventory inventory2 = new LetterInventory("Sad");
		LetterInventory sum = inventory.add(inventory2);
		LetterInventory difference = inventory.subtract(inventory2);
		
		System.out.println("Inventory: " + inventory.toString());
		System.out.println("Number of [ in inventory: " + inventory.get('['));
		System.out.println("Inventory size: " + inventory.size());
		inventory.set('a', 9);
		System.out.println("Inventory: " + inventory.toString());
		System.out.println("Inventory size: " + inventory.size());
		System.out.println("Inventory empty: " + inventory.isEmpty());
		
		System.out.println("Inventory: " + inventory.toString());
		System.out.println("Inventory2: " + inventory2.toString());
		System.out.println("Inventory sum: " + sum.toString());
		
		System.out.println("Inventory: " + inventory.toString());
		System.out.println("Inventory2: " + inventory2.toString());
		System.out.println("Inventory difference: " + difference.toString());
	} // End of main method
	
} // End of InventoryTest class
