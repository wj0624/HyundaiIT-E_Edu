package echo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EchoServer extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성
		// 이미 Scene Builder를 이용해 화면 구성에 대한 FXML 파일을 만들어놓음
		// 해당 파일을 이용해 Pane을 가져와서 Scene을 만들고 Stage에 붙여서 사용
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("echoServer.fxml"));
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
