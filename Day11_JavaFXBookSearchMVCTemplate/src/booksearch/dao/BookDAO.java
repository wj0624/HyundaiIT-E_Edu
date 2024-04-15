package booksearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import booksearch.vo.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// 1. Driver Loading
// 2. Connection 획득
// 3. Statement 생성(SQL Query 작성)
// 4. 실행 후 결과 가져오기
// 5. 결과 처리
// 6. 자원 반납(close처리)

public class BookDAO {
	
	private Connection con;
	
	// constructor injection(생성자 주입)
	public BookDAO(Connection con) {
		this.con = con;
	}

	public ObservableList<BookVO> select(String keyword) {
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ObservableList<BookVO> result = FXCollections.observableArrayList();
		
		try {
			// 이 connection을 얻어오는 작업은 상당히 load를 많이 잡아먹음
			
			// 거의 예외없이 PreparedStatement를 이용함
			// PreparedStatement는 SQL을 가지고 statement를 생성하는 것을 말함
			// ?를 이용해서 나중에 입력될 파라미터 지정해줄 수 있음
			String sql = "select bisbn, btitle, bprice, bauthor from book where btitle like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%"); //물음표에 들어갈 것
			
			// 실행
			rs = pstmt.executeQuery();
			
			// 결과처리
			while(rs.next()) {
				BookVO book = new BookVO(rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getInt("bprice"),
						rs.getString("bauthor"));
				result.add(book);
			}
		} catch (Exception e){
			System.out.println(e);
		} finally { // 예외가 있던 없던 resource 반납
			// 자원반납
			try {
				rs.close();
				pstmt.close();
				//con.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
		return result;
	}

//	public void insert(String deleteIsbn) {
//		
//	}

	public int delete(String deleteIsbn) {
		// Connection 가져오기
//		String id = "root";
//		String pw = "test1234";
//		String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
//		Connection con = null;
		PreparedStatement pstmt = null;
		
		int count = 0;
		
		try {
//			con = DriverManager.getConnection(JDBC_URL, id, pw);
			// 하나의 transaction이 시작
			
			con.setAutoCommit(false); // 여기부터 transaction이 시작
			
			con.commit(); // transaction이 정상처리 되었고 DB에 적용하세요
			con.rollback(); // transaction 수행 중 이상현상 발생해서 지금까지 한 작업 무시
			
			String sql = "delete from book where bisbn = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deleteIsbn); //물음표에 들어갈 것
			
			// 실행
			count = pstmt.executeUpdate();			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally { // 예외가 있던 없던 resource 반납
			// 자원반납
			try {
				pstmt.close();
				//con.close();
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
		return count;
	}
	
	// database처리하는 단일 SQL이 나오게 됨
	// 단순한 SQL 구문 모아서 로직처리는 Service에서
}
