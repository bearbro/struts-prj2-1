<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: bear
  Date: 2017/10/6
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="user!login" method="post">
    <table><!--添加表格，使对齐-->
        <tr>
            <td><s:textfield name="loginUser.account" label="用户名"/></td>
        </tr>
        <tr>
            <td><s:password name="loginUser.password" label="密码"/></td>
        </tr>

        <tr>
            <td>
                <s:submit name="sumbit" key="login.submit.button"/>
            </td>
            <td>
                <s:a href="register.jsp">注册</s:a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
