package echosystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EchoClient extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("client.fxml"));
		try {
			root = loader.load();
		} catch (Exception e) {
		
		}
				
		// 이런 Pane을 가지고 Scene을 생성
		Scene scene = new Scene(root);
			
		// 이 Scene을 Stage에 부착
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
