<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/22
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>查询结果</title>
</head>
<body>

<h1>指定员工信息如下</h1>
<hr>
<div id="selectResult" class="pure-table">
    <table class="pure-table">
        <thead>
        <tr>
            <td>工号</td>
            <td>姓名</td>
            <td>工作部门</td>
            <td>员工头像</td>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>
                ${selectEmp.empNo}
            </td>
            <td>
                ${selectEmp.empName}
            </td>
            <td>
                ${selectEmp.workSection}
            </td>
            <td>
                <img src="${selectEmp.empImg}" alt="员工头像">
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
