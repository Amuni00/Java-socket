import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        String hostname = "localhost"; // Replace with the server's hostname or IP address
        int port = 3000; // Server's port number

        try (Socket socket = new Socket(hostname, port);
             DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
             DataInputStream inFromServer = new DataInputStream(socket.getInputStream())) {

            // Send request to server
            String request = "Hello from client!";
            outToServer.writeUTF(request);

            // Receive response from server
            String response = inFromServer.readUTF();

            // Display response
            System.out.println("Server says: " + response);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}