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
	
	public int insertMember(MemberVO vo) throws Exception{
		int result = 0;
		result = session.update("mywebsite.insertMember", vo);
		return result;
	}
}
