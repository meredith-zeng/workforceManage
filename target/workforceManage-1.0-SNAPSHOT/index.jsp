<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/21
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>

    input[type=text], input[type=password]{
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }


</style>
<html>
<head>
    <title>阿曾的多权限人力资源管理系统</title>
</head>
<body>

已注册的用户，去<a href="${pageContext.request.contextPath }/index/login"> 登录</a>！

</body>
</html>
