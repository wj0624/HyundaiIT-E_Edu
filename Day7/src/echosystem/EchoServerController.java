package echosystem;

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

public class EchoServerController implements Initializable {
	
	@FXML
	private TextArea textArea;
	@FXML
	private Button startBtn;
	
	private void printMsg(String msg) {
		Platform.runLater(()-> {
			textArea.appendText(msg+"\n");
		});
	}
	
	class ClientHandler implements Runnable {
		private Socket s;
		
		public ClientHandler(Socket s) {
			this.s = s;
		}
		
		@Override
		public void run() {
			try {
				
				
				while(true) {
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					PrintWriter out = new PrintWriter(s.getOutputStream());
						
					String msg = br.readLine();
					printMsg(msg);
					out.println(msg);
					out.flush();
				}
				
			} catch (Exception ex) {
				
			}

		}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		startBtn.setOnAction(e-> {
			try{
				ServerSocket serverSocket = new ServerSocket(5555);
				printMsg("서버 시작! 포트 : 5555");

				while(true) {
					Socket s = serverSocket.accept();	//일단 대기(클라이언트가 접속할 때까지) blocking
					printMsg("새로운 클라이언트 접속");
					
					ClientHandler r = new ClientHandler(s);
					Thread serverThread = new Thread(r);
					serverThread.start();
				}
				
			} catch (Exception e1) {
				// TODO: handle exception
			}
			
			
		});
	}
}
