<%@ page import="com.example.javaeesampleproject.models.User" %>
<%@ page import="com.example.javaeesampleproject.dao.UserDAO" %>
<!--Header-->
<%@ include file="header.jsp" %>

<!-- 页面内容 -->
<div class="container mt-4">
    <div class="row">
        <!-- 侧边栏 -->
        <div class="col-md-3">
            <div class="accordion" id="sidebarAccordion">
                <div class="card">
                    <div class="card-header" id="headingOne">
                        <h5 class="mb-0">
                            <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Sidebar
                            </button>
                        </h5>
                    </div>

                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#sidebarAccordion">
                        <div class="card-body">
                            <!-- 在这里添加侧边栏的内容 -->
                            <ul class="list-group">
                                <li class="list-group-item">Item 1</li>
                                <li class="list-group-item">Item 2</li>
                                <li class="list-group-item">Item 3</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 主要内容区域 -->
        <div class="col-md-9">
            <h2>Hotel Booking</h2>
            <p>Book your room</p>
            <%-- 在这里添加主要内容 --%>
        </div>
    </div>
</div>

<!-- Footer -->
<%@ include file="footer.jsp" %>