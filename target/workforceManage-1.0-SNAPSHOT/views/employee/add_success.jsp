<%@ page import="model.Employee" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/21
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="./css/table.css" type="text/css">
<link rel="stylesheet" href="./css/form.css" type="text/css">
<html>
<head>
    <title>成功增加成员</title>
</head>
<body>
<h1>已经添加如下公司员工到公司员工列表</h1>
<hr>
<div id="addResult">
    <table class="pure-table">
        <thead>
        <tr>
            <td>工号</td>
            <td>姓名</td>
            <td>工作部门</td>
        </tr>
        </thead>
        <tbody>
        <%
            Employee employeeAdd = (Employee)request.getSession().getAttribute("employee");
        %>
        <tr>
            <td>
                ${sessionScope.employee.getEmpNo()}
            </td>
            <td>
                ${sessionScope.employee.getEmpName()}
            </td>
            <td>
                ${sessionScope.employee.getWorkSection()}
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
