package member.dao;

import org.apache.ibatis.session.SqlSession;

import member.vo.MemberVO;

public class MemberDAO {
	private SqlSession session;
	
	public MemberDAO() {
	}
	
	// 생성자 주입 (Constructor Injection)
	public MemberDAO(SqlSession session) {
		super();
		this.session = session;
	}
	
	// 회원가입
	public int insertMember(MemberVO vo) throws Exception{
		int result = 0;
		result = session.update("mywebsite.insertMember", vo);
		return result;
	}
	
	// 로그인
	public MemberVO selectMember(MemberVO vo) throws Exception{
		MemberVO result = session.selectOne("mywebsite.logIn", vo);
		return result;
	}
	
	// 회원정보 수정
	public int changeMember(MemberVO vo) {
		int result = 0;
		result = session.update("mywebsite.changeMember", vo);
		return result;
	}
	
	// 회원탈퇴
	public int deleteMember(MemberVO vo) {
		int result = 0;
		result = session.update("mywebsite.deleteMember", vo);
		return result;
	}
}
