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
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			
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
