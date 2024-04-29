package comment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.BoardVO;
import comment.dao.CommentDAO;
import comment.vo.CommentVO;
import mybatis.MyBatisConnectionFactory;

public class CommentService {
	// 댓글쓰기
	public List<CommentVO> writeComment(CommentVO vo){
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<CommentVO> result = null;
		try {
			// 트랜잭션 시작
			CommentDAO dao = new CommentDAO(session);
			int count = dao.insertComment(vo);
			result = dao.selectComments(vo);
			
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close(); // 트랜잭션 종료
		}
		return result;
	}
	
	// 댓글 목록 가져오기
	public List<CommentVO> showComments(CommentVO vo) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<CommentVO> result = null;
		try {
			// 트랜잭션 시작
			CommentDAO dao = new CommentDAO(session);
			result = dao.selectComments(vo);
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close(); // 트랜잭션 종료
		}
		return result;
	}
	
	// 편집
	public int editComment(CommentVO vo) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int count = 0;
		try {
			// 트랜잭션 시작
			CommentDAO dao = new CommentDAO(session);
			count = dao.updateComment(vo);
			//System.out.println("service: "+vo);
			//System.out.println("service count: "+count);
			
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close(); // 트랜잭션 종료
		}
		return count;
	}
	
	// 댓글 삭제
	public int deleteComment(CommentVO vo) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int count=0;
		try {
			// 트랜잭션 시작
			CommentDAO dao = new CommentDAO(session);
			count = dao.deleteComment(vo);
			
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
