//This program allows the user to store personal information 
//in key/value pairs using a binary search tree
// Name: Pierce Coyle
// Date: 3/15/2024  
// Class: CS 145
// Assignment:  lab #6 - Binary Search Tree.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) { //Handles menu and user interaction
        TreeManager manager = new TreeManager();
        Scanner scan = new Scanner(System.in);

        Boolean running = true;
        int nodeCount = 0;
        int key;
        String choiceStr;
        String[] value = new String[7];
        String[] newValue = new String[7];

        //Menu Start
        choiceStr = promptUser(scan);
        while(running) {
            String choiceLowerCase = choiceStr.toLowerCase();
            if (choiceLowerCase.equals("1") || choiceLowerCase.equals("add")) {
                System.out.println("Enter Primary Key:");
                key = scan.nextInt();
                scan.nextLine();
                value = getInfoFromUser(scan);
                manager.add(key, value);
            } else if (choiceLowerCase.equals("2") || choiceLowerCase.equals("delete")) {
                System.out.println("Enter The Primary Key to Delete:");
                key = scan.nextInt();
                scan.nextLine();
                manager.delete(key);
            } else if (choiceLowerCase.equals("3") || choiceLowerCase.equals("modify")) {
                System.out.println("Enter The Key to Modify:");
                key = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter Your New Info:");
                newValue = getInfoFromUser(scan);
                manager.modify(key, newValue);
            } else if (choiceLowerCase.equals("4") || choiceLowerCase.equals("Lookup")) {
                System.out.println("What Type of Lookup?");
                System.out.println("1 - in-order");
                System.out.println("2 - post-order");
                System.out.println("3 - pre-order");      
                int userInt = scan.nextInt();
                scan.nextLine();
                manager.traversal(userInt);
            } else if (choiceLowerCase.equals("5") || choiceLowerCase.equals("list")) {
                nodeCount = manager.list();
                if (nodeCount == 0) {
                    System.out.println("The tree is empty.");
                } else if (nodeCount == 1) {
                    System.out.println("There is " + nodeCount + " Node in This Tree.");
                } else {
                    System.out.println("There are " + nodeCount + " Nodes in This Tree.");
                }
            } else if (choiceLowerCase.equals("6") || choiceLowerCase.equals("exit")) {
                System.out.println("Exiting program...");
                running = false;
                break;
            } else {
                //Handles wrong input
                System.out.println("Input Invalid.");
            }
            choiceStr = promptUser(scan);
        }
    } //End of main

    public static String[] getInfoFromUser(Scanner scan) {//recieves values and stores in array
        int tempInt;
        String firstName;
        String lastName;
        String address;
        String city;
        String state;
        String email;
        String zipCode;
        String phoneNumber;

        System.out.print("First Name: ");
        firstName = scan.nextLine();
        System.out.print("Last Name: ");
        lastName = scan.nextLine();
        System.out.print("Address: ");
        address = scan.nextLine();
        System.out.print("City: ");
        city = scan.nextLine();
        System.out.print("State: ");
        state = scan.nextLine();
        System.out.print("Email: ");
        email = scan.nextLine();
        System.out.print("Zip Code: ");
        tempInt = scan.nextInt();
        scan.nextLine();
        zipCode = getStringFromInt(tempInt);
        System.out.print("Phone Number: ");
        tempInt = scan.nextInt();
        scan.nextLine();
        phoneNumber = getStringFromInt(tempInt);
        String[] tempValue = 
        {firstName, lastName, address, city, state, email, zipCode, phoneNumber};

        return tempValue;
    }//End of getInfoFromUser

    public static String getStringFromInt(int temp) { //converts the int values into strings.
        String tempString = String.valueOf(temp);
        return tempString;
    } //End of getStringFromInt

    public static String promptUser(Scanner scan) { //prompts the user for a menu input.
        System.out.println("1 - Add");
        System.out.println("2 - Delete");
        System.out.println("3 - Modify");
        System.out.println("4 - Lookup");
        System.out.println("5 - List Records");
        System.out.println("6 - Exit");
        String choiceStr = scan.nextLine();
        return choiceStr;
    } //End of promtUser
}
    

