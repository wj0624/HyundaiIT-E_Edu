package step5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO { //UserDAO 클래스를 판매한다고 생각, 재사용
	
	private ConnectionMaker connectionMaker;
	
	public UserDAO() {
		 connectionMaker = new NaverConnectionMaker();
	}	
	
	// 사용자 입력(추가)
	// throws Exception : Exception이 발생하면 호출한 곳에서 처리
	public int insert(User user) throws Exception{
		// 데이터베이스 처리해야 하니 총 6단계의 DB처리 코드 작성
		Connection con =  connectionMaker.getConnection();
		
		String sql = "insert into user values(?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		// 물음표 채우기
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		
		// select면 executeQuery(), insert & delete & update는 executeUpdate() 사용
		int result = pstmt.executeUpdate(); // return값 정수
		// 위 정수의 의미는 영향을 받은 행의 개수
		
		pstmt.close();
		con.close();
		
		return result;
	}
	
	// 사용자 검색
	public User select(String userId) throws Exception{
		Connection con = connectionMaker.getConnection();
		
		String sql = "select * from user where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		// 물음표 채우기
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery(); // return값 ResultSet
		
		User user = null;
		if(rs.next()) {
			user = new User(rs.getString("id"),
					rs.getString("name"),
					rs.getString("password"));
		}
		
		pstmt.close();
		con.close();
		
		return user;
	}
}
