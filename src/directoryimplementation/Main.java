package directoryimplementation;

import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")

public class Main implements Serializable {

    public static void main(String[] args) {

        ContactList newList = new ContactList();
        int input = 0;
        String options;
        boolean bye = false;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Welcome to Suyash's Contact List App\n" +
                    "Press 1 to add a new contact\n" +
                    "Press 2 to view all contacts\n" +
                    "Press 3 to search for a contact\n" +
                    "Press 4 to delete a contact\n" +
                    "Press 5 to exit program ");
            try
            {
                input = scan.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("An Error occurred " + e);
            }

            switch (input) {
                case 1:
                    System.out.println("You have chosen to add a new contact: \n" + "Please enter the name of the Person");
                    String firstName, lastName, contactNumber, otherNumber, emailId;

                    System.out.print("First Name: ");
                    firstName = scan.next();

                    System.out.print("Last Name: ");
                    lastName = scan.next();

                    System.out.print("Contact Number: ");
                    contactNumber = scan.next();

                    System.out.print("Would you like to add another contact number? (y/n): ");
                    options = scan.next();
                    if (options.equalsIgnoreCase("y")) {
                        System.out.print("Contact Number: ");
                        otherNumber = scan.next();
                    }
                    else otherNumber = null;

                    System.out.print("Would you like to add email address? (y/n): ");
                    options = scan.next();
                    if (options.equalsIgnoreCase("y")) {
                        System.out.print("Email Address: ");
                        emailId = scan.next();
                    }
                    else emailId = null;
                    System.out.println("\n");

                    newList.addContacts(firstName, lastName, contactNumber, otherNumber, emailId);
                    break;

                case 2:
                    System.out.println("---Here are all your contacts---");
                    newList.printAllContacts();
                    break;

                case 3:
                    System.out.println("You could search for a contact from their first names:");
                    String FirstName = scan.next();
                    newList.showByFirstName(FirstName);
                    break;

                case 4:
                    newList.showContactNames();
                    System.out.print("Press the number against the contact to delete it: ");
                    int index = scan.nextInt();
                    newList.deleteContact(index);
                    break;

                case 5:
                    System.out.println("Exiting!");
                    bye = true;
                    break;
                    
                default:
                    System.out.println("Invalid Contact Found ...");
            }
        }
        while (!bye);
    }
}
