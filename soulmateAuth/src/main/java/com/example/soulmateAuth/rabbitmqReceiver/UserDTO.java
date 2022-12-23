package com.example.soulmateAuth.rabbitmqReceiver;

import lombok.*;


public class UserDTO {
    private String email;
    private String password;
    private String gender;

    public UserDTO() {
    }

    public UserDTO(String email, String password, String gender) {
        this.email = email;
        this.password = password;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

