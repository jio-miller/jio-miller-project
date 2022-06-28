import java.util.ArrayList;

public class Main {
    private static ArrayList<Contact> contacts = new ArrayList<Contact>();

    public static void main(String[] args) {
        addContact("Matthew", "2813231986");
        addContact("dadalt", "1234567890");
        getContacts();
    }



    public static void addContact(String name, String number) {
        contacts.add(new Contact(name, number));
    }

    public static Contact getContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.name.equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public static void deleteContact(String name) {
        Contact contact = getContactByName(name);
        if (contact != null) {
            contacts.remove(contact);
        }
    }

    public static void getContacts(){
        for (Contact contact: contacts) {
            System.out.println(contact.name+" | "+contact.number);
        }
    }
}
