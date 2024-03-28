<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/user.js"></script>
</head>
<body>
	<h2>로그인</h2> 
	<form action="CommandServlet" method="post" name="frm">
		<input type="hidden" name="command" value="user_login">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>암 호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="로그인" onclick="return loginCheck()">
			 	<input type="reset" value="취소">
				<input type="button" value="회원 가입" onclick="location.href='CommandServlet?command=user_join_form'">
				<input type="button" value="비회원 구매" onclick="location.href='CommandServlet?command=nonuser_join_form'">
				</td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</table>
	</form>
</body>
</html>