package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.BookDAO;
import mybatis.MyBatisConnectionFactory;
import vo.BookVO;

// transaction 생각하기
public class BookService {
	public List<BookVO> getBooksByKeyword(BookVO book) {
		// 로직처리와 DB처리
		// DB처리는 DAO한테 위임
		// transaction 때문에 SqlSession객체 DAO에게 injection해서 사용
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		List<BookVO> result = null;
		
		// DAO를 이용해 DB처리
		// transaction도 여기서 처리
		// commit, rollback 처리를 service에서 해야 함
		try {
			// 트랜잭션 시작
			BookDAO dao = new BookDAO(session);
			result = dao.selectByTitlenPrice(book);
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close(); // 트랜잭션 종료
		}
		
		return result;
	}
	
}
