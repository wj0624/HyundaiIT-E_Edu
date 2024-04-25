<%@ page import="member.vo.MemberVO"
	language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>마이페이지</title>
	<!-- jQuery에 대한 CDN -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" 
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" 
		crossorigin="anonymous"></script>
		
	<script src="js/signup.js"></script>
	<style>
	    table {
	        width: 280px;
	        height: 550px;
	        margin: auto;
	    }
	    .text {
	        width: 250px;
	        height: 32px;
	        font-size: 15px;
	        border: 0;
	        border-radius: 15px;
	        outline: none;
	        padding-left: 10px;
	        background-color: rgb(233,233,233);
	    }
	    select {
	        width: 100px;
	        height: 32px;
	        font-size: 15px;
	        border: 1;
	        border-color: lightgray;
	        border-radius: 15px;
	        outline: none;
	        padding-left: 10px;
	    }
	    .btn {
	        width: 262px;
	        height: 32px;
	        font-size: 15px;
	        border: 0;
	        border-radius: 15px;
	        outline: none;
	        padding-left: 10px;
	        background-color: rgb(164, 199, 255);
	    }
	    .btn:active {
	        width: 262px;
	        height: 32px;
	        font-size: 15px;
	        border: 0;
	        border-radius: 15px;
	        outline: none;
	        padding-left: 10px;
	        background-color: rgb(61, 135, 255);
	    }
    	.delete {
		    text-align: center;
		    font-size: 15px;
	        color: darkgray;
	        text-decoration-line: none;
	        background-color: transparent; /* 배경색 없애기 */
	        border: none; /* 테두리 없애기 */
	        cursor: pointer; /* 커서 모양 변경 */
	        display: block; /* 가로로 배치되는 인라인 요소를 블록 요소로 변경 */
	        margin: auto; /* 가운데 정렬 */
	        width: fit-content; /* 내용에 맞게 너비 설정 */
		}
	</style>
</head>
<body>
<form action="http://localhost:8080/board/mypage" onsubmit="return comparePW()" method="post">
	<% 
       	MemberVO vo = (MemberVO) session.getAttribute("MemberDATA");
	%>
    <table>
	    <tr>
	        <td><h2>마이페이지</h2></td>
	    </tr>
	    <tr>
	        <td><h3>회원정보수정</h3></td>
	    </tr>
	    <tr><td><strong>아이디</strong></td></tr>
	    <tr><td><input type="hidden" name="userID" value="<%= vo.getUserID() %>"><%= vo.getUserID() %></td></tr>
		<tr><td></td></tr>
	    <tr><td><strong>비밀번호</strong></td></tr>
	    <tr><td><input type="password" class="text" id="PW" name="password"></td></tr>
	    <tr><td><strong>비밀번호 확인</strong></td></tr>
	    <tr><td><input type="password" class="text" id="confirmPW"></td></tr>
	    <tr><td><strong>이름</strong></td></tr>
	    <tr><td><input type="text" class="text" name="userName" value="<%= vo.getName() %>"></td></tr>
	    <tr><td><strong>생년월일</strong></td></tr>
	    <tr><td><input type="date" class="text" name="bday" value="<%= vo.getBirthday() %>"></td></tr>
	    <tr><td><strong>성별</strong></td></tr>
	    <tr>
	        <td>
	            <select name="gender">
				    <option value="M" <% if (vo.getGender().equals("M")) { %> selected <% } %>>남성</option>
				    <option value="F" <% if (vo.getGender().equals("F")) { %> selected <% } %>>여성</option>
				</select>

	        </td>
	    </tr>
	    <tr><td><input type="submit" value="수정하기" class="btn"></td></tr>
	    </table>
	    </form>
        <form action="http://localhost:8080/board/delete" method="post">

        		<input type="hidden" name="userID" value="<%= vo.getUserID() %>">
           	 	<input type="submit" value="회원탈퇴" class="delete">
    
		</form>

    

</body>
</html>