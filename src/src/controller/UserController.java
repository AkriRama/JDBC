package controller;

import model.User;
import repository.implement.RoleRepository;
import repository.implement.UserRepository;
import utils.DbConnection;

public class UserController {
    UserRepository userRepository = new UserRepository(DbConnection.getConnection());
    RoleRepository roleRepository = new RoleRepository(DbConnection.getConnection());

    public void get() {
        if (userRepository.get().isEmpty()) {
            System.out.println("User data tidak ditemukan.");
        } else {
            for (User user : userRepository.get()) {
                System.out.println("ID\t: " + user.getId());
                System.out.println("Name\t: " + user.getName());
                System.out.println("Address\t: " + user.getAddress());
                System.out.println("Role\t: " + roleRepository.getById(user.getRoleId()).getName());
            }
        }
    }

    public void post() {
        User user = new User();
        user.setId(0);
        user.setName("Budi");
        user.setAddress("Jakarta");
        user.setRoleId(5);

        Boolean result = userRepository.post(user);
        String res = result ? "insert data berhasil" : "insert data gagal";
        System.out.println(res);
    }

    public void put() {
        User user = new User();
        user.setId(0);
        user.setName("Randy");
        user.setAddress("Banten");

        Boolean result = userRepository.put(user, 1);
        String res = result ? "update data berhasil" : "update data gagal";
        System.out.println(res);
    }

    public void getById() {
        User user = userRepository.getById(1);
        if (user != null) {
            System.out.println("ID\t: " + user.getId());
            System.out.println("Name\t: " + user.getName());
            System.out.println("Address\t: " + user.getAddress());
            System.out.println("Role\t: " + user.getRoleId());
        } else {
            System.out.println("User tidak ditemukan.");

        }
    }

    public void delete() {
        Boolean result = userRepository.delete(1);
        String res = result ? "delete data berhasil" : "delete data gagal";
        System.out.println(res);
    }

}
