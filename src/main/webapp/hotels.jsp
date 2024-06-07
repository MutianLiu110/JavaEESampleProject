<%@ include file="header.jsp" %>

<div class="container mt-4">
    <h1>Hotels</h1>
    <div class="mb-3">
        <form action="${pageContext.request.contextPath}/searchHotels" method="post" class="form-inline">
            <div class="form-group">
                <label for="keyword" class="mr-2">Search:</label>
                <input type="text" id="keyword" name="keyword" class="form-control mr-2" value="${param.keyword != null ? param.keyword : ''}">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
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
