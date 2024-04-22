<%--
  Created by IntelliJ IDEA.
  User: 刘牧天
  Date: 2024/4/18
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>

<%@ page import="com.example.javaeesampleproject.dao.UserDAO" %>
<%@ page import="com.example.javaeesampleproject.models.User" %>
<%@ page import="javax.servlet.http.HttpSession" %>


    <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://localhost:3306/coursework?useSSL=false"
    user = "root"  password = "601456"/>

    <sql:query dataSource = "${snapshot}" var = "result">
    SELECT * from users;
    </sql:query>

    <table border = "1" width = "100%">
    <tr>
    <th>Emp ID</th>
    <th>Name</th>
    <th>Mail</th>
    <th>Identity</th>
    </tr>

    <c:forEach var = "row" items = "${result.rows}">
    <tr>
    <td><c:out value = "${row.id}"/></td>
    <td><c:out value = "${row.name}"/></td>
    <td><c:out value = "${row.email}"/></td>
    <td><c:out value = "${row.isAdmin}"/></td>
    </tr>
    </c:forEach>
    </table>
<%@ include file="footer.jsp" %>