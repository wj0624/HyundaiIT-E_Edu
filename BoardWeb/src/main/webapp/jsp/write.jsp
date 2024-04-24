<%@ page import="member.vo.MemberVO" 
	language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>글쓰기</title>
	<style>
	    table {
	        margin: auto;
	    }
	    input[type="text"] {
	        border: 1.5px rgb(68, 136, 244) solid;
	        width: 500px;
	        height: 30px;
	        border-radius: 5px;
	        padding-left: 10px;
	    }
	    textarea {
	        border: 1.5px rgb(68, 136, 244) solid;
	        width: 500px;
	        height: 400px;
	        border-radius: 5px;
	        padding-left: 10px;
	        padding-top: 10px;
	        resize: none;
	    }
	    .header {
	        height: 30px;
	    }
	    input[type="submit"] {
	        width: 100px;
	        height: 40px;
	        font-size: 15px;
	        border: 0;
	        outline: 1.5px rgb(68, 136, 244) solid;
	        border-radius: 5px;
	        padding-left: 10px;
	        background-color: rgb(164, 199, 255);
	    }
	    input[type="submit"]:active {
	        width: 100px;
	        height: 40px;
	        font-size: 15px;
	        border: 0;
	        border-radius: 5px;
	        outline: 1.5px rgb(27, 76, 155) solid;
	        padding-left: 10px;
	        background-color: rgb(68, 136, 244);
	    }
	</style>
	</head>
<body>
	<% 
        // 현재 로그인된 사용자의 정보 가져오기
        MemberVO vo = (MemberVO) session.getAttribute("MemberDATA");
        if(vo == null) {
            // 로그인되지 않은 상태라면 로그인 페이지로 리다이렉트 또는 메시지 표시
            %>
            <script>alert('로그인 후 이용가능합니다')</script>
            <%
            response.sendRedirect("../html/login.html");
            return;
        }
    %>
	<form action="http://localhost:8080/board/write" method="post">
		<!-- 현재 로그인된 사용자의 ID(hidden input으로 전달) -->
        <input type="hidden" name="userID" value="<%= vo.getUserID() %>">
		<table> 
		    <tr><td><h2>글쓰기</h2></td></tr>
		    <tr><td class="header">제목</td></tr>
		    <tr><td><input type="text" placeholder="제목을 입력하세요" name="title"></td></tr>
		    <tr><td class="header">내용</td></tr>
		    <tr><td><textarea placeholder="내용을 입력하세요" name="content"></textarea></td></tr>
		    <tr><td><input type="submit" value="등록"></td></tr>
		</table>
	</form>
</body>
</html>