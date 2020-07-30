<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/21
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>修改员工信息</title>
</head>
<body>
<h1>修改员工信息</h1>
<hr>

<%--@elvariable id="updateEmployee" type="model.Employee"--%>
    <form:form modelAttribute="updateEmployee" method="post" action="${pageContext.request.contextPath}/Employee/updateEmployee">
        输入要修改员工的工号:
        <form:input type="text" name="empNo" path="empNo"/>
        请输入修改后姓名:
        <form:input type="text" name="empName" path="empName"/>
        请输入修改后工作单位:
        <form:input type="text" name="workSection" path="workSection"/>
        <input type="submit" value="确认修改">
    </form:form>
</body>
</html>
