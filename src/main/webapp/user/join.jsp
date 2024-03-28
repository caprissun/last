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
   <h2>회원 가입</h2>
   '*' 표시 항목은 필수 입력 항목입니다.
   <form action="CommandServlet" method="post" name="frm">
   	<input type="hidden" name="command" value="user_join">
      <table border="1">
         <tr>
            <td>아이디</td>
            <td><input type="text" name="userid" size="20"  id="id">*
            <input type="hidden" name="reid" size="20">
            <input type="button" value="중복 체크" onclick="idCheck()"></td>
         </tr>
         <tr>
            <td>암 호</td>
            <td><input type="password" name="pwd" size="20">*</td>
         </tr>
         <tr height="30">
            <td width="80">암호 확인</td>
            <td><input type="password" name="pwd_check" size="20">*</td>
         </tr>
         <tr>
            <td>이름</td>
            <td><input type="text" name="username" size="20">*</td>
         </tr> 
         <tr>
            <td>이메일</td>
            <td><input type="text" name="email" size="40"></td>
         </tr>
         <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone" size="20"></td>
         </tr>
         	<td>주민번호</td>
         	<td><input type="text" name="jumin" size="13"></td>
         <tr>
         	<td>닉네임</td>
         	<td><input type="text" name="nickname" size="20"></td>
         </tr>
         <tr>
            <td>등급</td>
            <td><input type="radio" name="admincheck" value="0" checked="checked"> 일반회원 
            <input type="radio" name="admincheck" value="1"> 관리자</td>
         </tr>
         <tr>
            <td colspan="2" align="center"><input type="submit" value="확인" onclick="return joinCheck()">
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