package com.example.javaeesampleproject.dao;

import com.example.javaeesampleproject.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/coursework?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "601456";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country, password) VALUES " +
            " (?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country, password from users where id =?";

    private static final String SELECT_USER_BY_PASSWORD = "select from users where name = ?, password = ?;";

    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =?, password =? where id = ?;";


    public UserDAO() {}

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

    public void register(User user) throws ClassNotFoundException{
        String INSERT_USERS_SQL = "INSERT INTO users" +
                "  (id, name, email, country, password, isAdmin, avatar) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?);";
        // int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?useSSL=false", "root", "601456");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCountry());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getIsAdmin());
            preparedStatement.setString(7, user.getAvatar());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        // process sql exception
        printSQLException(e);

        }
    }

    public boolean login(User user) throws ClassNotFoundException {
        boolean state = false;
        String SELECT_USER_SQL = "SELECT * FROM users WHERE name = ? AND password = ?";

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?useSSL=false", "root", "601456");
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
                state =  true;
                // Handle successful login
            } else {
                System.out.println("Login failed. Invalid username or password.");
                // Handle failed login
            }

        } catch (SQLException e) {
            // Process SQL exception
            printSQLException(e);
        }
        return state;
    }


    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setString(4, user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                String isAdmin = rs.getString("isAdmin");
                String avatar = rs.getString("avatar");
                user = new User (id, name, email, country, password, isAdmin, avatar);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public User getProfile(String username) {
        User user = null;
        // SQL 查询语句
        String sql = "SELECT * FROM users WHERE name = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                // 从 ResultSet 中获取用户信息
                int userId = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                String isAdmin = rs.getString("isAdmin");
                String avatar = rs.getString("avatar");
                // 创建 User 对象
                user = new User(userId, name, email, country, password, isAdmin, avatar);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    //public void userProfile(int id){

    //}

    public List <User> selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List< User > users = new ArrayList< >();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                users.add(new User(id, name, email, country, password));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            /// statement.setInt(4, user.getId());
            statement.setString(5, user.getPassword());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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
}
