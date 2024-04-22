package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */

// 자바 Servlet
// 웹에서 클라이언트가 직접적으로 호출하는 자바 프로그램
// controller의 역할을 수행
// 즉, 클라이언트의 요청을 받아서 로직을 처리하는 service와 연결시키는 역할 수행

// @WebServlet annotation은 해당 클래스가 servlet임을 나타내고,
// 그 안에 해당 서블릿의 URL Mapping을 명시
// 예전에는 이 설정을 web.xml(deployment descriptor)를 통해서 했음
// XML은 관리는 쉬운데 귀찮고, annotation은 사용은 쉬운데 관리가 어려움
@WebServlet("/first")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // 일반 생성자
        // 일반적인 경우에는 이 생성자를 이용해 객체를 초기화하는데
        // Servlet의 경우에는 생성자말고 init()에서 초기화를 진행
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	// Servlet의 초기화 작업을 진행
    }
    
    // service()는 이미 하는 일이 있기 때문에 기본적으로 overriding 하지 않음
    // 클라이언트의 request 방법을 알아내서 doGet, doPost를 호출하는 작업을
    // service가 이미 하고 있음
    // 그렇게 때문에 특별한 경우가 아닌 경우 overriding하지 않음
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	// TODO Auto-generated method stub
//    	super.service(req, resp);
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트로부터 입력을 받아서
		// 로직처리해서
		// 결과를 클라이언트에게 돌려주기
		
		// 처음이니까 입력은 받지 않음
		// 로직처리도 하지 않을 것
		// 클라이언트에게 출력처리만 해보기
		// doGet()의 두개의 parameter가 전달되는데
		// 하나는 클라이언트의 요청객체, 하나는 응답객체
		// 응답객체 이용해서 클라이언트에게 response 처리
		
		// 전달된 데이터 받기
		// Query String으로 전달된 데이터는 무조건 문자열로 전달됨
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// Stream 만들기 이전에 인코딩 방식 설정해야 함
		response.setContentType("text/html; charset=UTF-8");
		
		// 클라이언트에게 데이터를 전달하기 위해 Stream 열기
		PrintWriter out = response.getWriter();
		// 클라이언트에게 전달하는 데이터는 대부분 HTML임
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body><h1>소리없는 아우성!!</h1></body>");
		out.println("<h2>"+name+"</h2>");
		out.println("<h2>"+age+"</h2>");
		out.println("</body><html>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
