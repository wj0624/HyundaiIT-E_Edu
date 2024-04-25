<%@ page import="java.util.List" %>
<%@ page import="board.vo.BoardVO" %>
<%@ page import="member.vo.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>게시판</title>
		<!-- jQuery에 대한 CDN -->
	    <script src="https://code.jquery.com/jquery-3.7.1.min.js" 
			integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" 
			crossorigin="anonymous"></script>
			
		<script src="js/board.js"></script>
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
		        border-radius: 5px;
		        border-collapse: collapse;
		        border-top: none;
		        margin-top: 20px; /* 테이블과 상단 간격 설정 */
		    }
		    
		    .header {
		        background-color: rgb(218, 231, 255);
		        text-align: center;
		    }
		    .table td, .table th {
		    	text-align: center;
		        border-bottom: 1px lightgray solid; 
		        height: 30px;
		        font-size: 14px;
		    }
		    .num {
		        width: 50px;
		    }
		    .title {
		        width: 500px;
		    }
		    .body {
		        text-align: center;
		    }
		    .body .title {
		        text-align: left;
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
        	
        	.write-button {
        		align-items: flex-end;
                margin-top: 10px;
            }
            
            a {
            	margin-left: 10px;
		        color: darkgray;
		        text-decoration-line: none;
   			}
   			
            input {
		        font-size: 15px;
		        color: darkgray;
		        text-decoration-line: none;
		        background-color: transparent; /* 배경색 없애기 */
		        border: none; /* 테두리 없애기 */
		        cursor: pointer; /* 커서 모양 변경 */
	    	}
	    	
        	
		</style>
	</head>
	<body>
		<header class="topbar">
			
			<% 
	        	MemberVO vo = (MemberVO) session.getAttribute("MemberDATA");
	       		boolean isLoggedIn = (vo != null);
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
		            <div id="userName"> <%= vo.getName() %>님 </div>
		            <a href="mypage.jsp">마이페이지</a>
		            <form action="http://localhost:8080/board/logout" method="post">
		            	<input type="submit" value="로그아웃" class="btn">
		            </form>
		        <% } %>
	   		</div>
		</header>
		
   		<script>
	   		// 로그인 페이지로 이동
	        function goToLoginPage() {
	            window.location.href = "login.html";
	        }
	
	        // 회원가입 페이지로 이동
	        function goToSignupPage() {
	            window.location.href = "signup.html";
	        }
	        
   		</script>
	    <table class="table">
	    	<thead >
	   			<tr><td colspan="4"><h2>게시판</h2></td></tr>
	            <tr class="header">
	                <th>번호</th>
	                <th>제목</th>
	                <th>작성자</th>
	                <th>작성일</th>
	            </tr>
	        </thead>
	        <tbody>
            <%-- 글 목록을 반복하여 표시 --%>
            <% if(request.getAttribute("boardList") != null) { %>
                <% List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList"); %>
                <% for (BoardVO board : boardList) { %>
                    <tr>
                        <td><%= board.getPost_id() %></td>
                        <td>
	                        <form action="http://localhost:8080/board/view" method="post">
	                        	<input type="hidden" name="postID" value="<%= String.valueOf(board.getPost_id()) %>">
	                        	<input type="submit" value="<%= board.getTitle() %>">
	                        </form>
                        </td>
                        <td><%= board.getName() %></td>
                        <td><%= board.getCreated_date() %></td>
                    </tr>
                <% } %>
            <% } else { %>
			    <tr>
			        <td colspan="4">게시글이 없습니다.</td>
			    </tr>
			<% } %>
        	</tbody>
		</table>
		<table>
			<tr>
				<td><button onclick="location.href='write.jsp'">글쓰기</button></td>
			</tr>
		</table>

	</body>
</html>
