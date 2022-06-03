<%--
  Created by IntelliJ IDEA.
  User: 99244
  Date: 2022/6/1
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./css/register.css">
    <title>register</title>
</head>
<body>
    <div id="particles-js">
        <form class="login" action="/register.do" method="post">
            <div class="login-top"> 注册</div>
            <!--        用户名相关-->
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="./img/user/name.png"/></div>
                <div class="login-center-input">
                    <input type="text" name="account" id="username" placeholder="请输入您的账号"/>
                    <div class="login-center-input-text">账号</div>
                    <span id="usernameMsg"></span>
                </div>
            </div>
            <!--        密码相关-->
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="./img/user/password.png"/></div>
                <div class="login-center-input">
                    <input type="password" name="password" id="password" placeholder="请输入您的密码"/>
                    <div class="login-center-input-text">密码</div>
                    <span id="passwordMsg"></span>
                </div>
            </div>

            <!--        确认密码相关-->
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="./img/user/password.png"/></div>
                <div class="login-center-input">
                    <input type="password" name="confirmPassword" id="confirmPassword" placeholder="请再次输入您的密码"/>
                    <div class="login-center-input-text">确认密码</div>
                    <span id="confirmPasswordMsg"></span>
                </div>
            </div>

                <input class="login-button"
                       style="border-style: hidden;margin-left: 50px;" type="submit" value="注册">
            <a href="login.jsp">
                <div class="login-button">登陆</div></a>
            <!--        返回首页-->
            <a href="index.jsp">
                <div class="login-button">回到首页</div>
            </a>
        </form>
    </div>
</body>
</html>
