<%@ page import="java.util.List" %>
<%@ page import="board.vo.BoardVO" %>
<%@ page import="member.vo.MemberVO" %>
<%@ page import="comment.vo.CommentVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>게시글 보기</title>
	<!-- jQuery에 대한 CDN -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" 
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" 
		crossorigin="anonymous"></script>
		
	<script src="js/comment.js"></script>
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
	        margin-top: 20px; /* 테이블과 상단 간격 설정 */
	    }
	    
	    .center {
        	text-align: left;
        	vertical-align: top; /* 요소를 상단으로 정렬 */
    	}
 
	    #textarea{
	    	border: 1.5px rgb(68, 136, 244) solid;
	    	width: 80%;
	    	height: 40vh;
	        border-radius: 5px;
	        padding: 10px;
	        resize: none;
	    }
	    
	    .cmt{
	    	width: 95%;
	    	border: 1.5px rgb(68, 136, 244) solid;
	    	height: 50px;
	    	border-radius: 5px;
	        padding: 10px;
	    }
	    
	    #cmtbtn{
	    	height: 70px;
	    }
	    .content{
	    	margin-top: 10px;
	    	margin-bottom: 10px;
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
   		a {
           	margin-left: 10px;
	        color: darkgray;
	        text-decoration-line: none;
  		}
  		.form-group {
		    display: flex;
		    justify-content: right;
		    align-items: right;
		}
	
		.form-group form {
	    	margin-right: 10px; /* 각 form 사이의 간격을 조절합니다. */
		}
	</style>
	</head>
<body>
	<%-- 글 내용을 표시하기 위한 JSP 코드 --%>
    <%-- BoardVO 클래스로부터 글 정보를 받아와서 사용 --%>
    <%
	 	// 현재 로그인한 사용자 정보 가져오기
	    MemberVO user = (MemberVO) session.getAttribute("MemberDATA");
    	// 현재 보고 있는 글에 대한 정보 가져오기
        BoardVO post = (BoardVO) request.getAttribute("selectedPOST");
        
     	// 로그인 되어있는지 확인
        boolean isLoggedIn = (user != null);
     	
        // 게시글 수정 또는 삭제 권한 확인
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
	    <table>
	    <tr><td><h2>게시글</h2></td></tr>
	    <tr><td colspan="4" class="title"><h3><%= post.getTitle() %></h3></td></tr>
	    <tr>
	    	<td>작성자: <%= post.getName() %></td>
	    	<td>작성일: <%= post.getCreated_date() %></td>
	    	<%-- 수정 또는 삭제 버튼 추가, 작성자와 현재 로그인한 사람이 동일할 때만 --%>
	    	<% if (hasPermission) { %>
	    	<td colspan="2" class="edit">
	    		<div class="form-group">
				<!-- 수정 버튼 클릭 시 edit.jsp로 post 데이터를 전송 -->
				<form action="http://localhost:8080/board/editview" method="post">
				    <input type="hidden" name="postID" value="<%= String.valueOf(post.getPost_id()) %>">
					<button type="submit">수정</button>
				</form>

				<form action="http://localhost:8080/board/deletePost" method="post">
					<input type="hidden" name="postID" value="<%= String.valueOf(post.getPost_id()) %>">
		    		<button type="submit">삭제</button>
		    	</form>
		    	</div>
	    	</td>
	    	<% } %>
	    </tr>
	    <tr class="content"><td colspan="4" class="center" id="textarea"><%= post.getContent() %></td></tr>
	    <tr><td></td></tr>
	    </table>
	    <table>
	    <tr><td><h3>댓글</h3></td></tr>
			<% if (request.getAttribute("comment") != null) { %>
				<% List<CommentVO> comments = (List<CommentVO>) request.getAttribute("comment"); %>
	            <% for (CommentVO cmnt : comments) { %>
               		<tr id="<%= cmnt.getComment_id() %>">
                        <td><strong><%= cmnt.getUserName() %></strong></td>
                    	<td colspan="3"><p id="editCmnt_<%= cmnt.getComment_id() %>"><%= cmnt.getContent() %></p></td>
                    	<td></td>
                        <td><%= cmnt.getCreated_date() %></td>
                        <% 
	                     	// 댓글 수정 또는 삭제 권한 확인
	                        boolean hasCmntPermission = false;
	                        if (user != null && cmnt != null) {
	                            // 현재 로그인한 사용자와 게시물의 작성자를 비교하여 권한 확인
	                            if (user.getUserID().equals(cmnt.getUserID())) {
	                                hasCmntPermission = true;
	                            }
	                        }
                        	if (hasCmntPermission) { %>
					    	<td colspan="2" class="edit">
					    		<div class="form-group">
									<button id="cmntEdit<%= cmnt.getComment_id() %>" onclick="cmntEdit(<%=cmnt.getComment_id()%>)">수정</button>
						    		<button id="cmntDelete<%= cmnt.getComment_id() %>" onclick="cmntDelete(<%=cmnt.getComment_id()%>)">삭제</button>
						    	</div>
					    	</td>
				    	<% } %>
                    </tr>
                <% } %>
			<% } %>
			
		</table>
		<% if (isLoggedIn) { %>
		<table>
			<tr>
				<form action="http://localhost:8080/board/writeCmnt" method="post">
					<td colspan="3">
						<input type="text" class="cmt" placeholder="댓글을 입력하세요" name="comment">
					</td>
					<td>
						<input type="hidden" name="postID" value="<%= String.valueOf(post.getPost_id()) %>">
						<input type="hidden" name="userID" value="<%= user.getUserID() %>">
						<input type="hidden" name="userName" value="<%= user.getName() %>">
						<button id="cmtbtn" type="submit">등록</button>
					</td>
				</form>
			</tr>
	    </table>
	    <% } %>
   <% } else { %>
            <p>글을 불러오는 데 실패했습니다.</p>
   <% } %>
	
</body>
</html>