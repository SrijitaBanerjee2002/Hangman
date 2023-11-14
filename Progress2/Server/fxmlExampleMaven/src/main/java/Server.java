import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Server extends Thread {
	
	int numOfClients = 1; // Tracks the number of clients currently connected to the server
	private Consumer<Serializable> callback;
	TheServer server;
	ArrayList<ClientThread> clientList = new ArrayList<ClientThread>();
	
	Server(Consumer<Serializable> call) {
		
		callback = call;
		server = new TheServer();
		server.start();
		System.out.println("server.start() called!");
		
	}
	
	public class TheServer extends Thread {
		
		public void run() {
			// run() is needed for TheServer.start()
			
			try ( ServerSocket mysocket = new ServerSocket(5555) ) {
			
				while ( true ) { // This will run the Server Application
					// Create a clientThread when accept() receives a connection
					System.out.println("Server is waiting for a client...");
					ClientThread client = new ClientThread(mysocket.accept(), numOfClients);
					callback.accept("Client has connected to the Server: " + "Client #" + numOfClients);
					System.out.println("Client has connected to the server! Yay!");
				
					// Once code reaches this line, we have established a connection with a client
					// We can store the connected client (ClientThread) in an array
					clientList.add(client);
					numOfClients++;
				
					client.start(); // This will trigger ClientThread.run()
				}
			
			} catch ( Exception e ) {
				callback.accept("Server Socket Did Not Launch");
			}
			
		}
		  
	}
	
	
	public class ClientThread extends Thread {
		
		// This sub-class will create the profile of the client
		
		Socket connection;
		int clientNumber;
		ObjectInputStream in;
		ObjectOutputStream out;
		
		ClientThread(Socket s, int count) {
			this.connection = s;
			this.clientNumber = count;	
		}
		
		public void run() {
			
			try {
				// When Client Thread is running, initialize the stream variables
				in = new ObjectInputStream(connection.getInputStream());
				out = new ObjectOutputStream(connection.getOutputStream());
				
				// This line just ensures that there isn't any delay when sending information between client and server
				connection.setTcpNoDelay(true);
			} catch (Exception e) {
				System.out.println("Failed on the streams");
			}
			
			// Create a message out to the client
			try {
				out.writeObject("Server said: You are Client" + numOfClients + ". Nice to meet you!"); // This sends information to the server's output stream
			} catch (Exception e) {
				
			}
			
			
			while ( true ) {
				// This will have to exist to keep checking if client sends anything to the server
				try {
					String temp = in.readObject().toString(); // Store the string sent from the client
					callback.accept("Client#" + numOfClients + " sent: " + temp);
					System.out.println("Received from the client! We got: " + temp); // Server will respond on the terminal
				} catch (Exception e) {
					callback.accept("Lost Client#" + numOfClients + "...");
					clientList.remove(this);
			    	break;
				}
			}
			
		}
		
	}
	
		
}