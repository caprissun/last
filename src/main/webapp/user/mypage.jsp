<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>마이페이지</h1>
	<form action="CommandServlet" method="post" name="address">
	<input type="hidden" name="command" value="mypage">
		<table border="1">
			<tr>
				<td>이름</td>
				 <td><input type="text" name="username" size="20" value="${userid}"></td>
			</tr>
			<tr>
				<td>주소</td>
				 <td><input type="text" name="address" size="100"></td>
			</tr>
			<tr>
				<td>상세주소</td>
				 <td><input type="text" name="addressDetail" size="50"></td>
			</tr>
			<tr>
				<td>배송시 요청사항</td>
				 <td><input type="text" name="deliveryRequest" size="200"></td>
			</tr>
			<tr>
		        <td colspan="2" align="center"><input type="submit" value="확인">
		          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="취소">
		        </td>
		   </tr>
    </table>
    </form>
</body>
</html>