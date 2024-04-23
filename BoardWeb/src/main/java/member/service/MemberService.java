package member.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import member.dao.MemberDAO;
import member.vo.MemberVO;
import mybatis.MyBatisConnectionFactory;

public class MemberService {
	// 회원가입
	public void signUpMember(MemberVO member) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try {
			// 트랜잭션 시작
			MemberDAO dao = new MemberDAO(session);
			int count = dao.insertMember(member);
			
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close(); // 트랜잭션 종료
		}
	}
}
