package com.Project_II.model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String address;
    private Integer status;
    private Integer roleId;
    private UserRole userRole;

    public User() {

    }

    public User(String name, String email, String userName, String password) {
        this.name = name;
        this.email = email;
        this.username = userName;
        this.password = password;
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

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // thuộc tính nào phụ thuộc vào laptop(có laptop đó mới có thuộc tính đó) thì cho vào product
    // còn lại tạo thêm một class
}
