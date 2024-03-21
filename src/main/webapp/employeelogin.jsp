<%--
  Created by IntelliJ IDEA.
  User: 刘牧天
  Date: 2024/3/21
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Employee Login</h1>
    <form action="<%= request.getContextPath() %>/login" method="post">
        <table style="with: 60%">
            <tr>
                <td>Username</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>

        </table>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>
