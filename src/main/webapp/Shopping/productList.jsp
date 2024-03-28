<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>Insert title here</title>
</head>
<body>
<div id="wrap" align="center">
      <h1>상품 페이지</h1>
      <table class="list">

         <tr>
            <th>상품번호</th>
            <th>    </th>
            <th>상품카테고리</th>
            <th>   </th>
            <th>상품명</th>
            <th>    </th>
            <th>가격</th>
            <th>   </th>
            <th>수량</th>
            <th>   </th>
            <th>상품소개</th>
            <th>       </th>
            <th>등록일</th>
            
         </tr>
         <c:forEach var="product" items="${productlist}">
            <tr class="record">
               <td>${product.productKey}</td>
               <td>    </td>
               <td>${product.productCategory}</td>
               <td>    </td>
               <td><a href = "ShoppingServlet?command=product_view&productName=${product.productName}">
               ${product.productName}</a></td>
               <td>    </td>
               <td>${product.productPrice}</td>
               <td>    </td>
               <td>${product.productStock}</td>
               <td>    </td>
               <td>${product.productDescription}</td>
               <td>    </td>
               <td>${product.productdate}</td>
            </tr>
         </c:forEach>
      </table>
   </div>
</body>
</html>