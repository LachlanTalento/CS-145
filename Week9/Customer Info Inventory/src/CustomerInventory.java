// Programmer: Lachlan Talento
// Date:       6/14/2022
// Course:     CS&145
// Lab:        CustomerInventory
//
// This class will do the following: stores all the customers info in an inventory

public class CustomerInventory {

	private CustomerInventory root;
	private CustomerInventory leftNode;
	private CustomerInventory rightNode;
	private long IDNum;
	private long phoneNum;
	private int moneySpent;
	private int size = 0;
	private String firstName;
	private String lastName;
	private String complaints;
	
	public CustomerInventory() {
		
		this(0, 0, null, null, null, 0);
		
	} // End of Constructor

	public CustomerInventory(long IDNum, long phoneNum, String firstName, String lastName,
			String complaints, int moneySpent) {
		
		this.IDNum = IDNum;
		this.phoneNum = phoneNum;
		this.moneySpent = moneySpent;
		this.firstName = firstName;
		this.lastName = lastName;
		this.complaints = complaints;
		
		this.leftNode = null;
		this.rightNode = null;
		
	} // End of Constructor
	
	public void add(long IDNum, long phoneNum, String firstName, String lastName, 
			String complaints, int moneySpent) {
		
		CustomerInventory toInsert = new CustomerInventory(IDNum, phoneNum, firstName, lastName,
				complaints, moneySpent);
		
		boolean done = false;
		
		if (root == null) {
			
			root = toInsert;
			size++;
			return;
			
		} // End of if statement
		
		CustomerInventory current = root;
			
		while (done == false) { // Loops until node is placed
			
			if (IDNum < current.IDNum) { // If current ID is smaller than previous
				
				if (current.leftNode == null) {
					
					current.leftNode = toInsert;
					done = true;
					
				} else {
					
					current = current.leftNode;
					
				} // End of if/else statement
			} else if (IDNum > current.IDNum) { // If current ID is larger than previous
				
				if (current.rightNode == null) {
					
					current.rightNode = toInsert;
					done = true;
					
				} else {
					
					current = current.rightNode;
					
				} // End of if/else statement
			} else { // If IDs are both are equal
				
				done = true;
				
			} // End of if/else statement
		} // End of while loop
		
		size++;
		
		return;
		
	} // End of add method
	
	public int getSize() {
		
		return size;
		
	} // End of getSize method
	
	public CustomerInventory getCustomer(long IDNum) {
		
		boolean done = false;
		
		if (root == null) {

			return null;
			
		} // End of if statement
		
		CustomerInventory current = root;
			
		while (done == false) { // Loops until node is placed
			
			if (IDNum < current.IDNum) { // If current ID is smaller than previous
				
				if (current.leftNode == null) {
					
					done = true;
					
				} else {
					
					current = current.leftNode;
					
				} // End of if/else statement
			} else if (IDNum > current.IDNum) { // If current ID is larger than previous
				
				if (current.rightNode == null) {
					
					done = true;
					
				} else {
					
					current = current.rightNode;
					
				} // End of if/else statement
			} else { // If IDs are both are equal
				
				return current;
				
			} // End of if/else statement
		} // End of while loop
		
		return null;
		
	} // End of getCustomer method
	
	public long getID(long IDNum) {
		
		CustomerInventory current = getCustomer(IDNum);
		
		return current.IDNum;
		
	} // End of getSpent method
	
	public int getSpent(long IDNum) {
		
		CustomerInventory current = getCustomer(IDNum);
		
		return current.moneySpent;
		
	} // End of getSpent method
	
	public long getPhone(long IDNum) {
		
		CustomerInventory current = getCustomer(IDNum);
		
		return current.phoneNum;
		
	} // End of getSpent method
	
	public String getFirstName(long IDNum) {
		
		CustomerInventory current = getCustomer(IDNum);
		
		return current.firstName;
		
	} // End of getFirstName method
	
	public String getLastName(long IDNum) {
		
		CustomerInventory current = getCustomer(IDNum);
		
		return current.lastName;
		
	} // End of getLastName method
	
	public String getComplaints(long IDNum) {
		
		CustomerInventory current = getCustomer(IDNum);
		
		return current.complaints;
		
	} // End of getComplaints method
	
	public void addSpent(long IDNum, int toAdd) {
		
		CustomerInventory current = getCustomer(IDNum);
		
		current.moneySpent += toAdd;
		
		return;
		
	} // End of addSpent method
	
	public void clearInv() {
		
		root = null;
		size = 0;
		
	} // End of clearInv
	
	public void edit(long IDNum, long phoneNum, String firstName, String lastName,
			String complaints, int moneySpent) {
		
		CustomerInventory current = getCustomer(IDNum);
		
		current.IDNum = IDNum;
		current.phoneNum = phoneNum;
		current.moneySpent = moneySpent;
		current.firstName = firstName;
		current.lastName = lastName;
		current.complaints = complaints;
		
	} // End of edit method
} // End of CustomerInventory Class