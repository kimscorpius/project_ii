package com.Project_II.model;

import java.io.Serializable;

public class UserRole implements Serializable {

    private String role;

    public UserRole() {

    }

    public UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
