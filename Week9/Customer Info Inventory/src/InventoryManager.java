// Programmer: Lachlan Talento
// Date:       6/14/2022
// Course:     CS&145
// Lab:        CustomerInventory
//
// This class will do the following: manages the CustomerInventory

import java.util.Scanner;

public class InventoryManager extends CustomerInventory{
	
	CustomerInventory inv = new CustomerInventory();
	
	// Adds a customer to the inventory
	public void addCustomer() {
		
		Scanner input = new Scanner(System.in);
		
		long IDNum;
		long phoneNum;
		int moneySpent;
		String firstName;
		String lastName;
		String complaints;
		
		line();
		
		System.out.print("Input The Customer's ID#: ");
		IDNum = input.nextLong();
		System.out.print("Input The Customer's Phone#: ");
		phoneNum = input.nextLong();
		System.out.print("Input The Amount Spent: $");
		moneySpent = input.nextInt();
		System.out.print("Input The Customer's First Name: ");
		firstName = input.next();
		System.out.print("Input The Customer's Last Name: ");
		lastName = input.next();
		System.out.print("Input Any Complaints: ");
		input.nextLine();
		complaints = input.nextLine();
		System.out.println();
		
		System.out.println("Processing...");
		
		inv.add(IDNum, phoneNum, firstName, lastName, complaints, moneySpent);
		
		System.out.println("Finished.");
		
		line();
		
	} // End of addCustomer method
	
//	public void editCustomer() {
//		
//		Scanner input = new Scanner(System.in);
//		CustomerInventory current;
//		
//		long IDNum;
//		long phoneNum;
//		int moneySpent;
//		String firstName;
//		String lastName;
//		String complaints;
//		
//		line();
//		
//		try {
//			
//			System.out.print("Input The Customer's ID#: ");
//			IDNum = input.nextLong();
//			current = getCustomer(IDNum);
//			
//		} catch (Exception e) {
//			
//			System.out.println("Could not find Results");
//			
//			line();
//			
//			return;
//		}
//		
//		System.out.print("Input The Customer's (New) Phone#: ");
//		phoneNum = input.nextLong();
//		System.out.print("Input The (New) Amount Spent: $");
//		moneySpent = input.nextInt();
//		System.out.print("Input The Customer's (New) First Name: ");
//		firstName = input.next();
//		System.out.print("Input The Customer's (New) Last Name: ");
//		lastName = input.next();
//		System.out.print("Input Any (New) Complaints: ");
//		input.nextLine();
//		complaints = input.nextLine();
//		System.out.println();
//		
//		System.out.println("Processing...");
//		
//		current.edit(IDNum, phoneNum, firstName, lastName, complaints, moneySpent);
//		
//		System.out.println("Finished.");
//		
//		line();
//		
//	} // End of editCustomer method
	
	// Displays ID at a specified ID #
	public void displayID() {
		
		Scanner input = new Scanner(System.in);
		
		long IDNum;
		
		line();
		
		System.out.print("Input The Customer's ID#: ");
		IDNum = input.nextLong();
		
		line();
		
		displayID(IDNum);
		
	} // End of display
	
	// Displays ID at an ID #
	public void displayID(long IDNum) {

		CustomerInventory current = inv;
		
		String complaints;
		int size;
		
		try {
			
			complaints = current.getComplaints(IDNum);
			size = complaints.length();
		
		} catch(Exception e) {
			
			System.out.println("Could not find Results");
			
			line();
			
			return;
			
		} // End of try/catch
		
		line();
		
		System.out.println("Customer ID: #" + current.getID(IDNum));
		System.out.println("First Name: " + current.getFirstName(IDNum));
		System.out.println("Last Name: " + current.getLastName(IDNum));
		System.out.println("Phone Number: " + current.getPhone(IDNum));
		System.out.println();
		System.out.println("Spent Today: $" + current.getSpent(IDNum));
		System.out.println();
		System.out.println("Complaints:");
		
		for (int i = 0; i < size; i++) {
			
			if (i % 30 == 0) {
				
				System.out.println();
				System.out.print(complaints.charAt(i));
				
			} else {
			
				System.out.print(complaints.charAt(i));
				
			} // End of if/else statement
		} // End of for loop
		
		System.out.println();
		
		line();
		
	} // End of display method
	
	// Creates a Line
	public void line() {
		
		for(int i = 0; i < 10; i++) {
			
			System.out.print("---");
			
		} // End of for loop
		
		System.out.println();
		System.out.println();
		
	} // End of line method
	
	public void workInProgress() {
		
		System.out.println("W.I.P");
		
	} // end of workInProgress method
} // End of InventoryManager class
