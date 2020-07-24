<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/21
  Time: 17:17
  To change this template use File | Settings | File Templates.


  功能:添加员工

  说明:利用表单获取新增员工数据,展示新增加的员工信息

  要求:jsp页面里使用jstl+el表达式,不允许出现java代码

  对应处理逻辑:control.servlet.AddEmployeeServlet

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="./css/form.css" type="text/css">
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>增加员工信息</title>
</head>
<body>
<h1>增加员工信息</h1>
<hr>
<div id="add" >
    <form action="../../servlet/AddEmployee" method="post">
        工号:<input type="text" name="empNo" />

        姓名:<input type="text" name="empName" />
        工作部门:<input type="text" name="workSection" />
        <input type="submit">
    </form>
</div>

</body>
</html>
