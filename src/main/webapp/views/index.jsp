<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/20
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>



<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Hello Index!!!!!!!~~~~~~~~~~~~~~~~</h1>
<table>
    <tr>
        <th>empId</th>
        <th>empName</th>
        <th>gender</th>
        <th>email</th>
        <th>deptName</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${employees}" var="e">
        <tr>
            <th>${e.empId}</th>
            <th>${e.empName}</th>
            <th>${e.gender == "M"?"man":"woman"}</th>
            <th>${e.email}</th>
            <th>${e.department.deptName}</th>
        </tr>
    </c:forEach>

</table>
</body>
</html>