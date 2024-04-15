package step3;

public class Main {
	
	public static void main(String[] args) {
		// 사용자 등록 코드
		UserDAO dao = new NaverUserDAO();
		User user = new User("HGD", "홍길동", "1234");
		try {
			int result = dao.insert(user);
			if(result!=1) {
				throw new Exception();
			}
			System.out.println("사용자 등록 성공!");
		} catch (Exception e) {
			System.out.println("사용자 등록 실패");
		}
		
		// 사용자 검색 코드
		try {
			User user2 = dao.select("HGD");
			System.out.println(user2.getName());
		} catch (Exception e) {
		}
		
	}
}
