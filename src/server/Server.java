package server;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        int port = 3000; // Port number for the server

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                // Wait for client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Get input and output streams
                DataInputStream inFromClient = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

                // Receive request from client
                String clientMessage = inFromClient.readUTF();
                System.out.println("Received from client: " + clientMessage);

                // Process request and send response
                String serverResponse = "Hello from server!";
                outToClient.writeUTF(serverResponse);

                clientSocket.close(); // Close the connection with the current client
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
