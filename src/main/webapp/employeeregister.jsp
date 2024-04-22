<%@ include file="header.jsp" %>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h1 class="text-center">Register</h1>
                    <form action="<%= request.getContextPath() %>/register" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="name">Username:</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter your username">
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="text" class="form-control" id="email" name="email" placeholder="Enter your email">
                        </div>
                        <div class="form-group">
                            <label for="country">Country:</label>
                            <input type="text" class="form-control" id="country" name="country" placeholder="Enter your country">
                        </div>
                        <div class="form-group">
                            <label for="avatar">Avatar:</label>
                            <input type="file" class="form-control-file" id="avatar" name="avatar">
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
