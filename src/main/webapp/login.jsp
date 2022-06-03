
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="./css/login.css">
    <script src="./js/login.js"></script>
    <script src="./js/api.js"></script>
</head>
<body>

<div id="particles-js">
    <form  class="login" action="/userLogin.do" method="post" >
        <div class="login-top"> 登录 </div>
        <!--用户名相关-->
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="./img/user/name.png"/></div>
            <div class="login-center-input">
                <input type="text" name="accounts" id="accounts"  placeholder="请输入您的账号"/>
                <div class="login-center-input-text">账号</div>
                <span id="usernameMsg"></span>
            </div>
        </div>
           <!--密码相关-->
  <div class="login-center clearfix">
    <div class="login-center-img"><img src="./img/user/password.png"/></div>
    <div class="login-center-input">
        <input type="password" name="password" id="password" placeholder="请输入您的密码" />
        <div class="login-center-input-text">密码</div>
        <span id="passwordMsg"></span>
    </div>
</div>
    <input class="login-button"
           style="border-style: hidden;margin-left: 50px;"type="submit" value="登录">
        <a href="register.jsp"><div class="login-button">注册</div> </a>
        <!--        返回首页-->
        <a href="index.jsp">
            <div class="login-button">回到首页 </div>
        </a>
    </form>
</div>
</body>
<!--<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>美多商城-登录</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">

    <script type="text/javascript" src="js/vue-2.5.16.js"></script>
    <script type="text/javascript" src="js/axios-0.18.0.min.js"></script>
    <script type="text/javascript" src="js/host.js"></script>



    <script type="text/javascript">
        var name = localStorage.name;
        var name2 = sessionStorage.name2;
        alert(name + ":" + name2)
    </script>
    -->

<!--</head>
<body>
<div class="login_top clearfix">
<a href="index.html" class="login_logo"><img src="./images/logo02.png"></a>
</div>
<div class="login_form_bg">
<div class="login_form_wrap clearfix">
    <div class="login_banner fl"></div>
    <div class="slogan fl">商品美 · 种类多 · 欢迎光临</div>
    <div class="login_form fr" id="app">
        <div class="login_title clearfix">
            <a href="javascript:;" class="cur">账户登录</a>
        </div>
        <div class="form_con">
            <div class="form_input cur">
                <form @submit.prevent="on_submit" action="/userLogin.do">
                    <input type="text" name="accounts"
                           v-model="username" @blur="check_username"
                           class="name_input" placeholder="请输入用户名">

                    <div v-show="error_username" class="user_error">请求输入用户名</div>
                    <input type="password" name="password"
                           v-model="password" @blur="check_pwd"
                           class="pass_input" placeholder="请输入密码">
                    <div class="pwd_error" v-show="error_pwd" >{{ error_pwd_message }}</div>
                    <div class="more_input clearfix">
                        <input type="checkbox" v-model="remember" name="">
                        <label>记住登录</label>
                        <a href="/find_password.html">忘记密码</a>
                    </div>
                    <input type="submit" name="" value="登 录" class="input_submit">
                </form>
            </div>
        </div>
        <div class="third_party">
            <a href="#" class="qq_login" @click="qq_login">QQ</a>
            <a href="#" class="weixin_login">微信</a>
            <a href="/register.html" class="register_btn">立即注册</a>
        </div>

    </div>
</div>
</div>-->

<!--<div class="footer no-mp">
    <div class="foot_link">
        <a href="#">关于我们</a>
        <span>|</span>
        <a href="#">联系我们</a>
        <span>|</span>
        <a href="#">招聘人才</a>
        <span>|</span>
        <a href="#">友情链接</a>
    </div>
    <p>CopyRight © 2016 北京美多商业股份有限公司 All Rights Reserved</p>
    <p>电话：010-****888    京ICP备*******8号</p>
</div>

<script type="text/javascript" src="js/login.js"></script>-->
</body>
</html>
