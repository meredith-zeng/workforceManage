<%@ page import="model.Employee" %><%--
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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>增加员工信息</title>
</head>
<body>
<h1>增加员工信息</h1>
<hr>
<div id="add" >
    <%--@elvariable id="addEmployee" type="model.Employee"--%>
    <form:form modelAttribute="addEmployee" method="post" action="${pageContext.request.contextPath}/Employee/addEmployee" enctype="multipart/form-data">
        工号:<form:input type="text"   path="empNo"/>

        姓名:<form:input type="text"  path="empName"/>
        工作部门:<form:input type="text"  path="workSection"/>
        选择头像文件:<input type="file" name="img"/>
        <input type="submit">
    </form:form>
</div>

</body>
</html>
