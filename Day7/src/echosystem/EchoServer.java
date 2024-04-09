package echosystem;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EchoServer extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 당연히 여기에도 Pane이 있어야 함
		// Pane안에 여러개의 UI Component를 배치
		// 이건 FXML에서 가져올 것
		// Parent : 임시로 사용하는 Pane
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("server.fxml"));
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
