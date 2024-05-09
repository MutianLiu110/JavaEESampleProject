<%@ page import="com.example.javaeesampleproject.models.User" %>
<!--Header-->
<%@ include file="header.jsp" %>

<!-- 页面内容 -->
<div class="container mt-4">
    <h2>Sample Project</h2>
    <p>This is a Sample Project</p>
    <%
        String username = (String) session.getAttribute("username");
        Integer userId = (Integer) session.getAttribute("id");
        //int id = Integer.parseInt(session.getAttribute("id").toString());
        User user = new User(username);

    %>

    <img src="image/microsoft.png" alt="img">

    <p>Welcome, <%= username %>!</p>
    <p>Welcome, <%= userId %>!</p>


</div>

<!-- Footer -->
<%@ include file="footer.jsp" %>