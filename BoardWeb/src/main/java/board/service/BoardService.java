package board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.dao.BoardDAO;
import board.vo.BoardVO;
import mybatis.MyBatisConnectionFactory;

public class BoardService {
	// 글쓰기
	public List<BoardVO> writeArticle(BoardVO vo) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<BoardVO> result = null;
		try {
			// 트랜잭션 시작
			BoardDAO dao = new BoardDAO(session);
			int count = dao.insertArticle(vo);
			result = dao.selectArticles();
			
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close(); // 트랜잭션 종료
		}
		return result;
	}
	
	// 글 목록 가져오기
	public List<BoardVO> showArticles() {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<BoardVO> result = null;
		try {
			// 트랜잭션 시작
			BoardDAO dao = new BoardDAO(session);
			result = dao.selectArticles();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close(); // 트랜잭션 종료
		}
		return result;
	}
	
	// 게시글에 대한 세부사항 확인
	public BoardVO viewDetail(BoardVO vo) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		BoardVO result = null;
		try {
			// 트랜잭션 시작
			BoardDAO dao = new BoardDAO(session);
			result = dao.selectOneArticle(vo);
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close(); // 트랜잭션 종료
		}
		return result;
	}
	
	// 편집
	public BoardVO editArticle(BoardVO vo) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		BoardVO result = null;
		try {
			// 트랜잭션 시작
			BoardDAO dao = new BoardDAO(session);
			int count = dao.updateArticle(vo);
			result = dao.selectOneArticle(vo);
			
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close(); // 트랜잭션 종료
		}
		return result;
	}

	public int deleteArticle(BoardVO vo) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int count=0;
		try {
			// 트랜잭션 시작
			BoardDAO dao = new BoardDAO(session);
			count = dao.deleteArticle(vo);
			
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close(); // 트랜잭션 종료
		}
		return count;
	}
}
