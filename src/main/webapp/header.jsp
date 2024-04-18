<%--
  Created by IntelliJ IDEA.
  User: 刘牧天
  Date: 2024/4/18
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <title>Example Project</title>
    <!-- 引入 Bootstrap CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- 顶部状态栏 -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">My Website</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto"> <!-- ml-auto 右对齐 -->
            <!-- 判断是否登录，显示不同的内容 -->
            <!---->
            <c:choose>
                <c:when test="${empty sessionScope.username}">
                    <li class="nav-item">
                        <a class="nav-link" href="employeeregister.jsp">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="employeelogin.jsp">Login</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link" href="#">${sessionScope.username}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Logout</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
