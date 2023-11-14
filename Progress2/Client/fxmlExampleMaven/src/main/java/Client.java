import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class Client {
	
	// Create the variables
	TheClient client;
	Socket socketClient;
	ObjectOutputStream out;
	ObjectInputStream in;
	private Consumer<Serializable> callback;
	
	Client(Consumer<Serializable> call) {
		
		callback = call;
		
		client = new TheClient();
		client.start();
		
	}
	
	public class TheClient extends Thread {
		
		public void run() {
			
			try {
				socketClient= new Socket("127.0.0.1", 5555); // This is how a client socket should be declared
				
			    out = new ObjectOutputStream(socketClient.getOutputStream());
			    in = new ObjectInputStream(socketClient.getInputStream());
			    socketClient.setTcpNoDelay(true);
			}
			catch(Exception e) {}
			
			while(true) {
				try {
					String message = in.readObject().toString();
					callback.accept(message);
				}
					catch(Exception e) {}
			}
		
	    }
		
	}

}
