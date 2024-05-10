<%@ include file="header.jsp" %>

<div class="container mt-4">
    <h1>Hotels</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>City</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hotel" items="${requestScope.hotels}">
            <tr>
                <td>${hotel.id}</td>
                <td>${hotel.name}</td>
                <td>${hotel.description}</td>
                <td>${hotel.city}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="footer.jsp" %>