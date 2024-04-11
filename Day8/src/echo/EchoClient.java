package echo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EchoClient extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("echoClient.fxml"));
		try {
			root = loader.load();
		} catch (Exception e) {
			System.err.println(e);
		}
				
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
