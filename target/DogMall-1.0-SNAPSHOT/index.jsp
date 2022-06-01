<%@ page import="com.cdut.Pojo.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
life is a fucking movie.
<form action="/userService.do" method="post">
    <input type="submit" value="提交">
</form>

<form action="/getUserByAccount.do" method="post">
    <input type="text" name="account" >
    <input type="submit" value="提交账号">
</form>
<form action="/insertUser.do" method="post">
    账号:<input type="text" name="account"><br>
    密码<input type="password" name="password"><br>
    <input type="submit" value="提交"><br>
</form>
<form action="/updateUserPassword.do" method="post">
    <input type="hidden" value="978691824795254784" name="userid"><!--<%session.getAttribute("userId");%>-->
    旧密码:<input type="password" name="oldpassword"><br>
    新密码:<input type="password" name="newpassword"><br>
    <input type="submit" value="提交">
</form>
<form action="/updateUser.do" method="post">
    <input type="submit" value="updateUser">
</form>
<form action="/listAllUserFavorite.do" method="post">
    <input type="submit" value="测试UserFavorite">
</form>

<form action="/deteleUserById.do" method="post">
    <input type="text" name="account">
    <input type="submit" value="deteleUserById">
</form>

<form accept-charset="UTF-8" action="/upload.do" method="post" enctype="multipart/form-data" target="_blank">
    文件:<input type="file" name="file"/>
    <input type="submit" value="上传"/>
</form>
<form action="/userLogin.do" method="post">
    账号:<input type="text" name="account"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登陆">
</form>
<form action="/updateUserInfo.do" method="post" accept-charset="UTF-8" enctype="multipart/form-data" target="_blank">
    用户名:<input type="text" name="username" value="${userInfo.username}"><br>
    性别 :<input type="text" name="sex" value="${userInfo.sex}"><br>
    邮箱 :<input type="text" name="email" value="${userInfo.getEmail()}"><br>
    地址 :<input type="text"name="address"value="${userInfo.getAddress()}" ><br>
    电话 :<input type="text" name="phone" value="${userInfo.getPhone()}"><br>
    头像 :<input type="file" name="img"><br>
    <input type="submit" value="修改信息">
</form>
<form action="/updatePassword.do" method="post">
    原密码:<input type="password" name="oldpassword">
    新密码:<input type="password" name="newpassword">
    <input type="submit" value="修改密码">
</form>
</body>
</html>
