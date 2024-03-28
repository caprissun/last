<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="script/board.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="wrap" align="center">
      <h1>무통장 입금만 가능합니다</h1>  
      <form action="ShoppingServlet" name=frm method="post">
      <input type="hidden" name="command" value="product_Order">
      <table>  
         <tr>
     <th>상품명</th>
            <td>${product.productName}</td>
       </tr>
         <tr>
            <th>가격</th>
            <td colspan="3">${product.productPrice }원</td>
         </tr>
         <c:forEach var="product" items="${productlist}">
            <tr class="record">
               <td>${product.productKey}</td>
               <td>    </td>
               <td>${product.productCategory}</td>
      
            </tr>
            
         </c:forEach>
         
         <tr>
            <th>은행</th>
            <td>입금하실 은행을 선택해주세요.</td>

         </tr>
          <c:forEach var="bank" items="${bankList}">
            <tr class="record">
                <td><a href = "ShoppingServlet?command=bank_account&bankName=${bank.bankName}">
               ${bank.bankName}</a></td>
               <td>${bank.accountNum}</td>
               
              
              
            </tr>
         </c:forEach>


</table>
      
      <input type="button" value="상품 페이지"
         onclick="location.href='ShoppingServlet?command=product_list'">
           </form>
   </div>
   
</body>
</html>