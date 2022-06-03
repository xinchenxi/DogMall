<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户界面</title>
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
            <li><a href="/selectGoodsByUserId.do">· 全部订单</a></li>
        </ul>
    </div>
</div>
<div class="right_content clearfix">
    <div class="info_con clearfix">
        <h3 class="common_title2">修改密码</h3>
        <div class="site_con pass_change_con">
            <form action="/updatePassword.do" method="post">
                <div class="form_group">
                    <label>当前密码：</label>
                    <input type="password" name="oldpassword">
                </div>
                <div class="form_group">
                    <label>新密码：</label>
                    <input type="password" name="newpassword">
                </div>
                <div class="form_group">
                    <label>确认新密码：</label>
                    <input type="password" name="twicepassword">
                </div>
                <input type="submit"  value="确认修改" class="info_submit">
            </form>
        </div>
    </div>

</div>
</body>
</html>
