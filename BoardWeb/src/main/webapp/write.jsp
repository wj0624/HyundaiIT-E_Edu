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
	        border-top: none;
	        margin-top: 20px; /* 테이블과 상단 간격 설정 */
	    }
	    .center {
        	text-align: center;
    	}
	    
	    input[type="text"] {
	        border: 1.5px rgb(68, 136, 244) solid;
	        width: 100%;
	        height: 30px;
	        border-radius: 5px;
	        padding-left: 10px;
	    }
	    textarea {
	        border: 1.5px rgb(68, 136, 244) solid;
	        width: 100%;
	    	height: 40vh;
	        border-radius: 5px;
	        padding-left: 10px;
	        padding-top: 10px;
	        resize: none;
	    }
	    .header {
	        height: 30px;
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
       	
       	.logout {
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
	</style>
	</head>
<body>

	<% 
        // 현재 로그인된 사용자의 정보 가져오기
        MemberVO vo = (MemberVO) session.getAttribute("MemberDATA");
        if(vo == null) {
            // 로그인되지 않은 상태라면 로그인 페이지로 리다이렉트 또는 메시지 표시
            %>
            <script>
	            alert('로그인 후 이용가능합니다')
	            location.href='login.html'
            </script>
            <%
            
            return;
        }
    %>
	
		<div id="headerButtons">
            <div id="userName"> <%= vo.getName() %>님 </div>
            <a href="mypage.jsp">마이페이지</a>
            <form action="http://localhost:8080/board/logout" method="post">
            	<input type="submit" value="로그아웃" class="logout">
            </form>
   		</div>
   		<form action="http://localhost:8080/board/write" method="post">
		<!-- 현재 로그인된 사용자의 ID(hidden input으로 전달) -->
        <input type="hidden" name="userID" value="<%= vo.getUserID() %>">
		<table> 
		    <tr><td><h2>글쓰기</h2></td></tr>
		    <tr><td colspan="2" class="header">제목</td></tr>
		    <tr><td class="center"><input type="text" placeholder="제목을 입력하세요" name="title"></td></tr>
		    <tr><td colspan="2" class="header">내용</td></tr>
		    <tr><td class="center"><textarea placeholder="내용을 입력하세요" name="content"></textarea></td></tr>
		    <tr><td><button type="submit">등록</button></td></tr>
		</table>
	</form>
</body>
</html>