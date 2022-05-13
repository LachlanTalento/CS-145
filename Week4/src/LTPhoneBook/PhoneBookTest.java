package LTPhoneBook;

public class PhoneBookTest {
    public static void main(String[] args) {

        ListNode phoneBook = new ListNode();

        phoneBook.add("Jimmy", "John", "1234 Happy Ave", "2066379414");
        phoneBook.add("Johnny", "Smith", "4321 Sad St", "2369067894");
        phoneBook.add("Lily", "Lane", "325442 Any St", "2063746895");

        phoneBook.display();

        phoneBook.remove(0);

        phoneBook.display();

        phoneBook.editFirstName(0, "Timmy");

        phoneBook.display();

    } // End of main method
} // End of PhoneBookTest class