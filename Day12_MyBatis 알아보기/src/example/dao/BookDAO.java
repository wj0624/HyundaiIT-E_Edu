package example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.vo.BookVO;

public class BookDAO {

	// 여기에서 sqlSessionFactory를 직접 얻어내지 않음
	// 생성자를 통해서 주입받아서 사용
	private SqlSessionFactory sqlSessionFactory;
	
	public BookDAO() {
		// TODO Auto-generated constructor stub
	}

	// 생성자 주입 (Constructor Injection)
	public BookDAO(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	// 1. ISBN번호를 입력으로 받아서 책 1권의 데이터를 HashMap으로 만들어서 
	// 리턴하는 메소드를 작성
	public HashMap<String, Object> selectByISBNHashMap(String bisbn) {
		HashMap<String, Object> result = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			//해시맵 한개만 갖고 오기
			result = session.selectOne("example.mybook.selectByISBNHashMap", bisbn);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close(); //자원 반납
		}
		
		return result;
	}
	
	// 2. 모든 책의 데이터를 HashMap의 리스트로 만들어서 리턴하는 메소드를 작성
	public List<HashMap<String, Object>> selectAllHashMap() {
		List<HashMap<String, Object>> result = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			//해시맵 리스트 갖고 오기
			result = session.selectList("example.mybook.selectAllHashMap"); 
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close(); //자원 반납
		}
		
		return result;
	}
	
	// 3. ISBN번호를 입력으로 받아서 책 1권의 데이터를 BookVO으로 만들어서 
	// 리턴하는 메소드를 작성
	public BookVO selectByISBNBookVO(String bisbn) {
		BookVO result = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			//해시맵 한개만 갖고 오기
			result = session.selectOne("example.mybook.selectByISBNBookVO", bisbn);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close(); //자원 반납
		}
		
		return result;
	}
	
	// 4. ISBN번호를 이용해서 책 1권의 정보를 BookVO로 변환해서 가져오기
	//	  그런데 table의 column명이 VO의 field명과 다른 경우에 어떻게 할까?
	public BookVO selectByISBNResultMap(String bisbn) {
		BookVO result = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			//해시맵 한개만 갖고 오기
			result = session.selectOne("example.mybook.selectByISBNResultMap", bisbn);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close(); //자원 반납
		}
		
		return result;
	}
	
	// 5. ISBN번호를 이용해서 책 1권의 정보를 변경하기
	//	  책의 제목 바꾸기, 어떻게 할까?
	public int titleUpdate(BookVO bookVO) {
		
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			result = session.update("example.mybook.titleUpdate", bookVO);
		} catch (Exception e) {
			System.out.println(e);
			// catch문에서는 오류발생했으니 rollback 해줘야 함
		} finally {
			session.commit(); // update 계열은 반드시 처리해야함!!
			session.close();
		}
		
		// 제대로 처리 됐으면 1 리턴
		return result;
	}
}
