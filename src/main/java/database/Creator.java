package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Creator extends ConnectionDB {
    public void createDB() {
        String createSQL = "CREATE DATABASE hw";
        String dropSQL = "DROP DATABASE if exists hw";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropSQL);
            statement.executeUpdate(createSQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTable() {
        String address = "CREATE TABLE address(id int auto_increment," +
                "street varchar (50)," +
                "house int ," +
                "primary key (id))";
        String people = "CREATE TABLE people(id int ," +
                "name varchar (50)," +
                "surname varchar (50)," +
                "age int," +
                "primary key (id))";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(address);
            statement.executeUpdate(people);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
