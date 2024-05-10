<%--
  Created by IntelliJ IDEA.
  User: 刘牧天
  Date: 2024/4/18
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>

<%@ page import="com.example.javaeesampleproject.dao.UserDAO" %>
<%@ page import="com.example.javaeesampleproject.web.ProfileServlet" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.example.javaeesampleproject.models.User" %>
<%@ page import="java.util.List" %>

<%
    String name = (String) session.getAttribute("username");
    Integer id = (Integer) session.getAttribute("id");

    // 使用 DAO 层的 queryUser 方法来查询用户信息
    UserDAO userDAO = new UserDAO();
    User user = userDAO.getProfile(id);
%>


<div class="container mt-5">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Profile Information</h5>
                    <p class="card-text"><%= name %></p>
                    <img src="data:image/jpeg;base64, <%= user.getAvatar() %>" class="img-fluid" alt="Avatar">
                    <p class="card-text"><%= user.getEmail() %></p>
                    <p class="card-text">Identity: <%= user.getIdentity() %></p>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">My Orders</h5>
                    <!-- Add more information here -->
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>