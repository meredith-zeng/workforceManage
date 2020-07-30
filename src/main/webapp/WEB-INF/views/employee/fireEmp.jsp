<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/21
  Time: 17:19
  To change this template use File | Settings | File Templates.

  功能:实现员工离职

  说明:查询指定工号员工,展示员工信息,删除指定员工信息,展示删除成功弹窗

  要求:jsp页面里使用jstl+el表达式,不允许出现java代码

  对应处理逻辑:control.EmployeeLeave
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>员工离职</title>
</head>
<body>
<h1><c:out value="员工要跑路啦"></c:out></h1>
<h1><c:out value="快把员工开了"></c:out></h1>
<form method="post" action="${pageContext.request.contextPath}/Employee/fireEmployee">
    请输入要开除的员工工号:
    <input type="text" name="empNo">
    <input type="submit" value="提交">
</form>

</body>
</html>
