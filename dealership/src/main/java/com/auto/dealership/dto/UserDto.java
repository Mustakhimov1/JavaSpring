package com.auto.dealership.dto;

import com.auto.dealership.model.auth.Role;
public class UserDto {
    private String username;
    private Role role;

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
