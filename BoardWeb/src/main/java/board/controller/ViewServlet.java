package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.BoardVO;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
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
		String postID = request.getParameter("postID");
		BoardVO vo = new BoardVO();
		vo.setPost_id(Integer.parseInt(postID));
		
		// 2. 로직처리(Service에게 위임)
		BoardService service = new BoardService();
		BoardVO result = service.viewDetail(vo);

		// 3. 출력처리
		RequestDispatcher rd = 
				request.getRequestDispatcher("view.jsp");
		// JSP에게 데이터 전달
		// JSP에게 전달되는 request 객체에 원하는 데이터를 붙여서 전달
		request.setAttribute("selectedPOST", result);
		rd.forward(request, response); // request & response JSP에게 전달
	}

}
