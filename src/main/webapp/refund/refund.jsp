<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>환불 & 교환</h1>
   <form action="CommandServlet" method="post" name="frm">
   	<input type="hidden" name="command" value="refund">
   		<table border="1">
   			<tr>
   				<td>상품명</td>
   				<td><input type="text" name="product" ></td>
   			</tr>
	         <tr>
	            <td colspan="2" align="center"><input type="radio" name="check" value="0" checked="checked"> 환불 
	            <input type="radio" name="check" value="1"> 교환</td>
	         </tr>
   			<tr>
   				<td>주문자</td>
   				<td><input type="text" name="userid" ></td>
   			</tr>
   			<tr>
   				<td>환불 계좌</td>
   				<td><input type="text" name="account" ></td>
   			</tr>
   			<tr>
   				<td>환불&교환 사유</td>
   				<td><input type="text" name="reason" ></td>
   			</tr>
   			<tr>
            	<td colspan="2" align="center"><input type="submit" value="등록">
	               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="취소">
	            </td>
         	</tr>
   	
   		</table>
  	</form>
</body>
</html>