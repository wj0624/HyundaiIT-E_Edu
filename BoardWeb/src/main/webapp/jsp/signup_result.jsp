<%@ page import="member.vo.MemberVO"
	language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
<style>
	table {
        width: 280px;
        height: 250px;
        margin: auto;
        font-size: 15px;
    }
	a {
       font-size: 15px;
       color: darkgray;
       text-decoration-line: none;
	 }
</style>
</head>
<body>
	
	<% 
		MemberVO vo = (MemberVO) request.getAttribute("ResultVO");
	%>
	<table>
	    <tr>
	        <td><h2>회원가입 완료</h2></td>
	    </tr>
		<tr><td><h3><%= vo.getName() %>님, 가입을 환영합니다!</h3></td></tr>
		<tr>
			<td>
				<ul>
					<li>회원 ID : <%= vo.getUserID() %></li>
					<li>생년월일 : <%= vo.getBirthday() %></li>
					<li>성   별 : <%= vo.getGender()  %></li>
				</ul>
			</td>
		</tr>
		<tr><td><a href="html/login.html">로그인하러 가기</a></td></tr>
	</table>
</body>
</html>