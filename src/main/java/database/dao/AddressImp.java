package database.dao;

import database.ConnectionDB;
import database.entity.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressImp extends ConnectionDB implements AddressDAO {
    @Override
    public void save(Address address) {
        String sql = "INSERT INTO address VALUES (?,?,?)";
        try {
            connection = getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, address.getId());
            pStatement.setString(2, address.getStreet());
            pStatement.setInt(3, address.getHouse());
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
    public Address get(int id) {
        String sql = "SELECT * FROM address WHERE id=?";
        Address address = null;
        try {
            connection = getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, id);
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                address = Address.builder()
                        .id(result.getInt("id"))
                        .street(result.getString("street"))
                        .house(result.getInt("house"))
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
        return address;
    }

    @Override
    public List<Address> getAll() {
        List<Address> list = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT * FROM address";
        try {
            connection = getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Address address = Address.builder()
                        .id(result.getInt("id"))
                        .street(result.getString("street"))
                        .house(result.getInt("house"))
                        .build();
                list.add(address);
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
    public void update(Address address) {
        String sql = "UPDATE address SET street=?,house=? WHERE id=?";
        String sql2 = "UPDATE address SET street='"
                +address.getStreet()+"', house="
                +address.getHouse()+" where id="+address.getId();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql2);
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
    public void delete(Address address) {
        String sql = "DELETE FROM address WHERE id=?";
        try {
            connection = getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1,address.getId());
            pStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (pStatement!=null){
                try {
                    pStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
