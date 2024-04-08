package javafxexam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class JavaFXExample extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성
		
		// 1.Pane이라고 표현되는 layout을 만들어야 함
		// 여러 종류의 Pane이 있는데 그 중 하나를 이용
		// Pane종류마다 버튼같은 component를 배치시키는 방법이 다름
		StackPane root = new StackPane();
		
		// 2.화면에 보여줄 요소를 생성
		Button btn = new Button();
		btn.setText("클릭해주세요 클릭클릭");
		//버튼이 클릭되면 무슨 일을 할지 코드로 작성
		//자바의 event model은 deligation model을 이용
		//이벤트처리를 위임한다는 의미로 delegation이라는 표현을 이용
		//버튼을 클릭하면 당연히 버튼이 event source가 됨
		//event source는 이벤트가 발생한 객체를 지칭 => 버튼이 됨
		//그런데 이벤트가 발생했을 때 이벤트의 처리(로직수행)를 event source가
		//직접 처리하지 않고 별도의 객체를 이용하게 됨 -> Listener 객체
		//당연히 해당 객체 안에는 이벤트를 처리하는 method가 있음
		//이 method를 흔히 handler라고 함
		//마지막으로 event source에 listener를 부착시키는 과정이 필요함
		//우리는 Action이라는 event를 사용
		//Action이라는 event는 마우스 클릭, 입력장치에서 enter키 입력을 지칭하는 event
		
		//버튼(event source)에서 Action Event가 발생했을 때 처리하는
		//Event Handler객체를 만들어서 이벤트 처리
		//먼저 리스너 객체 만들기
		//리스너 객체도 종류가 있음, 어떤 이벤트를 처리하느냐에 따라 종류가 다름
		
//		btn.setOnAction(new EventHandler<ActionEvent>(){
//			@Override
//			public void handle(ActionEvent arg0) {
//				System.out.println("너무 힘들어요!");
//			}
//			
//		});
		
		//위의 내용 람다식으로 표현
		btn.setOnAction((e) -> {
				System.out.println("너무 힘들어요!");
		});
		
	
		// 3.Pane위에 표현할 Component를 위치시킴
		root.getChildren().add(btn);
		
		// 4.Scene을 생성해야 함
		Scene scene = new Scene(root, 300, 250);
		
		// 5.Stage에 Scene을 설정
		primaryStage.setTitle("첫 화면이에요!");
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	

}
