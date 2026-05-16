/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MessageTest;

import Message.Message;

/**
 *
 * @author User
 */
public class MessageTest {
   
public void testCheckMessageLength() {

Message msg = new Message(
"+27718693002",
"Hi Mike, can you join us for dinner tonight?",
0
);

assertEquals(
"Message ready to send.",
msg.checkMessageLength()
);
}


public void testRecipientNumberSuccess() {

Message msg = new Message(
"+27718693002",
"Hello",
0
);

assertEquals(
"Cell phone number successfully captured.",
msg.checkRecipientCell()
);
}


public void testMessageID() {

Message msg = new Message(
"+27718693002",
"Hello",
0
);

assertTrue(msg.checkMessageID());
}

public void testMessageHash() {

Message msg = new Message(
"+27718693002",
"Hi Mike, can you join us for dinner tonight?",
0
);

String hash = msg.createMessageHash();

assertTrue(hash.contains(":0:"));
}


public void testSentMessage() {

Message msg = new Message(
"+27718693002",
"Hello",
0
);

assertEquals(
"Message successfully sent.",
msg.sentMessage(1)
);
}

    private void assertEquals(String message_ready_to_send, String checkMessageLength) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertTrue(boolean checkMessageID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

