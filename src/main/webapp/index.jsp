<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <input type="submit" value="deteleUserById">
</form>
</body>
</html>
