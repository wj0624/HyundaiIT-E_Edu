package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;

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

	public BoardVO selectOneArticle(BoardVO vo) {
		BoardVO result = session.selectOne("mywebsite.selectOneArticle", vo);
		return result;
	}

	public int updateArticle(BoardVO vo) {
		int result = 0;
		result = session.update("mywebsite.updateArticle", vo);
		return result;
	}

	public int deleteArticle(BoardVO vo) {
		int result = 0;
		result = session.update("mywebsite.deleteArticle", vo);
		return result;
	}
}
