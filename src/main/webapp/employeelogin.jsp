<%--
  Created by IntelliJ IDEA.
  User: 刘牧天
  Date: 2024/3/21
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h1 class="text-center">Employee Login</h1>
                    <form action="<%= request.getContextPath() %>/login" method="post">
                        <div class="form-group">
                            <label for="username">Username:</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username">
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password">
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>