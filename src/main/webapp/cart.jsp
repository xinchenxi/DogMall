<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户界面</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css">
    <link rel="stylesheet" type="text/css" href="./css/main.css">


        <% if(request.getSession().getAttribute("user")==null) response.sendRedirect("/login.jsp"); %>
    <script type="text/javascript">
        if(sessionStorage.getItem("TotalPrice")==null) {
            sessionStorage.setItem("TotalPrice", 0)
            sessionStorage.setItem("TotalNum", 0)
        }
        function isClick(){

            aa=document.getElementById("checkgoods").value;
            var TotalPrice=sessionStorage.getItem("TotalPrice")
            sessionStorage.setItem("TotalPrice",aa);
            sessionStorage.setItem("TotalNum",1)
            window.location.href="/cart.jsp";
        }
    </script>
</head>
<body>
<div class="header_con">
    <div class="header">
        <div class="welcome fl">欢迎来到美多商城!</div>
        <div class="fr">
            <div class="login_btn fl">
                欢迎您：<em>${userInfo.username}</em>
                <span>|</span>
                <a @click="logout">退出</a>
            </div>
            <div class="user_link fl">
                <span>|</span>
                <a href="user_center_info.jsp">用户中心</a>
                <span>|</span>
                <a href="/listCart.do">我的购物车</a>
                <span>|</span>
                <a href="/selectGoodsByUserId.do">我的订单</a>
            </div>
        </div>
    </div>
</div>
<div class="search_bar clearfix">
    <a href="index.jsp" class="logo fl"><img src="./img/logo.png"></a>
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;购物车</div>
    <div class="search_con fr mt40">
        <input type="text" class="input_text fl" name="" placeholder="搜索商品">
        <input type="button" class="input_btn fr" name="" value="搜索">
    </div>
</div>
<div class="total_count">全部商品<em>${CartGoodsNum}</em>件</div>
<ul class="cart_list_th clearfix">
    <li class="col01">商品名称</li>
    <li class="col03">商品价格</li>
    <li class="col04">数量</li>
    <li class="col05">小计</li>
    <li class="col06">操作</li>
</ul>
<ul class="cart_list_td clearfix">
    <c:forEach var="cartGoods" items="${Cart}">
    <li><input type="checkbox" name="checkgoods" id="checkgoods" onclick="isClick()" value="${cartGoods.getGoodsprice()}"></li>
    <li class="col02"><img src="${cartGoods.getGoods().getImgurl()}"></li>
    <li class="col03">${cartGoods.getGoods().getGoodName()}</li>
    <li class="col05">${cartGoods.getGoods().getPrice()}</li>
    <li class="col06">
        <div class="num_add">
            <a @click="on_add(index)" class="add fl">+</a>
            <input name="GoddsName"value="${cartGoods.getGoodsnum()}" type="text" class="num_show fl">
            <a @click="on_minus(index)" class="minus fl">-</a>
        </div>
    </li>
    <li class="col07">${cartGoods.getGoodsprice()}</li>
    <li class="col08" style="margin-left: 100px"><a href="javascript:;">删除</a></li>
    </c:forEach>
</ul>
<ul class="settlements">
    <li class="col03">合计(不含运费)：<span>¥</span><em><script>document.write(sessionStorage.getItem("TotalPrice"))</script></em><br>共计<b><script>document.write(sessionStorage.getItem("TotalNum"))</script></b>件商品</li>
    <li class="col04"><a href="order.jsp">去结算</a></li>
</ul>
</body>
</html>
