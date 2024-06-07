package com.example.javaeesampleproject.web;

import com.example.javaeesampleproject.dao.UserDAO;
import com.example.javaeesampleproject.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServlet;


@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get user id from session or request parameter, assuming userId is stored in session for demonstration
        // For example, assuming userId is stored in session attribute "current_id"
        String username = (String) request.getSession().getAttribute("name");
        Integer id = (Integer) request.getSession().getAttribute("id");

        // Fetch user details from the database
        User user = userDAO.getProfile(id);

        if (user != null) {
            // If user exists, forward to profile page
            String name = user.getUsername();
            String email = user.getEmail();

            request.setAttribute("username", name);
            request.setAttribute("email", email);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
            // If user does not exist, handle appropriately (e.g., redirect to error page)
            response.sendRedirect("index.jsp");
        }
    }
}
