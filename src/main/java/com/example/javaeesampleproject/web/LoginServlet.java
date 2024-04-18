package com.example.javaeesampleproject.web;

import com.example.javaeesampleproject.dao.UserDAO;
import com.example.javaeesampleproject.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@MultipartConfig
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(name);
        user.setPassword(password);

        try {
            // 使用 DAO 层的 login 方法来验证用户登录
            boolean loginStatus = userDAO.login(user);

            if (loginStatus) {
                // 如果登录成功，设置用户 session 并重定向到 homepage.jsp
                HttpSession session = request.getSession();
                session.setAttribute("username", name);
                response.sendRedirect("index.jsp");
            } else {
                // 如果登录失败，设置错误消息并重定向到 employeelogin.jsp
                //HttpSession session = request.getSession();
                //session.setAttribute("error", "Invalid username or password.");
                response.sendRedirect("employeelogin.jsp");
            }
        } catch (Exception e) {
            // 捕获任何异常并打印堆栈信息
            e.printStackTrace();
        }
    }
}