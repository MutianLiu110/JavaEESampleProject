package com.example.javaeesampleproject.web;

import com.example.javaeesampleproject.dao.HotelDAO;
import com.example.javaeesampleproject.models.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hotels")
@MultipartConfig
public class ViewHotelsServlet extends HttpServlet {
    private HotelDAO hotelDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        hotelDAO = new HotelDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Hotel> hotels = hotelDAO.view();
        System.out.println(hotels);
        request.setAttribute("hotels", hotels);
        request.getRequestDispatcher("hotels.jsp").forward(request, response);
    }
}

