<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="./css/reset.css">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
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
            <li><a href="user_center_order.jsp">· 全部订单</a></li>

        </ul>
    </div>
</div>
<div class="right_content clearfix">
    <div class="info_con clearfix">
        <h3 class="common_title2">基本信息</h3>
        <form action="/updateUserInfo.do" method="post" accept-charset="UTF-8" enctype="multipart/form-data" target="_blank">
        <ul class="user_info_list">
            <li><span>头像 :</span><input type="file" name="img"><br></li>
            <li><span>用户名:</span><input type="text" name="username" value="${userInfo.username}"><br></li>
            <li><span>手机号:</span><input type="text" name="phone" value="${userInfo.phone}"><br></li>
            <li><span>性 别:</span><input type="radio"  name="sex" value="男" >男<input type="radio" checked="checked" name="sex" value="女">女<br></li>
            <li><span>地 址:</span><input type="text"name="address"value="${userInfo.getAddress()}" ><br></li>
            <li><span>邮 箱:</span><input type="text" name="email" value="${userInfo.getEmail()}"></li>
            <li><input type="submit" style="margin-left: 90px;" value="修改信息"></li>
            <br>
        </ul>
        </form>
    </div>
</div>
</body>
</html>
