package repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public List<User> get() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM tb_user";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4));
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAddress(resultSet.getString(3));
                user.setRoleId(resultSet.getInt(4));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public Boolean post(User user) {
        String query = "INSERT INTO tb_user(id, name, address, role_id) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setInt(4, user.getRoleId());
            Integer result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean put(User user, int id) {
        String query = "UPDATE tb_user SET name = ?, address = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.setInt(3, id);
            Integer result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public User getById(int id) {
        User user = new User();
        String query = "SELECT * FROM tb_user WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement
                    .executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4));
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAddress(resultSet.getString(3));
                user.setRoleId(resultSet.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public Boolean delete(int id) {
        String query = "DELETE FROM tb_user WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            Integer result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean deleteByRoleId(int roleId) {
        String query = "DELETE FROM tb_user WHERE role_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, roleId);
            Integer result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
