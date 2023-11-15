import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Server extends Thread {
	
	int numOfClients = 0; // Tracks the number of clients currently connected to the server
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
			
			try ( ServerSocket mysocket = new ServerSocket(24567); ) {
				System.out.println("Server is waiting for a client...");
			
				while ( true ) { // This will run the Server Application
					// Create a clientThread when accept() receives a connection
					
					numOfClients++; // Set number of clients to 1, anticipating a client connection
					ClientThread client = new ClientThread(mysocket.accept(), numOfClients);
				
					// Once code reaches this line, we have established a connection with a client
					// We can store the connected client (ClientThread) in an array
					clientList.add(client);
					
					callback.accept("Client has connected to the Server: " + "Client #" + numOfClients);
					System.out.println("Client has connected to the server! Yay!");
					
				
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
		
		public void updateClients(String message) {
			// This function is used to constantly check on the Client's status
			// And also used to send messages to the client
			for(int i = 0; i < clientList.size(); i++) {
				ClientThread temp = clientList.get(i);
				try {
				 temp.out.writeObject(message);
				}
				catch(Exception e) {}
			}
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
			
			// Send a message out to all the clients
			updateClients("Server said: You are Client" + clientNumber + ". Nice to meet you!"); // This sends information to the server's output stream
			
			while ( true ) {
				// This will have to exist to keep checking if client sends anything to the server
				try {
					String temp = in.readObject().toString(); // Store the string sent from the client
					callback.accept("Client#" + clientNumber + " sent: " + temp);
					updateClients("Hey Client, Are You Still There?");
					System.out.println("Received from the client! We got: " + temp); // Server will respond on the terminal
				} catch (Exception e) {
					callback.accept("Lost Client#" + clientNumber);
					clientList.remove(this);
					System.out.println("Client#" + clientNumber + " has disconnected");
			    	break;
				}
			}
			
		}
		
	}
	
		
}