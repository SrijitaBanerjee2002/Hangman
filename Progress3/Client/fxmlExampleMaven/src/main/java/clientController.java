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

public class clientController implements Initializable {
	
	// Declare the variables
	Client clientConnection;
	
	@FXML
	private Text client_port_title;
	
	@FXML
	private Text temp_feedback;
	
	@FXML
	private TextField insert_port;
	
	@FXML
	private Button check_port;

	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	public void run_client() {
		
		clientConnection = new Client( data-> {
			
			temp_feedback.setText(data.toString());
			
		});
		
	}
	
}
