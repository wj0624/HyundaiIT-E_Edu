package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.BoardVO;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
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
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String author = request.getParameter("userID");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setAuthor(author);
		
		// 2. 로직처리
		BoardService service = new BoardService();
		List<BoardVO> result = service.writeArticle(vo);
		
		// 3. 출력처리
		RequestDispatcher rd = 
				request.getRequestDispatcher("jsp/board.jsp");
		// JSP에게 데이터 전달
		// JSP에게 전달되는 request 객체에 원하는 데이터를 붙여서 전달
		request.setAttribute("boardList", result);
		rd.forward(request, response); // request & response JSP에게 전달
	}

}
