import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		 try {
			 // Read file FXML and draw interface.
	         Parent root = FXMLLoader.load(getClass().getResource("/FXML/serverFXML.fxml"));
	         primaryStage.setTitle("Server Control");
             Scene s1 = new Scene(root, 500,500);
             s1.getStylesheets().add("/styles/serverStyle.css");
             primaryStage.setScene(s1);
             primaryStage.show();
	         
	        } catch(Exception e) { 
	            e.printStackTrace();
	            System.exit(1);
	        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}