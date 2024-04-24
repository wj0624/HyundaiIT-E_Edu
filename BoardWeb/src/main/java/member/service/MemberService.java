package member.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import member.dao.MemberDAO;
import member.vo.MemberVO;
import mybatis.MyBatisConnectionFactory;

public class MemberService {
	// 회원가입
	public MemberVO signUpMember(MemberVO member) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		MemberVO result = new MemberVO();
		
		try {
			// 트랜잭션 시작
			MemberDAO dao = new MemberDAO(session);
			int count = dao.insertMember(member);
			result = dao.selectMember(member);
			
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close(); // 트랜잭션 종료
		}
		
		return result;
	}
	
	// 로그인
	public MemberVO logIn(MemberVO member) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		MemberVO result = new MemberVO();
		
		try {
			// 트랜잭션 시작
			MemberDAO dao = new MemberDAO(session);
			result = dao.selectMember(member);
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close(); // 트랜잭션 종료
		}

		return result;
	}
	
	// 회원정보 수정
	public MemberVO changeMember(MemberVO member) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		MemberVO result = new MemberVO();
		try {
			// 트랜잭션 시작
			MemberDAO dao = new MemberDAO(session);
			int count = dao.changeMember(member);
			result = dao.selectMember(member);
			
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close(); // 트랜잭션 종료
		}
		return result;
	}
	
	// 회원 탈퇴
	public int deleteMember(MemberVO member) {
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int count = 0;
		try {
			// 트랜잭션 시작
			MemberDAO dao = new MemberDAO(session);
			count = dao.deleteMember(member);
			
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close(); // 트랜잭션 종료
		}
		return count;
	}
}
