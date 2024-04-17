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
	public List<BookVO> selectByTitle(String btitle) throws Exception{
		List<BookVO> result = null;
		result = session.selectList("mybook.selectByTitle", btitle);
		return result;
	}
	
	// 삭제
	public int deleteByISBN(String bisbn) throws Exception{
		
		int result = 0;
		result = session.update("mybook.deleteByISBN", bisbn);
		return result;
	}
	
	// 수정
	public int titleUpdate(BookVO bookVO) throws Exception {
		
		int result = 0;
		result = session.update("mybook.titleUpdate", bookVO);
		return result;
	}

}
