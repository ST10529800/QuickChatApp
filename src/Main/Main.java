/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import Login.Login;
import Message.Message;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

Login login = new Login();

ArrayList<Message> messages = new ArrayList<>();

System.out.println("===== QUICKCHAT LOGIN =====");

System.out.print("Enter username: ");
String username = input.nextLine();

System.out.print("Enter password: ");
String password = input.nextLine();

boolean loginStatus = login.loginUser(username, password);

if (loginStatus) {

System.out.println("\nWelcome to QuickChat.");

System.out.print("How many messages would you like to send? ");
int totalMessages = input.nextInt();
input.nextLine();

int sentMessages = 0;

int option;

do {

System.out.println("""

===== MENU =====
1) Send Messages
2) Show Recently Sent Messages
3) Quit
""");

System.out.print("Choose an option: ");
option = input.nextInt();
input.nextLine();

switch (option) {

case 1:

if (sentMessages < totalMessages) {

System.out.print("Enter recipient number: ");
String recipient = input.nextLine();

System.out.print("Enter message: ");
String messageText = input.nextLine();

Message msg = new Message(recipient, messageText, sentMessages);

System.out.println(msg.checkRecipientCell());

System.out.println(msg.checkMessageLength());

System.out.println("Message ID: " + msg.getMessageID());

System.out.println("Message Hash: " + msg.createMessageHash());

System.out.println("""
                   1) Send Message
                   2) Disregard Message
                   3) Store Message
                                        """);

System.out.print("Choose option: ");
int sendOption = input.nextInt();
input.nextLine();

System.out.println(msg.sentMessage(sendOption));

if (sendOption == 1 || sendOption == 3) {

messages.add(msg);

sentMessages++;
}

} else {

System.out.println("Message limit reached.");
}

break;

case 2:

if (messages.isEmpty()) {

System.out.println("Coming Soon.");

} else {

System.out.println("\n===== SENT MESSAGES =====");

for (Message m : messages) {

System.out.println(m.printMessages());
System.out.println("------------------------");
}
}

break;

case 3:

System.out.println("Exiting QuickChat...");
break;

default:

System.out.println("Invalid option.");
}

} while (option != 3);

} else {

System.out.println("Login failed.");
}
    }
}


