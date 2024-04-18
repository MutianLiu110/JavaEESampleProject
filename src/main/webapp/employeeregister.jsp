<%--
  Created by IntelliJ IDEA.
  User: 刘牧天
  Date: 2024/3/20
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <h1>Register</h1>
    <form action="<%= request.getContextPath() %>/register" method="post", enctype="multipart/form-data">
        <table style="with: 60%">
            <tr>
                <td>Username</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input type="text" name="country" /></td>
            </tr>
            <tr>
                <td>Avatar</td>
                <td><input type="file" name="avatar" /></td>
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