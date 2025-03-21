<%@ page import="com.example.javaeesampleproject.dao.UserDAO" %>
<%@ page import="com.example.javaeesampleproject.models.User" %><%--
  Created by IntelliJ IDEA.
  User: 刘牧天
  Date: 2024/4/18
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
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
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">Home</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/hotels"/>">Hotels</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto"> <!-- ml-auto 右对齐 -->
            <!-- 判断是否登录，显示不同的内容 -->
            <!---->
            <c:choose>
                <c:when test="${empty sessionScope.username}">
                    <!-- 用户未登录 -->
                    <li class="nav-item">
                        <a class="nav-link" href="employeeregister.jsp">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="employeelogin.jsp">Login</a>
                    </li>
                </c:when>

                <c:otherwise>
                    <!-- 用户已登录 -->
                    <c:choose>
                        <c:when test="${sessionScope.identity == 'No'}">
                            <!-- 用户为普通用户 -->
                            <c:out value="${sessionScope.identity}" />
                            <li class="nav-item">
                                <a class="nav-link" href="profile.jsp">${sessionScope.username}</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    My Activities
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">My Orders</a>
                                    <a class="dropdown-item" href="#">My Collections</a>
                                    <a class="dropdown-item" href="#">Jasper Report</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/logout"/>">Logout</a>
                            </li>
                        </c:when>

                        <c:when test="${sessionScope.identity == 'Yes'}">
                            <!-- 用户为管理员 -->
                            <c:out value="${sessionScope.identity}" />
                            <li class="nav-item">
                                <a class="nav-link" href="profile.jsp">${sessionScope.username}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="hotel-upload.jsp">Dashboard</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/logout"/>">Logout</a>
                            </li>
                        </c:when>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>

