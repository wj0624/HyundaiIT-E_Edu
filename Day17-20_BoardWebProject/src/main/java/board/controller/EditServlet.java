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
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		
		// 1. 입력
		String postID = request.getParameter("postID");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setPost_id(Integer.parseInt(postID));
		vo.setTitle(title);
		vo.setContent(content);
		
		// 2. 로직처리
		BoardService service = new BoardService();
		BoardVO result = service.editArticle(vo);
		
		// 3. 출력처리
		RequestDispatcher rd = 
				request.getRequestDispatcher("view.jsp");
		// JSP에게 데이터 전달
		// JSP에게 전달되는 request 객체에 원하는 데이터를 붙여서 전달
		request.setAttribute("selectedPOST", result);
		rd.forward(request, response); // request & response JSP에게 전달
//		request.setAttribute("selectedPOST", result);
//		String script = "<script>alert('글이 수정되었습니다'); location.href='view.jsp';</script>";
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print(script);
		
	}

}
