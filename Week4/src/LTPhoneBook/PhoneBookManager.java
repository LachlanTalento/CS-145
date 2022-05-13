// Programmer: Lachlan Talento
// Date:	   5/13/2022
// Course:     CS&145
// Lab:        Phone Book
//
// This program will do the following: displays an interactable digital Phone Book.
//
// I got all this working, but I wasn't able to add try/catch statements within the menus
//      due to time constraint.

package LTPhoneBook;

import java.util.Scanner; // Import Scanner

public class PhoneBookManager {

    public static void main(String[] args) {

        ListNode phoneBook = new ListNode();
        Scanner input = new Scanner(System.in);

        boolean run = true;

        System.out.println("This program displays an interactable digital Phone Book.");

        do { // Runs menu

            System.out.println();
            System.out.println("Please type one of the following: ");
            System.out.println("[1] Display the Phone Book");
            System.out.println("[2] Add an entry to the Phone Book");
            System.out.println("[3] Remove an entry from the Phone Book");
            System.out.println("[4] Edit an entry from the Phone Book");
            System.out.println("[5] Exit the program");

            String entry = input.next();

            switch (entry) {
                case "1":
                    phoneBook.display();
                    break;
                case "2":
                    addEntry(phoneBook, input);
                    break;
                case "3":
                    removeEntry(phoneBook, input);
                    break;
                case "4":
                    menuEdit(phoneBook, input, run);
                    break;
                case "5":
                    run = false;
                    break;
                default:
                    System.out.println("Please type a valid input");
                    break;
            } // End of switch/case statement
        } while (run == true);
    }

    // Adds an entry to the PhoneBook
    private static void addEntry(ListNode phoneBook, Scanner input) {

        String firstName;
        String lastName;
        String address;
        String phoneNum;

        // Asks for first name
        System.out.println("Please Type in: ");
        System.out.print("First Name: ");
        firstName = input.next();

        // Asks for last name
        System.out.print("Last Name: ");
        lastName = input.next();

        // Asks for address
        input.nextLine();
        System.out.print("Address: ");
        address = input.nextLine();

        // Asks for phone number
        System.out.print("Phone Number: ");
        phoneNum = input.next();

        phoneBook.add(firstName, lastName, address, phoneNum); // Adds the info to the PhoneBook

        return;

    } // End of addEntry method

    // Removes an entry from the PhoneBook
    private static void removeEntry(ListNode phoneBook, Scanner input) {

        System.out.println("Type the index you would like to remove: ");
        String entry = input.next();

        int index = Integer.parseInt(entry);
        int size = phoneBook.size();

        if (size == 0) {

            System.out.println("Sorry there are no entries in the Phone Book");
            return;

        } else if (index >= size || index < 0) {

            System.out.println("That is not a valid index.");
            System.out.println();
            return;

        } else {

            phoneBook.remove(index); // Removes info from the PhoneBook

        } // End of if/else statement
    } // End of remove method

    // Displays the edit menu
    private static void menuEdit(ListNode phoneBook, Scanner input, boolean run) {

        int index;
        String entry;

        do {

            System.out.println("Please type one of the following: ");
            System.out.println("[1] Edit first name");
            System.out.println("[2] Edit last name");
            System.out.println("[3] Edit address");
            System.out.println("[4] Edit phone number");
            System.out.println("[5] Edit all info");
            System.out.println("[6] Go back to main menu");

            entry = input.next();

            switch (entry) {
                case "1":

                    // Asks for index value
                    System.out.print("Index: ");
                    entry = input.next();
                    index = Integer.parseInt(entry);

                    // Asks for new first name
                    System.out.print("New first name: ");
                    entry = input.next();

                    phoneBook.editFirstName(index, entry); // Adds the edit to the PhoneBook
                    break;
                case "2":

                    // Asks for index value
                    System.out.print("Index: ");
                    entry = input.next();
                    index = Integer.parseInt(entry);

                    // Asks for new last name
                    System.out.print("New last name: ");
                    entry = input.next();

                    phoneBook.editLastName(index, entry); // Adds the edit to the PhoneBook
                    break;
                case "3":

                    // Asks for the index value
                    System.out.print("Index: ");
                    entry = input.next();
                    index = Integer.parseInt(entry);

                    // Asks for the new address
                    input.nextLine();
                    System.out.print("New address: ");
                    entry = input.nextLine();

                    phoneBook.editAddress(index, entry); // Adds the edit to the PhoneBook
                    break;
                case "4":

                    // Asks for the index value
                    System.out.print("Index: ");
                    entry = input.next();
                    index = Integer.parseInt(entry);

                    // Asks for the new phone number
                    System.out.print("New phone number: ");
                    entry = input.next();

                    phoneBook.editPhoneNum(index, entry); // Adds the edit to the PhoneBook
                    break;
                case "5":

                    // Asks for the index value
                    System.out.print("Index: ");
                    entry = input.next();
                    index = Integer.parseInt(entry);

                    // Asks for the new first name
                    System.out.print("New first name: ");
                    entry = input.next();
                    phoneBook.editFirstName(index, entry); // Adds the edit to the PhoneBook

                    // Asks for the new last name
                    System.out.print("New last name: ");
                    entry = input.next();
                    input.nextLine();
                    phoneBook.editLastName(index, entry); // Adds the edit to the PhoneBook

                    // Asks for the new address
                    System.out.print("New address: ");
                    entry = input.nextLine();
                    phoneBook.editAddress(index, entry); // Adds the edit to the PhoneBook

                    // Asks for the new phone number
                    System.out.print("New phone number: ");
                    entry = input.next();

                    phoneBook.editPhoneNum(index, entry); // Adds the edit to the PhoneBook
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Please type a valid input.");
            } // End of switch/case statement
        } while (run = true);
    } // End of menuEdit method
} // End of PhoneBookManager class
