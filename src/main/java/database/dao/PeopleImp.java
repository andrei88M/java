package database.dao;

import database.ConnectionDB;
import database.entity.People;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeopleImp extends ConnectionDB implements PeopleDAO {

    @Override
    public void save(People people) {
        String sql = "INSERT INTO people VALUES (?,?,?,?)";
        try {
            connection = getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, people.getId());
            pStatement.setString(2, people.getName());
            pStatement.setString(3, people.getSurname());
            pStatement.setInt(4, people.getAge());
            pStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public People get(int id) {
        String sql = "SELECT * FROM people WHERE id=?";
        People people = null;
        try {
            connection = getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, id);
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                people = People.builder()
                        .id(result.getInt("id"))
                        .name(result.getString("name"))
                        .surname(result.getString("surname"))
                        .age(result.getInt("age"))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return people;
    }

    @Override
    public List<People> getAll() {
        List<People> list = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT * FROM people";
        try {
            connection = getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                People people = People.builder()
                        .id(result.getInt("id"))
                        .name(result.getString("name"))
                        .surname(result.getString("surname"))
                        .age(result.getInt("age"))
                        .build();
                list.add(people);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public void update(People people) {
        String sql = "UPDATE PEOPLE SET NAME=?,SURNAME=?,AGE=? WHERE ID=?";
        try {
            connection = getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, people.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(People people) {
        String sql = "DELETE FROM people WHERE id=?";
        try {
            connection = getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, people.getId());
            pStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
