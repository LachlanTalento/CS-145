// Programmer: Lachlan Talento
// Date:       6/14/2022
// Course:     CS&145
// Lab:        CustomerInventory
//
// This class will do the following: run a customer ID inventory
//
// I got all this working, but I couldn't finish edit and display all methods

import java.util.Scanner;

public class InventoryTest {

	public static void main(String[] args) {
		
		InventoryManager invManage = new InventoryManager();
		Scanner input = new Scanner(System.in);
		
		boolean run = true;
		char option;
		
		System.out.println("Welcome to the Customer Inventory!");
		System.out.println("This Inventory Keeps Track of All");
		System.out.println("The Customers We Had Today.");
		
		do {
			
			System.out.println();
			System.out.println("Please Type One of The Following: ");
			System.out.println("[a] To Add a Customer");
			System.out.println("[e] To Edit The Info of a Customer");
			System.out.println("[d] To Display The Info of a Customer");
			System.out.println("[s] To Display All The Customers");
			System.out.println("[z] To Clear All Entries");
			System.out.println("[x] To Exit The Progam");
			
			option = input.next().charAt(0);
			
			switch (option) {
			
				case 'a':
					
					invManage.addCustomer();
					
					break;
				case 'e':
					
					invManage.workInProgress();
//					invManage.editCustomer();
					
					break;
				case 'd':
					
					invManage.displayID();
					
					break;
				case 's':
					
					invManage.workInProgress();
					
					break;
				case 'z':
					
					invManage.clearInv();
					
					break;
				case 'x':
					
					run = false;
					
					break;
				default:
					
					System.out.println("Please Type a Valid Character");
					
					break;
			} // End of switch/case statement
		} while (run);
	} // End of main method
}
