<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
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
<table border="1">
<s:iterator value="#session.shoppingCart.itemsOrdered">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>说明</th>
        <th>单价</th>
        <th>数量</th>
    </tr>
    <tr>
        <td><S:property value="item.itemID"/></td>
        <td><s:property value="item.name"/></td>
        <td><s:property value="item.description"/></td>
        <td><s:property value="item.cost"/></td>
        <td><s:property value="numItems"/></td>
    </tr>
</s:iterator>
</table>
</body>
</html>
