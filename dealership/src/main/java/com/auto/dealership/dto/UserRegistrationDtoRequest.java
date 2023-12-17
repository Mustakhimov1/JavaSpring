package com.auto.dealership.dto;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Pattern;

public class UserRegistrationDtoRequest {
    @Length(min = 3, max = 20, message = "Username must have from 3 to 20 characters")
    private String username;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()])[A-Za-z\\d!@#$%^&*()]{8,}$",
            message = "Password must have at least one uppercase letter, one lowercase letter, one number and one special character, minimum 8 characters")
    private String password;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()])[A-Za-z\\d!@#$%^&*()]{8,}$",
            message = "RePassword must have at least one uppercase letter, one lowercase letter, one number and one special character, minimum 8 characters")
    private String rePassword;



    public UserRegistrationDtoRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

}

