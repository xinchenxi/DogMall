<%--
  Created by IntelliJ IDEA.
  User: 99244
  Date: 2022/5/23
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果</title>
</head>
<body>
<!--用户数量为:${nums}<br>
用户信息为:${allUsers}<br>
根据账号查询用户为: ${getuser}<br>
根据账号查询用户信息:${info}<br>
插入后用户的信息为:${users}<br>
修改用户密码后的用户信息为:${user1}<br>
用户头像:<img src="${user_Avator}"><br>-->

用户id:<%=session.getAttribute("userId")%><br>
用户名:<%=session.getAttribute("userName")%><br>
用户头像 <img src="<%=session.getAttribute("userImg")%>"><br>
用户账号:<%=session.getAttribute("user")%><br>
用户信息:<%=session.getAttribute("userInfo")%><br>
用户头像:<img src="${userInfo.img}" ><br>
msg: ${msg}<br>
收藏夹 : ${userFavorite}<br>
</body>
</html>
