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
    <title>修改员工信息</title>
</head>
<body>
<h1>修改员工信息</h1>
<hr>
<form action="../../servlet/UpdateEmployee" method="post">
    输入要修改员工的工号:
    <input type="text" name="empNo">
    请输入修改后姓名:
    <input type="text" name="empName">
    请输入修改后工作单位:
    <input type="text" name="workSection">
    <input type="submit" value="确认修改">
</form>
</body>
</html>
