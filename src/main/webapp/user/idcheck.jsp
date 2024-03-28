<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/user.js"></script>
</head>
<body>
	<h2>아이디 중복 체크</h2>
	<form action="CommandServlet" method="get" name="frm">
		<input type="hidden" name="command" value="idcheck">
		아이디 <input type="text" name="id" value="${id}">
			<input type="submit" value="중복 체크">
			
		<br>
		<c:if test="${result == 1 }">
			<script type="text/javascript">
				opener.document.frm.id.value="";
				
			</script>
			<div style="color:red">${id}는 이미 사용 중인 아이디 입니다.</div>
		</c:if>
		
		<c:if test="${result == -1 }">
			<div style="color:red">${id}는 사용 가능한 아이디입니다.</div>
			<input type="button" value="사용" class="cancel" onclick="idok()">
		</c:if>	
	</form>
</body>
</html>