

import java.util.Scanner;

public class Main {
    private static MobilePhone mobilePhone = new MobilePhone("009 765 4453");
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MobilePhone mobilePhone = new MobilePhone("009 765 4453");


        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter actions: (6 to show available actions");
            int action = scan.nextInt();
            scan.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\nShutting Down....");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    System.out.println("Invalid Command. Try Again");
            }
        }

    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scan.nextLine();
        System.out.println("Enter new number: ");
        String phone = scan.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = " + phone);
        } else {
            System.out.println("Cannot add, " + name + " already in file");
        }
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void startPhone() {
        System.out.println("STARTING PHONE...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts \n" +
                "2 - to add new contact\n" +
                "3 - to update existing contacts\n" +
                "4 - to remove an existing contct\n" +
                "5 - query if an existing contact exists\n" +
                "6 - to print a list of available actions.\n");

        System.out.println("Choose your action: ");
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scan.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scan.nextLine();
        System.out.print("Enter new Contact phone number: ");
        String newNumber = scan.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scan.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        if(mobilePhone.removeContact(existingContactRecord))
        {
            System.out.println("Successfully Deleted");
        }else
        {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scan.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " +existingContactRecord.getPhoneNumber());

    }
}




