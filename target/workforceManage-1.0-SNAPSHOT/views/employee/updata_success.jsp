<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/22
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="./css/table.css" type="text/css">
<link rel="stylesheet" href="./css/form.css" type="text/css">
<html>
<head>
    <title>更新后员工信息</title>
</head>
<body>
<h1>更新后员工信息</h1>
<hr>
<div id="updataResult" class="pure-table">
    <table>
        <thead>
        <tr>
            <td>工号</td>
            <td>姓名</td>
            <td>工作部门</td>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>
                ${sessionScope.UpdataEmployee.getEmpNo()}
            </td>
            <td>
                ${sessionScope.UpdataEmployee.getEmpName()}
            </td>
            <td>
                ${sessionScope.UpdataEmployee.getWorkSection()}
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
