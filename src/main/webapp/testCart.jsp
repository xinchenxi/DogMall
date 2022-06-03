<%--
  Created by IntelliJ IDEA.
  User: 99244
  Date: 2022/5/28
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestCart</title>
</head>
<body>
    <form action="/ListAllGoodsByUserId.do" method="post">
        <input type="submit" value="ListAllGoodsByUserId">
    </form>
<form action="insertGoodsToCart.do" method="post">
    <input type="submit" value="insertGoodsToCart">
</form>
<form action="/priceIncheckGoods.do" method="post">
    <input type="submit" value="priceIncheckGoods">
</form>
<form action="/listCart.do" method="post">
    <input type="submit" value="列出商品">
</form>
</body>
</html>
