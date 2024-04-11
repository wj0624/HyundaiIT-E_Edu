package practice;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BookSearchController implements Initializable	 {
	
	@FXML private TextField textField;
	@FXML private TextArea textArea;
	@FXML private Button searchBtn;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private void printMsg(String msg) {
		Platform.runLater(() -> {
				textArea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String myId = "root";
			String myPw = "test1234";

			String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			con = DriverManager.getConnection(JDBC_URL, myId, myPw);

			
		} catch (Exception e) {
			System.out.println("뭔가 잘못 되었어요!");
		}
		
		searchBtn.setOnAction(e->{
			textArea.setText("");
			String title = textField.getText();
			String sql = "select * from book where btitle like '%"+title+"%'";
			textField.setText("");

			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					//rs.next();
					String author = rs.getString("btitle");
					printMsg(author);
				}
				
			} catch (Exception e1) {

			}
			
		});
		
		try {
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e1) {

		}
		
	}
}
