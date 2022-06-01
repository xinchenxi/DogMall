<%--
  Created by IntelliJ IDEA.
  User: 99244
  Date: 2022/5/31
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
    <form action="/selectGoodsByOrderId.do" method="post">
        <input type="submit" value="selectGoodsByOrderId">
    </form>
<form action="/getOrderByOrderId.do" method="post">
    订单号为:<input type="text" name="orderId"><br>
    <input type="submit" value="getOrderByOrderId">
</form>
</body>
</html>
