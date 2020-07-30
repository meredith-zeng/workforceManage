<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/22
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>成功删除</title>
</head>
<body>
<h1>成功删除</h1>
<hr>
<div id="deleteResult" class="pure-table">
<h2>工号为</h2>
    <p>${empNo}</p>
    <p>的员工</p>
</div>
</body>
</html>
