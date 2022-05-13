// Programmer: Lachlan Talento
// Date:	   5/13/2022
// Course:     CS&145
// Lab:        Phone Book
//
// This program will do the following: create a linked list (Phone Book) object that can be
//      accessed by another class.
//
// I got all this working, but I wasn't able to implement the sort method and the search method.

package LTPhoneBook;

public class ListNode {

    // Initializing variables
    private ListNode front;
    private ListNode next;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNum;

    public ListNode() {

        this(null, null, null, null);

    }

    // Constructs a new node to store phonebook info
    public ListNode(String firstName, String lastName, String address, String phoneNum) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNum = phoneNum;

        this.next = null;
    }

    // Adds a person's info to the phonebook
    public void add(String firstName, String lastName, String address, String phoneNum) {

        ListNode toInsert = new ListNode(firstName, lastName, address, phoneNum);

        // Creates a front node if there is none
        if (front == null) {

            front = toInsert;
            return;

        } // End of if statement

        ListNode temp = front; // Creates a temporary ListNode

        // Places the temporary node at the end of the list
        while(temp.next != null) {

            temp = temp.next;

        } // End of while loop

        temp.next = toInsert;

    } // End of add method

    // Removes a person's info from the phonebook
    public void remove(int index) {

        if (index == 0) {

            front = front.next; // Removes the first node

        } else {

            ListNode temp = nodeAt(index - 1);

            temp.next = temp.next.next; // Removes the node at the index

        } // End of if/else statement
    } // End of remove method

    // Displays the phonebook
    public void display() {

        ListNode temp = front;

        int index = 0;

        if (temp == null) {

            System.out.println("There is Nothing to Display");
            return;

        }

        do {

            System.out.println(index + ". " + temp.firstName + " " + temp.lastName + " " +
                    temp.address + " " + temp.phoneNum);
            // ex. 0. John Doe 123 fake st 1234567890

            temp = temp.next; // Goes to the next node

            index++;

        } while (temp != null);

    } // End of display method

    // Edits first name entry
    public void editFirstName(int index, String firstName) {

        ListNode temp = nodeAt(index);

        temp.firstName = firstName;

    } // End of editFirstName

    // Edits last name entry
    public void editLastName(int index, String lastName) {

        ListNode temp = nodeAt(index);

        temp.lastName = lastName;

    } // End of editLastName

    // Edits address entry
    public void editAddress(int index, String address) {

        ListNode temp = nodeAt(index);

        temp.address = address;

    } // End of editAddress

    // Edits phone number entry
    public void editPhoneNum(int index, String phoneNum) {

        ListNode temp = nodeAt(index);

        temp.phoneNum = phoneNum;

    } // End of phoneNum

    // Returns the number of entries in the PhoneBook
    public int size() {

        ListNode temp = front;

        int count = 0;

        do {

            count++;
            temp = temp.next;

        } while (temp != null);

        return count;

    } // End of size method

    // Returns the entry at the index
    private ListNode nodeAt(int index) {
        ListNode temp = front;

        for (int i = 0; i < index; i++) {

            temp = temp.next;

        }

        return temp;

    } // end of nodeAt method
} // End of ListNode class
