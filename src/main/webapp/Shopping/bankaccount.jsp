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
      <h1>입금계좌</h1>
      <form action="ShoppingServlet" name=frm method="post">
      <input type="hidden" name="command" value="product_Order">

      <h1>${bankaccount}</h1>
                     
      <table>
         <tr>
           <th>은행</th>
           <th>    </th>
           <th>계좌번호</th>
         </tr>
          <c:forEach var="bank" items="${bankaccount}">
            <tr class="record">
               <td>${bankaccount.bankName}</td>
               <td>    </td>
               <td>${bankaccount.accountNum}</td>
               <td>    </td>
               </tr>
          </c:forEach>
         
         
      </table>
      <br> <br> <input type="button" value="구매하기" 
      onclick = "location.href='ShoppingServlet?command=product_Order&productName=${product.productName}'">
       
      
      
      <input type="button" value="상품 페이지"
         onclick="location.href='ShoppingServlet?command=product_list'">
           </form>
   </div>
   
</body>
</html>