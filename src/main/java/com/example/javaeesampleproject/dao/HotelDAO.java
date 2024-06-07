package com.example.javaeesampleproject.dao;

import com.example.javaeesampleproject.models.Hotel;
import com.example.javaeesampleproject.models.Picture;
import com.example.javaeesampleproject.models.User;

import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class HotelDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/coursework?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "601456";

    private static final String INSERT_HOTEL_SQL = "INSERT INTO hotel" + "  (name, description, city) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_HOTEL_WITH_PICTURES = "SELECT h.id, h.name, h.description, h.city, p.id as pic_id, p.pic FROM hotel h " +
            "LEFT JOIN hotel_pic_rel rel ON h.id = rel.hotel_id " +
            "LEFT JOIN picture p ON rel.pic_id = p.id";

    public HotelDAO(){

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List<Hotel> searchHotels(String keyword) {
        List<Hotel> hotels = new ArrayList<>();
        String SEARCH_HOTELS_SQL = "SELECT * FROM hotel WHERE name LIKE ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_HOTELS_SQL)) {
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getInt("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setDescription(resultSet.getString("description"));
                hotel.setCity(resultSet.getString("city"));
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return hotels;
    }

    public void insert(Hotel hotel, List<String> base64Images) throws ClassNotFoundException {
        String INSERT_HOTEL_SQL = "INSERT INTO hotel (name, description, city) VALUES (?, ?, ?);";
        String INSERT_PICTURE_SQL = "INSERT INTO picture (pic) VALUES (?);";
        String INSERT_REL_SQL = "INSERT INTO hotel_pic_rel (hotel_id, pic_id) VALUES (?, ?);";

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?useSSL=false", "root", "601456");
             PreparedStatement hotelStatement = connection.prepareStatement(INSERT_HOTEL_SQL, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pictureStatement = connection.prepareStatement(INSERT_PICTURE_SQL, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement relStatement = connection.prepareStatement(INSERT_REL_SQL)) {

            // Insert hotel
            hotelStatement.setString(1, hotel.getName());
            hotelStatement.setString(2, hotel.getDescription());
            hotelStatement.setString(3, hotel.getCity());
            hotelStatement.executeUpdate();

            // Get the generated hotel ID
            ResultSet hotelKeys = hotelStatement.getGeneratedKeys();
            int hotel_id = 0;
            if (hotelKeys.next()) {
                hotel_id = hotelKeys.getInt(1);
            }

            // Insert pictures and create relations
            for (String base64 : base64Images) {
                // Convert base64 string to byte array
                byte[] imageBytes = Base64.getDecoder().decode(base64);

                // Clear previous parameter settings
                pictureStatement.clearParameters();

                // Insert picture
                ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
                pictureStatement.setBlob(1, inputStream);
                pictureStatement.executeUpdate();

                // Get the generated picture ID
                ResultSet pictureKeys = pictureStatement.getGeneratedKeys();
                int pic_id = 0;
                if (pictureKeys.next()) {
                    pic_id = pictureKeys.getInt(1);
                }

                // Create relation
                relStatement.setInt(1, hotel_id);
                relStatement.setInt(2, pic_id);
                relStatement.executeUpdate();
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
    }

    public List<Hotel> view() {
        List<Hotel> hotels = new ArrayList<>();
        String SELECT_HOTELS_SQL = "SELECT * FROM hotel";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_HOTELS_SQL);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getInt("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setDescription(resultSet.getString("description"));
                hotel.setCity(resultSet.getString("city"));
                // 如果还有其他属性，也可以从 ResultSet 中获取并设置
                // hotel.setXXX(resultSet.getXXX("column_name"));
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return hotels;
    }
}
