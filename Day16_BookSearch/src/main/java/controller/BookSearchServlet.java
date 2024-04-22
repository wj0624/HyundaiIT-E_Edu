package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import vo.BookVO;

/**
 * Servlet implementation class BookSearchController
 */
@WebServlet("/search")
public class BookSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력받고(Controller 역할)
		//	  일반적으로 입력 받아서 VO로 만듦
		//	  Post 방식으로 한글 전달될 때 Encoding처리 해주어야 함
		request.setCharacterEncoding("UTF-8"); // 자동화
		
		String keyword = request.getParameter("keyword");
		String price = request.getParameter("price");
		BookVO bookVO = new BookVO();
		bookVO.setBtitle(keyword);
		bookVO.setBprice(Integer.parseInt(price));
		
		// 2. 로직처리(Service에게 위임)
		BookService service = new BookService();
		List<BookVO> list = service.getBooksByKeyword(bookVO);
		
		// 3. 결과 출력
		//	  서비스로부터 결과를 받아서(일반적으로 VO나 List<VO>의 형태)
		//	  Servlet(Controller)가 출력을 담당하지 않고
		//    View의 역할을 수행하는 JSP에게 결과 데이터를 넘겨줌
		//	  JSP(View)가 클라이언트에게 결과를 출력
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body><h1>검색결과입니다.</h1>");
		out.println("<h2>검색키워드: "+keyword+"</h2>");
		out.println("<h2>검색가격: "+price+"</h2>");
		out.println("<ul>");
		for(int i=0; i<list.size(); i++) {
			out.println("<li>"+list.get(i).getBtitle()+", "+list.get(i).getBprice()+"</li>");
		}
		out.println("</ul>");
		out.println("</body><html>");
		out.flush();
		out.close();		
	}

}
