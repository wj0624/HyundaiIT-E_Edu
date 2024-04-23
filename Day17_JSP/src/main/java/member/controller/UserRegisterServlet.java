package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.MemberVO;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/userInput")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력받고
		//	  클라이언트가 보내준 데이터 받아서 VO로 생성
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");		
		String age = request.getParameter("userAge");
		MemberVO vo = new MemberVO(name, age);
		
		// Session 객체 생성
		// request.getSession(true)의 의미는
		// 만약 클라이언트에게 이전에 할당된 Session이 있으면 가져오고 없으면 생성
		HttpSession session = request.getSession(true);
		session.setAttribute("MyDATA", vo);
		
		// 2. 로직처리
		//	  로직처리하기 위해서 서비스 생성해서 VO를 전달해서 로직처리
		//	  Service가 결국 최종 결과물을 controller(servlet)에게 return
		
		
		// 3. 출력처리
		// 	  Servlet(controller)가 최종 결과물을 보고 어떤 View(JSP)를
		//    이용해서 클라이언트에게 결과를 보여줄지 선택
		
		// 	  출력결과에 맞는 JSP를 선택해서 request를 전달
		
		//    해당 JSP가 적절하게 출력할 수 있도록 처리
		//	  위에서 생성한 VO를 JSP에게 전달해서 출력
		RequestDispatcher rd = 
				request.getRequestDispatcher("/result.jsp");
		// JSP에게 데이터 전달
		// JSP에게 전달되는 request 객체에 원하는 데이터를 붙여서 전달
		request.setAttribute("ResultVO", vo);
		rd.forward(request, response); // request & response JSP에게 전달
	}

}
