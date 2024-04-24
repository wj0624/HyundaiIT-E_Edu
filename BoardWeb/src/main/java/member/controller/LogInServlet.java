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
 * Servlet implementation class LogInServlet
 */
@WebServlet("/login")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
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
		// 1. 입력
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		MemberVO vo = new MemberVO();
		vo.setUserID(userID);
		vo.setPassword(password);
		
		// 2.로직처리
		MemberService service = new MemberService();
		MemberVO result = service.logIn(vo);
		
		if(result!=null) {
			// 로그인 성공시(가져 온 member의 ID와 password가 일치하는 경우)
			if(result.getUserID().equals(vo.getUserID()) &&
					result.getPassword().equals(vo.getPassword())) {
				
				// Session 객체 생성
				HttpSession session = request.getSession(true);
				session.setAttribute("MemberDATA", result);
				
				//로그인 성공 alert 띄우기
				String script = "<script>alert('로그인 성공!'); window.location.href='/board/articles';</script>";
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print(script);
				
				// 3. 출력처리
//				RequestDispatcher rd = 
//						request.getRequestDispatcher("jsp/board.jsp");
//				// JSP에게 데이터 전달
//				// JSP에게 전달되는 request 객체에 원하는 데이터를 붙여서 전달
//				request.setAttribute("boardList", result);
//				rd.forward(request, response); // request & response JSP에게 전달
				
				return;
			}
		}
		
		// 로그인 실패시
		String script = "<script>alert('로그인 실패. ID와 비밀번호를 확인해 주세요.'); window.location.href='html/login.html';</script>";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(script);
	}

}
