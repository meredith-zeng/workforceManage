<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/21
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="./css/form.css" type="text/css">
<html>
<head>
    <title>查询员工信息</title>
</head>
<body>
<h1>查询员工信息</h1>
<hr>
<form action="../../servlet/SelectEmployee" method="post">
    请输入要查询的员工工号:
    <input type="text" name="selectEmpNo">
    <input type="submit" value="查询">
</form>
<div id="queryAll">
    <form action="../../servlet/QueryEmployeeServlet" method="post">
        <input type="submit" value="查询所有员工">
    </form>
</div>
</body>
</html>
