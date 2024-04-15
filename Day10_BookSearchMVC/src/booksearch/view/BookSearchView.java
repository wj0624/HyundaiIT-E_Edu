package booksearch.view;
//package 분리

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookSearchView extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("JavaFXBookSearchTableView.fxml"));
		try {
			root = loader.load();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}