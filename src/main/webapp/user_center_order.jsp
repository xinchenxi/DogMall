<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户中心</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
</head>
<body>
<% if(request.getSession().getAttribute("user")==null) response.sendRedirect("/login.jsp"); %>
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
                <a href="cart.jsp">我的购物车</a>
                <span>|</span>
                <a href="user_center_order.jsp">我的订单</a>
            </div>
        </div>
    </div>
</div>
<div class="search_bar clearfix">
    <a href="index.jsp" class="logo fl"><img src="./img/logo.png"></a>
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
    <form method="get" action="/ListGoodPages.do" class="search_con fr mt40">
        <input type="text" class="input_text fl" name="goodsname" placeholder="搜索商品">
        <input type="submit" class="input_btn fr" name="" value="搜索">
    </form>
</div>
<div class="main_con clearfix">
    <div class="left_menu_con clearfix">
        <h3>用户中心</h3>
        <ul>
            <li><a href="user_center_info.jsp" class="active">· 个人信息</a></li>
            <li><a href="user_center_pass.jsp">· 修改密码</a></li>
            <li><a href="/selectGoodsByUserId.do">· 全部订单</a></li>

        </ul>
    </div>
</div>
<div class="right_content clearfix">
    <h3 class="common_title2">全部订单</h3>
    <ul class="order_list_th w978 clearfix">
        <c:forEach var="order" items="${orders}">
            <c:forEach var="goods" items="${order.getGoods()}" varStatus="status">
                <c:if test="${status.first}">
        <li class="col01">订单日期:${order.date}</li>
        <li class="col02">订单号 : ${order.orderId}</li>
                </c:if>
    </ul>
    <table class="order_list_table w980">
        <tbody>
        <tr>
            <td width="55%">

                <ul class="order_goods_list clearfix">
                    <li class="col01"><img src="${goods.getGoods().getImgurl()}"></li>
                    <li class="col02">${goods.getGoods().getGoodName()}<em>${goods.getGoods().getPrice()}</em></li>
                    <li class="col03">${goods.getGoodNum()}</li>
                    <li class="col04">${goods.getGoodsPrice()}</li>
                </ul>
            </td>
            <td width="15%"colspan="2">${order.getOrderprice()}</td>
            <td width="15%">支付宝</td>
            <td width="15%"><a href="#" class="oper_btn">去付款</a></td>
        </tr>
                    </c:forEach>
                </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
