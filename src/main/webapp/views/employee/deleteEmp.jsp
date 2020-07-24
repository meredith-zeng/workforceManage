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
    <title>删除员工信息</title>
</head>
<body>
    <h1>删除员工信息</h1>
    <hr>
    <form action="../../servlet/DeleteEmployee" method="post">
        请输入要删除的员工工号:
        <input type="text" name="empNo">
        <input type="submit" value="提交">
    </form>
</body>
</html>
