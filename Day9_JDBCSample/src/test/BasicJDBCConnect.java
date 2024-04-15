package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 0. DBMS가 제공하는 JDBC Driver class를 사용할 수 있어야 함
// 	  그러면 해당 class를 다운로드 받아서 이걸 우리 프로젝트의 build path에 포함
public class BasicJDBCConnect {
	
	public static void main(String[] args) {
		
		try {
			// 1. MySQL에 연결
			//	  MySQL에 연결하기 위한 JDBC Driver를 프로그램 안으로 로딩해야 함
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!");
			
			// 2. 드라이버 로딩 성공하면 실제 DB에 접속해보기
			// 접속하려면 아래 3가지 정보가 있어야 함
			//  - DB에 게정 1)ID와 2)PW가 있어야 함
			//  - 접속하려는 DB에 대한 3)URL이 있어야 함 => JDBC URL
			String myId = "root";
			String myPw = "test1234";
			// 프로토콜 jdbc:mysql + DB가 있는 컴퓨터의 IP주소(localhost) + 포트번호 3306 (DBMS)
			// + 내가 사용할 DB이름 (DB)
			String JDBC_URL = "jdbc:mysql://localhost:3306/employees?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			Connection con = DriverManager.getConnection(JDBC_URL, myId, myPw);
			System.out.println("데이터베이스 접속 성공!");
			
			// 3. Connection 객체를 얻었으면 이제 SQL query를 작성해서 전달해야 하는데
			// 이 SQL을 실어서 보낼 객체가 하나 필요
			// 이 객체를 Statement라고 함. 이 Statement는 크게 3가지 종류
			// 제일 간단한 형태인 Statement
			// 조금 더 나은 형태의 PreparedStatement
			// Stored Procedure를 호출할 수 있는 CallableStatement가 있음
			// 이 중 우리는 PreparedStatement를 이용
			// 이름에서 의미하다시피 이 statement는 SQL Query를 가지고 있는 statement
			String sql = "select * from employees where gender='F'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// 4. 이렇게 전달할 Statement를 만들었으면
			// 이제 실행 => SQL Query를 실행
			// 그런데 실행하려는 SQL이 만약 SELECT 계열이면 => 결과 레코드 집합을 가져옴
			// 이때 사용하는 method는 executeQuery()를 이용
			// 그러면 이때 return값은 ResultSet으로 받음
			ResultSet rs = pstmt.executeQuery();
			
			// 5. ResultSet을 이용해서 데이터 추출(로직처리)
			rs.next();
			// 현재 ResultSet 위치에서 first_name 컬럼을 찾아 그 값을 String으로 가지고 옴 
			String firstName = rs.getString("first_name");
			System.out.println(firstName); //Bezalel
			rs.next();
			firstName = rs.getString("first_name");
			System.out.println(firstName); //Anneke
			
			// 6. 사용된 자원의 반납
			// 사용한 여러 자원들을 close 시켜 정상 종료 해줘야 함
			// 사용한 자원들을 생성과 반대 순서로 close 처리 해줘야함
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("뭔가 잘못 되었어요!");
		}
	}
}