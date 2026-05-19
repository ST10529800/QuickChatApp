/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Message;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Message {

    private String messageID;
    private String recipient;
    private String message;
    private int messageNumber;

    // Constructor
    public Message(String recipient, String message, int messageNumber) {

        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = messageNumber;
    }

    // Generate random 10 digit Message ID
    private String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L +
                (long)(random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // Validate Message ID
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // Validate recipient cellphone number
    public String checkRecipientCell() {

        if (recipient.matches("^\\+\\d{10,12}$")) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Validate message length
    public String checkMessageLength() {

        if (message.length() <= 250) {

            return "Message ready to send.";

        } else {

            int extraCharacters = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + extraCharacters
                    + ", please reduce the size.";
        }
    }

    // Create Message Hash
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        String firstTwoDigits = messageID.substring(0, 2);

        return (firstTwoDigits + ":"
                + messageNumber + ":"
                + firstWord + lastWord).toUpperCase();
    }

    // Send / Disregard / Store Message
    public String sentMessage(int choice) {

        switch (choice) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // Print message details
    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + createMessageHash()
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;
    }

    // Store message into JSON file
    public void storeMessageToJSON() {

        try {

            FileWriter writer = new FileWriter("messages.json", true);

            writer.write("{\n");
            writer.write("\"MessageID\":\"" + messageID + "\",\n");
            writer.write("\"Recipient\":\"" + recipient + "\",\n");
            writer.write("\"Message\":\"" + message + "\"\n");
            writer.write("}\n");

            writer.close();

            System.out.println("Message stored in JSON file.");

        } catch (IOException e) {

            System.out.println("Error writing to JSON file.");
        }
    }

    // Return total messages
    public int returnTotalMessages() {

        return messageNumber;
    }

    // Getter for Message ID
    public String getMessageID() {

        return messageID;
    }
}


