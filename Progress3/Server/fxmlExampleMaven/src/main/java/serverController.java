import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

public class serverController implements Initializable {
	
	// Declare the variables
	Server serverConnection;
		
	@FXML
	private Button check_port;
		
	@FXML
	private Text server_port_message;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	        
	}
		
	public void run_server() {
		
		serverConnection = new Server(data -> {
			server_port_message.setText(data.toString());
		});
	
	}	
	
}
