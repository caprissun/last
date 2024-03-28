<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/user.js"></script>
</head>
<body>
   <h2>비회원</h2>
   <form action="CommandServlet" method="post" name="frm">
   	<input type="hidden" name="command" value="nonuser_join">
      <table border="1">
         <tr>
            <td>전화 번호</td>
            <td><input type="text" name="phone" size="20"></td>
         </tr>
         <tr>
            <td>이메일</td>
            <td><input type="text" name="email" size="20"></td>
         </tr>
         <tr>
            <td colspan="2" align="center"><input type="submit" value="확인" onclick="location.href='CommandServlet?command=main_form'">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="취소">
            </td>
         </tr>
         <tr>
            <td colspan="2">${message}</td>
         </tr>
      </table>
   </form>
</body>
</html>