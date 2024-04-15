package booksearch.service;

import booksearch.dao.BookDAO;
import booksearch.vo.BookVO;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class BookSearchService {
	// 로직 처리 객체
	// 로직 처리를 위한 메서드만 들어있는 것
	// controller 가 얘한테 시켜서 일을 하는 것
	public ObservableList<BookVO> searchBookByKeyword(String keyword) {
		// 이 안에서 일반 로직을 처리하면 됨
		// service model 쪽이니까 여기서 DB 처리를 하면 안 됨
		// 만약 Database 처리를 하게 되면 DAO 를 만들어서 사용해야 함
		// 여기가 database layer 가 아니니까 DB 처리로 DB 데이터를 가져오려면 DAO 만들어야 함
		// 이제 DAO 만들러 감
		BookDAO dao = new BookDAO();
		// DB 처리 SELECT 하는 건 DAO 객체가 해야 함
		ObservableList<BookVO> result = dao.select(keyword);
		// DAO 는 메서드 같이 이름을 지으면 안 됨. DAO 는 단일 처리만 하기 때문
		return result;
	}
	
	public void deleteSelectedBook(TableView<BookVO> tableView) {
		BookDAO dao = new BookDAO();
		dao.delete(tableView);
	}
}
