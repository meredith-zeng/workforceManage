<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/29
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>阿曾的Java web多权限人力资源管理系统</title>
</head>
<body>
<jsp:useBean id="User" class="model.User" scope="session"/>
<%--@elvariable id="User" type="model.User"--%>

    <h1>用户登陆页面</h1>
    <hr/>
<form method="post" action="${pageContext.request.contextPath}/user/login">
    <div id="main">
        <table>
            <tr>
                <td>账号：</td>
                <td><input type="text" name="userId" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password"  name="userPassword"/></td>
            </tr>

            <tr>
                <td colspan="1">
                </td>
                <td><input type="submit" value="登录"/></td>
            </tr>
        </table>
    </div>
    </form>
</form>
</body>
</html>
