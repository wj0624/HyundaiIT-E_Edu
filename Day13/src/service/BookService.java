package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.BookDAO;
import mybatis.MyBatisConnectionFactory;
import vo.BookVO;

public class BookService {
	
	
	// 로직처리하는 business method
	
	// 1. 검색
	public List<BookVO> searchBookByKeyword(String keyword) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		List<BookVO> result = null;
		try {
			// 트랜잭션 시작
			SqlSession session = factory.openSession();
			session.getConnection().setAutoCommit(false);
			BookDAO dao = new BookDAO(session);
		
			try {
				result = dao.selectByTitle(keyword);
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				session.close(); // 트랜잭션 종료
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	// 2. 삭제
	public List<BookVO> deleteSelectedBook(String deleteIsbn, String keyword) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		List<BookVO> result = null;
		
		try {
			// 트랜잭션 시작
			SqlSession session = factory.openSession();
			session.getConnection().setAutoCommit(false);
			BookDAO dao = new BookDAO(session);
			
			try {
				int count = dao.deleteByISBN(deleteIsbn);
				result = dao.selectByTitle(keyword);
			} catch (Exception e) {
				System.out.println(e);
				session.rollback();
			} finally {
				session.commit();
				session.close(); //트랜젝션 종료
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return result;
	}
	
	// 3. 수정
	public List<BookVO> updateSelectedBook(BookVO book, String keyword) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		BookVO bookVO = new BookVO(book.getBisbn(), book.getBtitle(), 0, null);
		
		List<BookVO> result = null;
		
		try {
			// 트랜잭션 시작
			SqlSession session = factory.openSession();
			session.getConnection().setAutoCommit(false);
			BookDAO dao = new BookDAO(session);
			try {
				int count = dao.titleUpdate(bookVO);
				result = dao.selectByTitle(keyword);
				
			} catch (Exception e) {
				
				System.out.println(e);
				session.rollback();
			} finally {
				
				session.commit();
				session.close(); //트랜젝션 종료
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
}
