package directoryimplementation;

import java.io.Serializable;
@SuppressWarnings("serial")

class ContactList implements Serializable {
    private Person head;
    private int contactLength;

    public ContactList()
    {
        head = null;
        contactLength = 0;
    }

    public void addContacts(String firstName, String lastName, String contactNumber, String otherContactNumber, String emailAddress) {
        Person current = head;
        Person previous = null;
        Person newNode = new Person();

        newNode.setFirstName(firstName);
        newNode.setLastName(lastName);
        newNode.setContactNumber(contactNumber);
        newNode.setAnotherContactNumber(otherContactNumber);
        newNode.setEmailAddress(emailAddress);

        if (isEmpty())
        {
            head = newNode;
            contactLength++;
        }
        else
            {

            for (int i = 0; i < contactLength; i++) {
                String[] Name1 = current.getFirstName().split(" ");
                String[] Name2 = newNode.getFirstName().split(" ");

                int result = Name1[Name1.length - 1].compareToIgnoreCase(Name2[Name2.length - 1]);

                if (result > 0) {
                    if (previous == null) {
                        newNode.setNext(current);
                        head = newNode;
                        contactLength++;
                        break;
                    }
                    previous.setNext(newNode);
                    newNode.setNext(current);
                    contactLength++;
                    break;
                }
                else
                    {
                    if (current.getNext() == null) {
                        current.setNext(newNode);
                        newNode.setNext(null);
                        contactLength++;
                        break;
                    }
                    previous = current;
                    current = current.getNext();
                }
            }
        }
    }

    public boolean isEmpty() {
        return (contactLength == 0);
    }

    public void printAllContacts() {
        Person tempNode = head;
        if (head == null) {
            System.out.println("**************************\n|    Sorry! Nothing to show! Your contact list is Empty!       |\n*****************************\n");
        }
        else
            {
            for (int i = 0; i < contactLength; i++) {
                System.out.print("-------- * -------- * -------- * --------");
                System.out.println(tempNode);
                tempNode = tempNode.getNext();
                System.out.println("-------- * -------- * -------- * --------");
            }

        }
        System.out.println();
    }

    public void showByFirstName(String firstName) {
        Person current = head;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("*****************************\n|    Sorry! Nothing to show! Your contact list is Empty!      |\n*****************************\n");
        } else {
            for (int i = 0; i < contactLength; i++) {
                if (current.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
                    System.out.println((i + 1) + " match found!");
                    System.out.print("-------- * -------- * -------- * --------");
                    System.out.println(current);
                    System.out.println("-------- * -------- * -------- * --------");
                    empty = false;
                }
                current = current.getNext();
            }

            if (empty) {
                System.out.println("NO RESULTS FOUND!");
            }
        }

    }

    public void showContactNames() {
        Person current = head;
        System.out.println("Here are all your contacts:");
        for (int i = 0; i < contactLength; i++) {
            System.out.println((i + 1) + ". " + current.getFirstName() + " " + current.getLastName());
            current = current.getNext();
        }
    }

    public void deleteContact(int index) {
        Person current = head;
        Person previous = null;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("***************************************\n|    Sorry! Nothing to show! Your contact list is Empty!      |\n***************************************\n");
        } else {
            for (int i = 0; i < contactLength; i++) {
                if ((index - 1) == i) {
                    if (previous == null) {
                        head = head.getNext();
                        contactLength--;
                        empty = false;
                        break;
                    } else if (current.getNext() == null) {
                        previous.setNext(null);
                        contactLength--;
                        empty = false;
                        break;
                    } else {
                        previous.setNext(current.getNext());
                        contactLength--;
                        empty = false;
                        break;
                    }
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
            if (empty)
            {
                System.out.println("Contact Not Found");
            }
            else
                {
                 System.out.println(current.getFirstName() + " " + current.getLastName() + "contact deleted from list!");
            }
        }
    }
}