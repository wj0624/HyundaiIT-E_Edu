package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

class MyRunnable implements Runnable {
	
	private Socket s;
	private BufferedReader br;
	private PrintWriter pw;
	
	public MyRunnable(Socket s) {
		this.s = s;
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());
		} catch (Exception e) {

		}
	}

	@Override
	public void run() {
		//서버쪽 socket이 동작하는 방식 여기에 작성
		//클라이언트가 메시지 주는 걸 기다렸다가
		//메시지 주면 바로 다시 클라이언트에게 전달하는 작업 반복
		String msg = null;
		while(true) {

			try {
				msg = br.readLine();
			} catch (Exception e) {
				
			}
			pw.println(msg); //받았으니 돌려주기
			pw.flush();
		}
	}
}

public class EchoServerController implements Initializable {
	@FXML private Button startBtn;
	@FXML private TextArea messageBox;
	
	private void printMsg(String msg) {
		Platform.runLater(() -> {
				messageBox.appendText(msg + "\n");
		});
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 화면 이벤트에 대한 처리 코드 작성
		// 이벤트 등록
		startBtn.setOnAction(e->{
			//버튼 클릭되면 처리해야 하는 코드 여기에 넣기
			
			
			//아래처럼 사용하면 바로바로 실행이 되지 않기 때문에 별도의 스레드를 만들어서 출력해주어야함
			//printMsg 함수로 구현
			//messageBox.appendText("서버가 시작 되었어요" + "\n");
			
			//서버를 가동시키는 코드
			//serverSocekt을 생성 
			//리소스 사용하는 코드들은 사용했던 자원 반납 필요
			//로컬로 잡을지 필드로 잡을지 고민
			try {
				ServerSocket server = new ServerSocket(4444);
				// server.accept()에 의해서 thread가 block됨
				// 지금같은 경우 화면 UI Thread가 block 되어 화면사용 불가
				// 별도의 Thread로 만들어서 사용해야 함
				(new Thread(()->{
					try {
						printMsg("서버가 시작되었어요!");
						
						while(true) {							
							Socket s = server.accept();	//이 accept가 반복적으로 실행 돼야 함
							// 클라이어트가 접속해서 만들어진 socket을 이용해서
							// 통신처리를 담당하는 Thread를 만들어서 실행해야 됨
							MyRunnable r = new MyRunnable(s); //소켓을 들고가야 통신 가능
							Thread t = new Thread(r);
							t.start();
							//client가 접속할 때마다 thread 생성
						}
					}catch (Exception e2) {
					}
				})).start();
				
			} catch (Exception e1) {

			}
		});
	}
	
	
	
}
