package booksearch.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookSearchView extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 초기화
		// FXML을 가져다가 화면 구성을 할 것
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("JavaFXBookSearchTableView.fxml"));
		
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
