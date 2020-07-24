<%@ page import="model.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/22
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="./css/table.css" type="text/css">
<link rel="stylesheet" href="./css/form.css" type="text/css">
<html>
<head>
    <title>公司员工列表</title>
</head>
<body>
<h1>公司员工列表</h1>
<hr>
<div id="selectResult" class="pure-table">
    <table class="pure-table">
        <thead>
        <tr>
            <td>工号</td>
            <td>姓名</td>
            <td>工作部门</td>
        </tr>
        </thead>
<%--        req.getSession().setAttribute("empList",empList);--%>
<%--        List<Employee> empList = new ArrayList<>();--%>
        <tbody>
        <c:forEach items="${sessionScope.empList}" var="employee">
            <tr>
                    <td>${employee.getEmpNo()}</td>
                    <td>${employee.getEmpName()}</td>
                    <td>${employee.getWorkSection()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
