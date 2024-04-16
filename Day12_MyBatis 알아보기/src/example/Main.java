package example;

import org.apache.ibatis.session.SqlSessionFactory;

import example.dao.BookDAO;
import example.mybatis.MyBatisConnectionFactory;
import example.vo.BookVO;

public class Main {

	public static void main(String[] args) {
		
		// 바로 데이터베이스 처리 하기
		// DAO 있어야 데이터베이스 처리
		// DAO를 만드려면 SqlSessionFactory를 먼저 확보해서 주입해야함
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		
		BookDAO dao = new BookDAO(factory);
		
		// 1. ISBN번호를 이용해서 책 1권의 정보를 HashMap으로 변환해서 가져오기
//		HashMap<String, Object> result = 
//				dao.selectByISBNHashMap("89-7914-206-4");
//		
//		for(String key : result.keySet()) {
//			System.out.println(key+" : "+result.get(key));
//		}
		
		// 2. 모든 책에 대한 정보를 HashMap으로 변환해서 가져오기
//		List<HashMap<String, Object>> result = 
//				dao.selectAllHashMap();
//		
//		for(HashMap<String, Object> map : result) {
//			for(String key : map.keySet()) {
//				System.out.println(key+" : "+map.get(key));
//			}
//			System.out.println();
//		}
		
		// 3. ISBN번호를 이용해서 책 1권의 정보를 BookVO로 변환해서 가벼오기
//		BookVO result = 
//				dao.selectByISBNBookVO("89-7914-206-4");
//		
//		System.out.println(result); //BookVO 안에 ToString오버라이딩 돼있으므로 그냥 출력
		
		// 4. ISBN번호를 이용해서 책 1권의 정보를 BookVO로 변환해서 가져오기
		//	  그런데 table의 column명이 VO의 field명과 다른 경우에 어떻게 할까?
//		BookVO result = 
//				dao.selectByISBNBookVO("89-7914-206-4");
//		
//		System.out.println(result);
		
		// 5. ISBN번호를 이용해서 책 1권의 정보를 변경하기
		//	  책의 제목 바꾸기, 어떻게 할까?
		BookVO booKVO = 
				new BookVO("89-7914-206-4", "소리없는 아우성!!!!!", 0, null);
		int result = dao.titleUpdate(booKVO);
		System.out.println("영향을 받은 행의 개수는 : "+result);
	}

}
