package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class MemberChangeServlet
 */
@WebServlet("/mypage")
public class MemberChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 입력받고(Controller 역할)
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		String name = request.getParameter("userName");
		String birthday = request.getParameter("bday");
		String gender = request.getParameter("gender");
		
		MemberVO vo = new MemberVO(userID, password, name, birthday,gender);
		
		
		// 2. 로직처리(Service에게 위임)
		MemberService service = new MemberService();
		MemberVO result = service.changeMember(vo);
		
		// Session 객체 생성
		HttpSession session = request.getSession(true);
		session.setAttribute("MemberDATA", result);
		
		// 3. 출력처리
		//로그인 성공 alert 띄우기
		String script = "<script>alert('회원정보 수정 성공!'); window.location.href='/board/articles';</script>";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(script);
//		RequestDispatcher rd = 
//				request.getRequestDispatcher("jsp/board.jsp");
//		rd.forward(request, response); // request & response JSP에게 전달
	}

}
