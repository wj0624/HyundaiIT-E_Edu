package dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import vo.BookVO;

public class BookDAO {
	
	private SqlSession session;
	
	public BookDAO() {
	}

	// 생성자 주입 (Constructor Injection)
	public BookDAO(SqlSession session) {
		super();
		this.session = session;
	}
	
	// 검색
	public List<BookVO> selectByTitlenPrice(BookVO vo) throws Exception{
		List<BookVO> result = null;
		result = session.selectList("mybook.selectByTitlenPrice", vo);
		return result;
	}
	
}
