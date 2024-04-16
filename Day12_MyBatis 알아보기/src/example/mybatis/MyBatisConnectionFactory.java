package example.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 이 클래스의 목적은 sqlSessionFactory를 얻어내기 위함이다
// static으로 하나만 만들어서 가져다 쓰기
public class MyBatisConnectionFactory {
	
	// 실제 프로그램(DAO)에서 사용하는 데이터베이스 연결 객체는
	// 기존에는(JDBC일때) Connection 객체를 이용했음
	// MyBatis에서는 SqlSession 객체를 이용함
	private static SqlSessionFactory sqlSessionFactory;
	
	// 이 Factory 객체는 해당 클래스로부터 객체가 1개만 만들어져서 사용되도록 처리
	// => Singleton으로 동작하게끔 만듦
	static {
		try {
			String resource = "./SqlMapConfig.xml"; 
			Reader reader = Resources.getResourceAsReader(resource);
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = 
						new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	

}
