package com.example.javaeesampleproject.web;

import com.example.javaeesampleproject.dao.UserDAO;
import com.example.javaeesampleproject.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(name);
        user.setPassword(password);

        try {
            if (userDAO.login(user)) {
                HttpSession session = request.getSession();
                session.setAttribute("username",name);
                response.sendRedirect("homepage.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", name);
                response.sendRedirect("employeelogin.jsp");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
