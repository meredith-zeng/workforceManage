<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/22
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>成功开除</title>
</head>
<body>

<h1>这兄弟被你开了</h1>
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

        <tbody>
        <tr>
            <td>
                ${fireEmployee.empNo}
            </td>
            <td>
                ${fireEmployee.empName}
            </td>
            <td>
                ${fireEmployee.workSection}
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
