<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>장바구니</h2>
    <table>
        <tr>
            <th>상품 번호</th>
            <th>상품 이름</th>
            <th>가격</th>
            <th>수량</th>
            <th>총 가격</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${cartList}" var="cartItem">
            <tr>
                <td>${cartItem.productNo}</td>
                <td>${cartItem.productName}</td>
                <td>${cartItem.price}</td>
                <td>
                    <form action="cartController" method="post">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="cartNo" value="${cartItem.cartNo}">
                        <input type="number" name="cartQty" value="${cartItem.cartQty}" min="1" max="100">
                        <input type="submit" value="수정">
                    </form>
                </td>
                <td>${cartItem.totalPrice}</td>
                <td>
                    <form action="cartController" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="cartNo" value="${cartItem.cartNo}">
                        <input type="submit" value="삭제">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>