package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;
import comment.vo.CommentVO;

public class CommentDAO {
	private SqlSession session;
	
	public CommentDAO() {
	}
	
	public CommentDAO(SqlSession session) {
		super();
		this.session = session;
	}
	
	public int insertComment(CommentVO vo) throws Exception {
		int result = 0;
		result = session.update("mywebsite.insertComment", vo);
		return result;
	}
	
	public List<CommentVO> selectComments(CommentVO vo) throws Exception {
		List<CommentVO> result = session.selectList("mywebsite.selectComments", vo);
		return result;
	}
	
	public int updateComment(CommentVO vo) {
		int result = 0;
		result = session.update("mywebsite.updateComment", vo);
		//System.out.println("dao: "+vo);
		//System.out.println("dao count: "+result);
		return result;
	}
	
	public int deleteComment(CommentVO vo) {
		int result = 0;
		result = session.update("mywebsite.deleteComment", vo);
		return result;
	}
}
