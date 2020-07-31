<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/23
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>管理员工信息</title>
</head>
<body>
<h1>欢迎来到阿曾的Java web多权限人力资源管理系统</h1>
<hr>
<div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/Employee/addEmployee">增加员工信息</a></li>
        <li><a href="${pageContext.request.contextPath}/Employee/deleteEmployee">删除员工信息</a></li>
        <li><a href="${pageContext.request.contextPath}/Employee/updateEmployee">修改员工信息</a></li>
        <li><a href="${pageContext.request.contextPath}/Employee/selectEmployee">查询员工信息</a></li>
        <li><a href="${pageContext.request.contextPath}/Employee/fireEmployee">员工离职</a></li>
    </ul>
</div>
<div>
        <form action="${pageContext.request.contextPath}/user/logout">
            <input type="submit" value="登出">
        </form>

</div>
</body>
</html>
