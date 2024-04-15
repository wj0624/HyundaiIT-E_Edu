package booksearch.service;

import java.sql.Connection;
import java.sql.DriverManager;

import booksearch.dao.BookDAO;
import booksearch.vo.BookVO;
import javafx.collections.ObservableList;

public class BookService {
	
	static { //class가 로드되면 바로 수행되는 블록
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	// 로직처리하는 business method가 나오면 됨
	
	// transaction이에요!
	public ObservableList<BookVO> searchBookByKeyword(String keyword) {
		
		// 일반적인 로직처리 코드가 나옴
		// Database 처리도 당연히 필요
		// 그런데 Database 처리는 Service에서 직접하지 않음
		// DAO한테 위임해서 처리하고 결과만 받아 옴
		
		// 지금은 별다른 로직처리 할게 없음
		// DAO 만들어서 DB처리만 하면 됨
		String id = "root";
		String pw = "test1234";
		String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		Connection con = null;
		try {
			con = DriverManager.getConnection(JDBC_URL, id, pw);
			con.setAutoCommit(false); // transaction 시작
			// 해당 커넥션 사용하는 건 다 단일 트랜잭션으로 취급
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		BookDAO dao = new BookDAO(con);
		ObservableList<BookVO> result = dao.select(keyword);
		
		// 이후 로직처리 할게 없어서 그냥 결과 controller에게 return
		
		return result;
	}

	public ObservableList<BookVO> deleteSelectedBook(String deleteIsbn, String keyword) {
		
		// 여기서는 최소 2가지 작업을 해야 함
		// 1. 입력으로 들어온 ISBN번호로 책을 삭제 (delete)
		// 2. 삭제 후 입력으로 들어온 키워드 이용해서 책을 다시 검색 (select)
		// 3. 추가로 삭제된 책은 다른 table에 insert해서 로그로 남겨 놓기 (insert)
		
		// Transaction 처리 하기 위해서는 Service 단에서 transaction이 설정된
		// connection 객체를 생성해서 DAO에서 injection 해주어야 함
		// Connection 가져오기
		String id = "root";
		String pw = "test1234";
		String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		Connection con = null;
		try {
			con = DriverManager.getConnection(JDBC_URL, id, pw);
			con.setAutoCommit(false); // transaction 시작
			// 해당 커넥션 사용하는 건 다 단일 트랜잭션으로 취급
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		BookDAO dao = new BookDAO(con); // DI
		
		// DAO에서 한번에 SQL 여러구문 수행하지말고 한개씩 나눠서 하자
		// 한번에 SQL 여러구문 수행하는 건 Service!!
		//dao.insert(deleteIsbn);
		int count = dao.delete(deleteIsbn);
		ObservableList<BookVO> result = dao.select(keyword);
		
		// 최종 결과 확인
		// 만약 문제 없이 각 transaction의 세부 작업이 성공했으면 전체적으로 commit
		// 만약 각 작업 수행 시 문제 발생했으면 전체적으로 rollback
//		con.commit();
//		con.rollback();
//		con.close();
	
		return result;
	}
	
}
