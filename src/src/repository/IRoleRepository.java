package repository;

import java.util.List;

import model.Role;

public interface IRepository {
    public List<Role> get();

    public Boolean post(Role role);

    public Boolean put(Role role, int id);

    public Role getById(int id);

    public Boolean delete(int id);
}
