<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
    <h1>장바구니</h1>
    
    <c:if test="${not empty list}">
        <table border="1">
            <tr>
                <th>상품 번호</th>
                <th>상품명</th>
                <th>상품 가격</th>
                <th>수량</th>
                <th>합계</th>
                <th>삭제</th>
                <th>수정하기</th>
            </tr>
            <c:forEach items="${list}" var="cartItem">
                <tr>
                    <td>${cartItem.productDTO.productNo}</td>
                    <td>${cartItem.productDTO.productName}</td>
                    <td>${cartItem.productDTO.productPrice}</td>
                    <td>${cartItem.cartQty}</td>
                    <td>${cartItem.productDTO.productPrice * cartItem.cartQty}</td>
                    <td>
                        <form action="cartController" method="post">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="cartNo" value="${cartItem.cartNo}">
                            <button type="submit">삭제</button>
                        </form>
                    </td>
                    <td>
                        <button class="updateBtn">수정하기</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    
    <h2>장바구니에 상품 추가</h2>
    <form action="cartController" method="post">
        <!-- 액션을 insert로 설정하여 서블릿에게 상품 추가 요청을 보냄 -->
        <input type="hidden" name="action" value="insert">
        <label for="productNo">상품 번호:</label>
        <input type="text" id="productNo" name="productNo"><br>
        <label for="cartQty">수량:</label>
        <input type="text" id="cartQty" name="cartQty"><br>
        <!-- 서브밋 버튼 클릭 시 상품 추가를 요청 -->
        <button type="submit">장바구니에 추가</button>
    </form>

<!-- 장바구니 리스트 -->
<div class="cartList show table-container">
   <h1>CART페이지 입니다. </h1>
   <form name="cartForm" method="post" id="cartForm" action='cartController'>
      <table class="col-12">
      
         <tr class="table-header">
            <th class="hide header__item">cartNo</th>
            <th class="header__item" style="padding:20px">check</th>
            <th class="hide header__item">productNo</th>
            <th class="header__item">product Name</th>
            <th class="header__item">color</th>
            <th class="header__item">size</th>
            <th class="header__item">price</th>
            <th class="header__item">QTY</th>
            <th class="header__item">total price</th>
            <th class="header__item">update</th>
            <th class="header__item">delete</th>
         </tr>
         <c:choose>
            <c:when test="${empty list}">
               <tr>
                  <td colspan="10" class="table-data">
                     <p align="center"><b>
                     <span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
                  </td>
               </tr>
            </c:when>
            <c:otherwise>
               <c:forEach var="cart" items="${list}">
                  <tr class="">
                     <td class="hide table-data">${cart.cartNo}</td>
                     <td class="table-data"><input type="checkbox"></td>
                     <td class="hide table-data">${cart.productDTO.productNo}</td>
                     <td class="table-data">${cart.productDTO.productName}</td>
                     <td class="table-data">${cart.productDTO.productColor}</td>
                     <td class="table-data">${cart.productDTO.productSize}</td>
                     <td class="table-data">${cart.productDTO.productPrice}</td>
                     <td class="table-data"><input type="number" min="1" step="1" value="${cart.cartQty}" name="cartQty" id="qty" class="input-number"></td>
                     <td class="table-data">${cart.cartQty * cart.productDTO.productPrice}</td>
                     <td class="table-data"><button class="updateBtn">수정하기</button></td>
                     <td class="table-data">
                        <form action="cartController" method="post">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="cartNo" value="${cart.cartNo}">
                            <button class="deleteBtn">삭제하기</button>
                        </form>
                     </td>
                  </tr>
               </c:forEach>
            </c:otherwise>
         </c:choose>
      </table>
   </form>

   <div>
      <form  method="post" id="buyForm">
      <span class="gutter--xxl">
         <input type="checkbox" id="allCheck" value="전체선택" class="gutter--xxl">전체선택
      </span>
         <input type="button" name="buyBtn" value="구매하기" class="cart--btn col-12">
      </form>
   </div>
</div>

<script type="text/javascript">
   $(document).ready(function(){
      // 수정하기 버튼 클릭 시
      $(".updateBtn").click(function(){
         $(this).closest("tr").find(".input-number").prop('disabled', false);
      });

      // 구매하기 버튼 클릭 시
      $(".cart--btn").click(function(){
         var selectedProducts = [];
         $("input[type=checkbox]:checked").each(function(){
            var productNo = $(this).closest("tr").find(".hide:eq(0)").text();
            var productName = $(this).closest("tr").find(".table-data:eq(2)").text();
            var productColor = $(this).closest("tr").find(".table-data:eq(3)").text();
            var productSize = $(this).closest("tr").find(".table-data:eq(4)").text();
            var productPrice = $(this).closest("tr").find(".table-data:eq(5)").text();
            var cartQty = $(this).closest("tr").find(".input-number").val();
            selectedProducts.push({
               "productNo": productNo,
               "productName": productName,
               "productColor": productColor,
               "productSize": productSize,
               "productPrice": productPrice,
               "cartQty": cartQty
            });
         });

         // 선택한 상품 정보를 서버에 전송
         $.ajax({
            type: "POST",
            url: "cartController",
            data: JSON.stringify(selectedProducts),
            contentType: "application/json",
            success: function(response) {
               // 서버로부터 받은 응답에 따른 처리 (예: 구매 완료 메시지 출력)
               alert("구매가 완료되었습니다.");
               // 페이지 새로고침 또는 필요한 처리 수행
               window.location.reload();
            },
            error: function(xhr, status, error) {
               // 오류 발생 시 처리
               console.error(xhr.responseText);
               alert("구매 과정에서 오류가 발생했습니다. 다시 시도해주세요.");
            }
         });
      });
   });
</script>
</body>
</html>