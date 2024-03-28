<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메인</h1>
<h1>${userid}님</h1>
<input type="submit" value="마이페이지" onclick="location.href='CommandServlet?command=mypage_form'"><br>
<input type="submit" value="교환&환불" onclick="location.href='CommandServlet?command=refund_form'"><br>
<input type="submit" value="상품페이지" onclick="location.href='ShoppingServlet?command=product_list'"><br>
<input type="submit" value="장바구니" onclick="location.href='CommandServlet?command=CartService'">
</body>
</html>