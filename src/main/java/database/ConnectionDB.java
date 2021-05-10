package database;

import java.sql.*;

public class ConnectionDB { private static String url = "jdbc:mysql://localhost:3306/hw";
    private static String user = "root";
    private static String password = "54321";

    public Connection connection = null;
    public PreparedStatement pStatement = null;
    public ResultSet result = null;

    protected Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
