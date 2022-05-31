<%--
  Created by IntelliJ IDEA.
  User: 99244
  Date: 2022/5/26
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求goods</title>
</head>
<body>
    <form action="/setGoodsStatus.do" method="post">
        <input type="submit" value="测试setStatus">
    </form>
    <form action="/deleteGoodsById.do" method="post">
        <input type="submit" value="deleteGoodsById">
    </form>
    <form action="/updateGoods.do" method="post">
        goodId:<input type="text" name="goodId"><br>
        goodName <input type="text" name="goodName"><br>
        nums <input type="text" name="nums"><br>
        price <input type="text" name="price"><br>
        supplierId<input type="text" name="supplierId"><br>
        describe<input type="text" name="describe"><br>
        imgurl <input type="text" name="imgurl"><br>
        status<input type="text" name="status"><br>
        <input type="submit" value="updateGoods"><br>
    </form>
    <form action="/insertGoods.do" method="post">
        goodId:<input type="text" name="goodId"><br>
        goodName <input type="text" name="goodName"><br>
        nums <input type="text" name="nums"><br>
        price <input type="text" name="price"><br>
        supplierId<input type="text" name="supplierId"><br>
        describe<input type="text" name="describe"><br>
        imgurl <input type="text" name="imgurl"><br>
        status<input type="text" name="status"><br>
        <input type="submit" value="insertGoods"><br>
    </form>
<form action="/listGoods.do" method="post">
    <input type="submit" value="listGoods">
</form>
    <form action="/ListGoodPages.do" method="post">
        <input type="submit" value="测试ListGoodPages">
    </form>
    <form action="/getListGoodsBySupplierId.do" method="post">
        <input type="submit" value="getListGoodsBySupplierId">
    </form>
    <form action="/findGoodsByPager.do" method="post">
        <input type="submit" value="findGoodsByPager">
    </form>
<form action="/updatePicture.do" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
    <input type="text" name="goodId">
    <input type="file" name="file">
    <input type="submit" value="提交商品图片">
</form>
</body>
</html>
