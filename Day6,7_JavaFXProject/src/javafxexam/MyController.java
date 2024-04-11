package javafxexam;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

// 이 class는 FXML파일에 대한 Event 처리를 하는 코드가 담긴 class
// 그래서 일반적인 형태의 class가 아니라
// 특별한 interface를 반드시 구현해야 함

//fxml에 설정 잡아주면 자동적으로 호출, new해서 객체만들기 X
public class MyController implements Initializable {
	
	@FXML	//fxml에서 필드명과 똑같은 id 찾아서 맵핑
	private Button firstBtn;
	
	@FXML
	private Button secondBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 여기에 event 처리코드가 나옴
		// 이 객체가 생성되면 자동으로 initialize()가 호출됨
		System.out.println("Controller 객체가 생성되었어요!");
		
		// 이벤트 처리코드 작성
		// 버튼 클릭 됐을 때 어떤 일 할지 지정
		// 버튼에 대한 reference가 있어야 함
		firstBtn.setOnAction(e -> {
			System.out.println("첫번째 버튼이 클릭클릭!!");
		});
		
		secondBtn.setOnAction(e -> {
			System.out.println("두번째 버튼이 클릭클릭!!");
		});
	}
}
