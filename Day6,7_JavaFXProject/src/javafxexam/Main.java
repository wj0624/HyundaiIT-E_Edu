package javafxexam;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application { //기본 화면창을 띄워주는 class
	
	Button btn;
	@Override
	public void start(Stage primaryStage) throws Exception {
		//여기부터 시작, 화면구성하기
		//FXML 이용하는게 아닌 코드로 화면 구성
		//1. Pane이 필요, 이번에는 BorderPane 이용
		//Boarderpane은 화면을 5개(동서남북중앙)의 영역으로 분할
		//method를 통해서 UI의 위치를 지정
		BorderPane root = new BorderPane();
		root.setPrefSize(300, 300);
			
		//2. 이 pane에 필요한 UI 요소들(ex 버튼)을 생성해서 배치
		btn = new Button("새로운 창을 띄워보아요!");
		btn.setPrefSize(300, 50);
		btn.setOnAction(e -> {
			//버튼을 누르면 새 창 띄우기
			//Stage 객체를 만들어서 show하면 새 창이 뜸
			//나중에 구현
			MyStage stage = new MyStage();
			stage.show();
		});
		root.setBottom(btn);	//버튼을 화면 아래에 붙임
		
		//3. 이렇게 만든 Pane을 이용해 Scene을 생성
		Scene scene = new Scene(root);
		
		//4. Stage에 Scene을 부착
		primaryStage.setScene(scene);
		
		//5. Stage를 show
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
