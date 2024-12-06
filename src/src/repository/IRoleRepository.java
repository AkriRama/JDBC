package repository;

import java.util.List;

import model.Role;

public interface IRoleRepository {
    public List<Role> get();

    public Boolean post(Role role);

    public Boolean put(String name, int id);

    public Role getById(int id);
}
