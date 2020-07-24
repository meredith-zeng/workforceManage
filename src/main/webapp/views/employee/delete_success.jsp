<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/22
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="./css/form.css" type="text/css">
<link rel="stylesheet" href="./css/table.css" type="text/css">
<html>
<head>
    <title>成功删除</title>
</head>
<body>
<h1>成功删除</h1>
<hr>
<div id="deleteResult" class="pure-table">
        <table class="pure-table">
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
                    ${sessionScope.deleteEmployeeInfo.getEmpNo()}
                </td>
                <td>
                    ${sessionScope.deleteEmployeeInfo.getEmpName()}
                </td>
                <td>
                    ${sessionScope.deleteEmployeeInfo.getWorkSection()}
                </td>
            </tr>
            </tbody>
        </table>
</div>
</body>
</html>
