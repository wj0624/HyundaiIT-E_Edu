<%@ page import="member.vo.MemberVO"
	language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- JSP 주석
		기억해야 하는 JSP의 구성요소는
		1. Expression => <%= %>
		   이 Expression 안에는 문자열로 변환이 가능한 값이 나옴
		   이 EXpression이 있는 위치에 값을 그냥 출력
		2. Scriptlet => <% 일반 자바 코드가 나옴 %>  
	 --%>
	<% 
		// getAttribute()가 Object 객체를 반환하기 때문에 캐스팅 해줘야함
		// MemberVO vo = (MemberVO) request.getAttribute("ResultVO");
		// JSP는 Servlet으로 실행됨
		// 편하게 사용하기 위해 기본적으로 session이라는 키워드로 클라이언트 session 제공
		MemberVO vo = (MemberVO) session.getAttribute("MyDATA");
	%>
	<h1>성공적으로 회원가입 됐습니다</h1>
	<h2>가입된 회원 이름 : <%= vo.getName() %></h2>
	<h2>가입된 회원 나이 : <%= vo.getAge() %></h2>
	<%
		int myAge = 30;
	%>
	<h2>변경된 회원 나이 : <%= myAge %></h2>

</body>
</html>