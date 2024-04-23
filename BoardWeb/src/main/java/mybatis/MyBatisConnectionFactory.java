package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// sqlSessionFactory 얻어내기
public class MyBatisConnectionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	
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
