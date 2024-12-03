package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client_handler implements Runnable {

	
		 private Socket clientSocket;

		    public Client_handler(Socket socket) {
		        this.clientSocket = socket;
		    }
		    public void run() {
		        try {
		            // Create input and output streams
		            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

		            // Send a welcome message to the client
		            out.println("Welcome to the server!");

		            String message;
		            
		            while ((message = in.readLine()) != null) {
		                System.out.println("Client says: " + message);
		                out.println("Server received: " + message);

		 
		                if (message.equalsIgnoreCase("exit")) {
		                    System.out.println("Client disconnected.");
		                    break;
		                }
		            }

		            in.close();
		            out.close();
		            clientSocket.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

	}
}
