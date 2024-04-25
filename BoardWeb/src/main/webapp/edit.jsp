<%@ page import="board.vo.BoardVO" %>
<%@ page import="member.vo.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>게시글 수정</title>
	<style>
		/* 화면 전체를 커버하는 컨테이너에 대해 중앙 정렬 스타일 적용 */
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* 화면 전체 높이에 대한 비율 설정 */
        }
        
	    table {
	        margin: auto;
	        width: 80%;
	        border-collapse: collapse;
	        margin-top: 20px; /* 테이블과 상단 간격 설정 */
	    }
	    .center {
        	text-align: center;
    	}
    	
	    textarea{
	    	border: 1.5px rgb(68, 136, 244) solid;
	    	width: 100%;
	    	height: 40vh;
	        border-radius: 5px;
	        padding-left: 10px;
	        padding-top: 10px; /* 위쪽 10px, 좌측 10px만 패딩을 주고 나머지는 0 */
	        resize: none;
	    }
	    
	    .header {
    	 	background-color: rgb(218, 231, 255);
	    }
	    
	    button {
	        width: 100px;
	        height: 40px;
	        font-size: 15px;
	        border: 0;
	        outline: 1.5px rgb(68, 136, 244) solid;
	        border-radius: 5px;
	        padding-left: 10px;
	        background-color: rgb(164, 199, 255);
	        cursor: pointer;
	    }
	    button:active {
	        width: 100px;
	        height: 40px;
	        font-size: 15px;
	        border: 0;
	        border-radius: 5px;
	        outline: 1.5px rgb(27, 76, 155) solid;
	        padding-left: 10px;
	        background-color: rgb(68, 136, 244);
	    }
		
	    /* 우측 상단 로그인/회원가입 버튼 스타일 */
       	#headerButtons{
            display: flex;
            justify-content: flex-end;
            margin-right: 20px;
            margin-top: 10px;
       	}
       	
       	input {
	        font-size: 15px;
	        color: darkgray;
	        text-decoration-line: none;
	        background-color: transparent; /* 배경색 없애기 */
	        border: none; /* 테두리 없애기 */
	        cursor: pointer; /* 커서 모양 변경 */
    	}
    	input[type="text"] {
	        border: 1.5px rgb(68, 136, 244) solid;
	        width: 100%;
	        height: 30px;
	        border-radius: 5px;
	        padding-left: 10px;
	    }
   		a {
           	margin-left: 10px;
	        color: darkgray;
	        text-decoration-line: none;
  		}
	</style>
	</head>
<body>

    <%
    	// 현재 로그인한 사용자 정보 가져오기
	    MemberVO user = (MemberVO) session.getAttribute("MemberDATA");
        BoardVO post = (BoardVO) request.getAttribute("selectedPOST");
        // 로그인 되어있는지 확인
        boolean isLoggedIn = (user != null);
        // 수정 또는 삭제 권한 확인
        boolean hasPermission = false;
        if (user != null && post != null) {
            // 현재 로그인한 사용자와 게시물의 작성자를 비교하여 권한 확인
            if (user.getUserID().equals(post.getAuthor())) {
                hasPermission = true;
            }
        }
        
        if (post != null) { // 글 정보가 있다면
    %>
   
	    <div id="headerButtons">
            <% if (!isLoggedIn) { %>
	            <!-- 로그인 및 회원가입 버튼 -->
	            <div>
		            <button id="loginBtn" onclick="goToLoginPage()">로그인</button>
		            <button id="signupBtn" onclick="goToSignupPage()">회원가입</button>
	            </div>
	        <% } else { %>
	            <!-- 사용자 이름 -->
	            <div id="userName"> <%= user.getName() %>님 </div>
	            <a href="mypage.jsp">마이페이지</a>
	            <form action="http://localhost:8080/board/logout" method="post">
	            	<input type="submit" value="로그아웃" class="logout">
	            </form>
	        <% } %>
   		</div>
   		<form action="http://localhost:8080/board/edit" method="post">
	    <table>
	    <tr><td><h2>게시글</h2></td></tr>
	    <tr><td colspan="2" class="title"><h3><input type="text" name="title" value="<%= post.getTitle() %>"></h3></td></tr>
	    <tr>
	    	<td>작성자: <%= post.getName() %></td>
	    	<td>작성일: <%= post.getCreated_date() %></td>
	    </tr>
	    <tr><td colspan="2" class="center"><textarea name="content"><%= post.getContent() %></textarea></td></tr>
	    <tr><td></td></tr>
	    </table>
	    <%-- 수정 또는 삭제 버튼 추가, 작성자와 현재 로그인한 사람이 동일할 때만 --%>
	    <% if (hasPermission) { %>
	    <table>
		<tr>
			<td>
				<input type="hidden" name="postID" value="<%= String.valueOf(post.getPost_id()) %>">
				<button type=submit>수정</button>
	    	</td>
	    </tr>
		</table>
		<% } %>
   <% } else { %>
            <p>글을 불러오는 데 실패했습니다.</p>
   <% } %>
</form>
</body>
</html>