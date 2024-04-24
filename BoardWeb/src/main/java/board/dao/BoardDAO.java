package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;
import member.vo.MemberVO;

public class BoardDAO {
	private SqlSession session;
	
	public BoardDAO() {
	}
	
	public BoardDAO(SqlSession session) {
		super();
		this.session = session;
	}
	
	public int insertArticle(BoardVO vo) throws Exception{
		int result = 0;
		result = session.update("mywebsite.insertArticle", vo);
		return result;
	}
	
	public List<BoardVO> selectArticles() throws Exception{
		List<BoardVO> result = session.selectList("mywebsite.selectArticles");
		return result;
	}
}
