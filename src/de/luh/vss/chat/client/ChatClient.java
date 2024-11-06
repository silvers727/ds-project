package de.luh.vss.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import de.luh.vss.chat.common.*;
import de.luh.vss.chat.common.User.UserId;


public class ChatClient {

	public static void main(String... args) {
		try {
			new ChatClient().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() throws IOException {
		System.out.println("Congratulation for successfully setting up your environment for Assignment 1!");
		System.out.println("TEST 1!");
		
		// TEST 1
		// My pin
		int pin = 8803;
		UserId userId = new UserId(pin);
		
		
		// Define server address and port
        String serverAddress = "130.75.202.197";
        int serverPort = 4444;
		
        // Connect to the server
        Socket socket = new Socket(serverAddress, serverPort);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		DataInputStream in = new DataInputStream(socket.getInputStream());
		Message.RegisterRequest registerRequest = new Message.RegisterRequest(userId, InetAddress.getByName(serverAddress), 4444);
		registerRequest.toStream(out);
		Message.ChatMessage chatMessage = new Message.ChatMessage(userId, "TEST 1 USER ID CORRECTNESS");
		chatMessage.toStream(out);
		// TEST 2
		System.out.println("TEST 2!");
		chatMessage = new Message.ChatMessage(userId, "TEST 2 OUT OF BAND PROTOCOL MESSAGE");
		chatMessage.toStream(out);
	}

}
