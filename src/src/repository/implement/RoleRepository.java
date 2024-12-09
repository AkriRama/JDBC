package repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Role;
import repository.IRepository;

public class RoleRepository implements IRepository {
    private Connection connection;

    public RoleRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Role> get() {
        List<Role> roles = new ArrayList<>();
        String query = "SELECT * FROM tb_role";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Role role = new Role(resultSet.getInt(1), resultSet.getString(2));
                role.setId(resultSet.getInt(1));
                role.setName(resultSet.getString(2));
                roles.add(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roles;
    }

    public Boolean post(Role role) {
        String query = "INSERT INTO tb_role(id, name) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, role.getId());
            preparedStatement.setString(2, role.getName());
            Integer result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean put(Role role, int id) {
        String query = "UPDATE tb_role SET name = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, role.getName());
            preparedStatement.setInt(2, id);
            Integer result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Role getById(int id) {
        Role role = new Role();
        String query = "SELECT * FROM tb_role WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement
                    .executeQuery();
            if (resultSet.next()) {
                role = new Role(resultSet.getInt(1), resultSet.getString(2));
                role.setId(resultSet.getInt(1));
                role.setName(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }

    public Boolean delete(int id) {
        String query = "DELETE FROM tb_role WHERE id = ?";
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
}
