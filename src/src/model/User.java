package model;

public class User {
    private Integer id;
    private String name;
    private String address;
    private Integer roleId;

    public User() {
        super();
    }

    public User(Integer id, String name, String address, Integer roleId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
