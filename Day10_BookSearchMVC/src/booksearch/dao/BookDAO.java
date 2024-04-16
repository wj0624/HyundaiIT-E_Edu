package booksearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import booksearch.vo.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class BookDAO {
	
	private Connection con;
	
	public BookDAO() {
		// DAO 는 간단한 sql 만 적어놓는 것
		// 로직은 그 간단한 것들을 사용해서 복잡한 로직을 만드는 건 controller 에서 하는 것
		// 그러니까 메서드 이름도 sql 문처럼 select, delete, insert 이렇게 간단히 쓰는 것
			
		// 1. Driver Loading
		// 2. Connection 획득
		// 3. Statement 생성 (SQL Query 작성)
		// 4. 실행 후 결과 가져오기
		// 5. 결과 처리
		// 6. 자원 반납 (close 처리)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String id = "root";
			String pw = "test1234";
			String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			con = DriverManager.getConnection(JDBC_URL, id, pw);
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
	
	// 책 검색 메서드
	public ObservableList<BookVO> select(String keyword) {
		ObservableList<BookVO> data = null;
		String sql = "SELECT bisbn, btitle, bprice, bauthor FROM book WHERE btitle LIKE ?";
		try {
			// 거의 예외없이 preparedStatement 사용함
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			//실행
			ResultSet rs = pstmt.executeQuery();
			//결과처리
			data = FXCollections.observableArrayList();
			while (rs.next()) {
				BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getInt("bprice"), rs.getString("bauthor"));
				data.add(book);
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return data;
	}
	
	public void delete(TableView<BookVO> tableView) {
		// 선택된 테이블 셀의 데이터 가져오기
		BookVO selectedBook = tableView.getSelectionModel().getSelectedItem();
	    if (selectedBook != null) {
	    	// 선택된 책 데이터 삭제
	        String sql = "DELETE FROM book WHERE bisbn = ?";
		    try {
		        PreparedStatement pstmt = con.prepareStatement(sql);
		        pstmt.setString(1, selectedBook.getBisbn());
		        pstmt.executeUpdate();
		    } catch (Exception ex) {
		    	System.err.println(ex);
		    }
	        // 테이블 뷰에서 선택된 행 제거
	        tableView.getItems().remove(selectedBook);
	    }
	}
}
