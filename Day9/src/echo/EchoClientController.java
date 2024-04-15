package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
	@FXML private TextField userID;
	@FXML private TextField userMsg;
	@FXML private Button sendMsg;
	@FXML private Button closeBtn;
	@FXML private TextArea messageBox;
	
	private Socket s;
	//스트림 통롶
	private BufferedReader br;
	private PrintWriter pw;
	String recieveMsg = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//서버접속하는 코드가 나오면 됨
		try {
			Socket s = new Socket("localhost", 4444);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());
			
		} catch (Exception e) {
		} 
		
		sendMsg.setOnAction(e->{
			String msg = userID.getText() + " > " + userMsg.getText();
			pw.println(msg);
			pw.flush();
			
			try {
				recieveMsg = br.readLine(); //blocking method
			} catch (Exception e1) {
			}
			
			Platform.runLater(()->{
				messageBox.appendText(recieveMsg+"\n");
			});
			
			userMsg.setText("");
		});
	}

}
