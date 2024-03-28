<%@page import="com.saeyan.dto.ProductVO"%>
<%@page import="com.product.controller.action.productview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="wrap" align="center">
      <h1>상품 주문</h1>
      <form action="ShoppingServlet" name=frm method="post">
      <input type="hidden" name="command" value="product_Order">

        
                     
      <table>
         <tr>
            <th>상품명</th>
            <td>${product.productName}</td>
            <th>카테고리</th>
            <td>${product.productCategory}</td>
         </tr>
         <tr>
            <th>등록일</th>
            <td><fmt:formatDate value="${product.productdate}" /></td>
            <th>남은수량</th>
            <td>${product.productStock}</td>
         </tr>
         <tr>
            <th>가격</th>
            <td colspan="3">${product.productPrice}</td>
         </tr>
         <tr>
            <th>내용</th>
            <td colspan="3"><pre>${product.productDescription}</pre></td>
         </tr>

         
         
      </table>
      <br> <br> <input type="button" value="구매하기" 
      onclick = "location.href='ShoppingServlet?command=product_Order&productName=${product.productName}'">
            
      <input type="button" value="장바구니"
         onclick="location.href='CartController?command=cartList'">
           </form>
      
      
      <input type="button" value="상품 페이지"
         onclick="location.href='ShoppingServlet?command=product_list'">
           </form>
   </div>
   
</body>
</html>