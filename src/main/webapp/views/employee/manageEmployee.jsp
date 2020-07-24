<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/23
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="./css/ul.css" type="text/css">
<link rel="stylesheet" href="./css/form.css" type="text/css">
<html>
<head>
    <title>管理员工信息</title>
</head>
<body>
<h1>欢迎来到阿曾的Java web多权限人力资源管理系统</h1>
<hr>
<div>
    <ul>
        <li><a href="addEmp.jsp">增加员工信息</a></li>
        <li><a href="deleteEmp.jsp">删除员工信息</a></li>
        <li><a href="updateEmp.jsp">修改员工信息</a></li>
        <li><a href="selectEmp.jsp">查询员工信息</a></li>
        <li><a href="empLeave.jsp">员工离职</a></li>
    </ul>
</div>
<div>
        <form action="../../servlet/LogoutServlet" method="post">
            <input type="submit" value="登出">
        </form>

</div>
</body>
</html>
