<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: bear
  Date: 2017/10/6
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<s:fielderror/>
<s:actionerror/>
<form action="login" method="post">
    <table><!--添加表格，使对齐-->
        <tr>
            <td><s:textfield name="loginUser.account" key="login.account.label"/></td>
        </tr>
        <tr>
            <td><s:password name="loginUser.password" key="login.password.label"/></td>
        </tr>

        <tr>
            <td>
                <s:submit name="sumbit" key="login.submit.button"/>
            </td>
            <td>
                <s:a href="register.jsp"><s:text name="register.label"/></s:a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
