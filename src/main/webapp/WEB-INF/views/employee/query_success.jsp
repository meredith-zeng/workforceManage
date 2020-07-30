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
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../../static/css/dashboard.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

<!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
<script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>

<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>


<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<style>
    ul.pagination {
        display: inline-block;
        padding: 0;
        margin: 0;
    }

    ul.pagination li {display: inline;}

    ul.pagination li a {
        color: black;
        float: left;
        padding: 8px 16px;
        text-decoration: none;
    }


</style>
<!DOCTYPE html>
<html>
<head>
    <title>公司员工列表</title>
</head>
<body>
<div class="container-fluid">
<%--    <nav class="navbar navbar-inverse navbar-fixed-top">--%>
<%--        <div class="container-fluid">--%>
<%--            <div class="navbar-header">--%>
<%--                <a class="navbar-brand" href="#">Project name</a>--%>
<%--            </div>--%>
<%--            <div id="navbar" class="navbar-collapse collapse">--%>
<%--                <ul class="nav navbar-nav navbar-right">--%>
<%--                    <li><a href="#">登出</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </nav>--%>
<%--    <div class="container-fluid">--%>
<%--        <div class="row">--%>
<%--            <div class="col-sm-3 col-md-2 sidebar">--%>
<%--                <ul class="nav nav-sidebar">--%>
<%--                    <li><a href="/Employee/addEmployee">增加员工信息</a></li>--%>
<%--                    <li><a href="/Employee/deleteEmployee">删除员工信息</a></li>--%>
<%--                    <li><a href="/Employee/updateEmployee">修改员工信息</a></li>--%>
<%--                    <li><a href="/Employee/selectEmployee">查询员工信息</a></li>--%>
<%--                    <li><a href="/Employee/fireEmployee">员工离职</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


    <div class="container-fluid">
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <h3 class="page-header">公司全体员工信息</h3>
                <div class="table-responsive">
                    <table class="table table-striped">
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
                        <c:choose>
                            <c:when test="${not empty requestScope.pageInfo}">
                                <c:forEach items="${requestScope.pageInfo.list}" var="employee">
                                    <tr>
                                        <td>${employee.empNo}</td>
                                        <td>${employee.empName}</td>
                                        <td>${employee.workSection}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="2">
                                        查无结果
                                    </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>

                        </tbody>
                    </table>
                </div>
                <div>
                    <ul class="pagination">
                    <c:forEach  begin="1" end="${pageInfo.pages}" var="i">
                            <li><a href="${pageContext.request.contextPath}/Employee/queryEmployeeShow?pageNum=${i}">${i}</a></li>
                    </c:forEach>
                    </ul>
                </div>
            </div>
    </div>
</div>

</body>
</html>
