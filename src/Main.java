import util.FileHandler;
import util.Input;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Input in = new Input();
    private static ArrayList<Contact> contacts = new ArrayList<Contact>();

    public static void main(String[] args) {
//        addContact("Matthew", "2813231986");
//        addContact("dadalt", "1234567890");
//        displayContacts();

        List<String> contactLines = FileHandler.getFileContents();
        if (contactLines != null) {
            for (String line : contactLines) {
                Contact contact = Contact.lineToContact(line);
                contacts.add(contact);
            }
        }


        boolean quit = false;

        while (!quit) {
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");
            int option = in.getInt(1, 5);
            switch (option) {
                case 1:
                    displayContacts();
                    break;
                case 2:
                    System.out.println("Enter the name of the contact:");
                    in.clearCache();
                    String name = in.getString();
                    System.out.println("Enter the number of the contact:");
                    String number = in.getString();
                    addContact(name, number);
                    break;
                case 3:
                    System.out.println("Enter the name of the contact to search:");
                    in.clearCache();
                    String searchName = in.getString();
                    Contact searchContact = getContactByName(searchName);
                    if (searchContact != null) System.out.println(searchContact.getName());
                    else System.out.println("Contact not found.");
                    break;
                case 4:
                    System.out.println("Enter the name of the contact to delete:");
                    in.clearCache();
                    String deleteName = in.getString();
                    deleteContactByName(deleteName);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    quit = true;
                    break;
            }
        }

    }


    public static void addContact(String name, String number) {
        Contact contact = new Contact(name, number);
        contacts.add(contact);
        String lineToWrite = Contact.contactToLine(contact);
        ArrayList<String> lines = new ArrayList<>();
        lines.add(lineToWrite);
        FileHandler.writeLines(lines, false);
    }

    public static Contact getContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.name.equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public static void deleteContactByName(String name) {
        Contact contact = getContactByName(name);
        if (contact != null) {
            contacts.remove(contact);
            ArrayList<String> lines = new ArrayList<>();
            for (Contact c : contacts) {
                lines.add(Contact.contactToLine(c));
            }
            FileHandler.writeLines(lines, true);
        }
    }

    public static void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " | " + contact.getNumber());
        }
    }
}
