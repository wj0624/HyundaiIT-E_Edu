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
import javafx.scene.control.TextField;

public class EchoClientController implements Initializable {
	@FXML
	private TextArea textArea;
	@FXML
	private TextField textField;
	@FXML
	private TextField ID;
	@FXML
	private Button sendBtn;
	@FXML
	private Button stopBtn;
	
	private void printMsg(String msg) {
		Platform.runLater(()-> {
			textArea.appendText(msg+"\n");
		});
	}
	
	class MyClientRunnable implements Runnable {
		boolean stopped = false;
		@Override
		public void run() {
				try {
					Socket s = new Socket("localhost", 5555);
					printMsg("접속 성공");
					
					while(!stopped) {
						BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
						PrintWriter out = new PrintWriter(s.getOutputStream());
						sendBtn.setOnAction(e-> {
							String msg = ID.getText() + " : " + textField.getText();
							out.println(msg);
							out.flush();
							
							try {
								msg = br.readLine();
								printMsg(msg);
							} catch (Exception e1) {
							}
							textField.setText("");
						});
					}
				}
				catch (Exception ex) {
				}
		}
		
		public void stop() {
			stopped = true;
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MyClientRunnable r = new MyClientRunnable();
		Thread clientThread = new Thread(r);
		clientThread.start();
		
		stopBtn.setOnAction(e -> {
			r.stop();
		});

	}

}
