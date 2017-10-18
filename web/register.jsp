<%--
  Created by IntelliJ IDEA.
  User: Bro、小熊
  Date: 2017/10/2
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head><sx:head extraLocales="utf-8"/><title>注册</title></head>
<body>
<s:form action="register" method="post">
    <s:textfield name="loginUser.account" key="reg.account.label"/>
    <s:password name="loginUser.password" key="reg.password.label"/>
    <s:password name="loginUser.repassword" key="reg.repassword.label"/>
    <s:textfield name="loginUser.name" key="reg.name.label"/>
    <s:radio name="loginUser.sex" list="#{ 1:getText('man'), 0:getText('woman')}" key="reg.sex.label"/>
    <sx:datetimepicker name="loginUser.birthday" displayFormat="yyyy-MM-dd" language="utf-8" key="reg.birthday.label"/>
    <s:textfield name="loginUser.address" key="reg.address.label"/>
    <s:textfield name="loginUser.phone" key="reg.phone.label"/>
    <s:textfield name="loginUser.email" key="reg.email.label"/>
    <s:submit key="reg.submit"/>
    <s:reset key="reg.reset"/>
</s:form>
</body>
</html>
