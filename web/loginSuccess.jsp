<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Bro、小熊
  Date: 2017/10/2
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<s:actionmessage/>
<s:text name="login.success"/>
<s:text name="login.label1"/>&nbsp; <s:property value="count"/><s:text name="login.label2"/><br>
本站访问次数：<s:property value="#application.counter"/><br>
<s:property value="#session.user"/>,
<s:property value="#request.tip"/>
</body>
</html>
