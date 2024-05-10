package com.example.javaeesampleproject.web;

import com.example.javaeesampleproject.dao.HotelDAO;
import com.example.javaeesampleproject.models.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet("/hotel_uploading")
@MultipartConfig
public class HotelUploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1;
    private HotelDAO hotelDAO;

    public void init() {
        hotelDAO = new HotelDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String city = request.getParameter("city");

        List<String> base64Images = new ArrayList<>();
        for (Part part : request.getParts()) {
            if (part.getName().equals("pictures")) {
                base64Images.add(convertToBase64(part.getInputStream()));
            }
        }

        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setDescription(description);
        hotel.setCity(city);

        try {
            hotelDAO.insert(hotel, base64Images);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }

    private String convertToBase64(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageBytes = outputStream.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
