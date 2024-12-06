package controller;

import model.Role;
import repository.implement.RoleRepository;
import utils.DbConnection;

public class RoleController {
    RoleRepository roleRepository = new RoleRepository(DbConnection.getConnection());

    public void get() {
        for (Role role : roleRepository.get()) {
            System.out.println("ID : " + role.getId());
            System.out.println("Name : " + role.getName());
        }
    }

    public void post() {
        Role role = new Role();
        role.setId(0);
        role.setName("Non-Membership");

        Boolean result = roleRepository.post(role);
        String res = result ? "insert data berhasil" : "insert data gagal";
        System.out.println(res);
    }

    public void put() {
        Role role = new Role();
        role.setId(0);
        role.setName("Membership");

        Boolean result = roleRepository.put(role, 3);
        String res = result ? "update data berhasil" : "update data gagal";
        System.out.println(res);
    }

    public void getById() {
        Role role = roleRepository.getById(2);
        if (role != null) {
            System.out.println("ID : " + role.getId());
            System.out.println("Name : " + role.getName());
        } else {
            System.out.println("Role tidak ditemukan.");

        }
    }
}
