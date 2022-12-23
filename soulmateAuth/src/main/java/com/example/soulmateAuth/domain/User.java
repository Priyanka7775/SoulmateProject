package com.example.soulmateAuth.domain;
//
//import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Id;

//@Data
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class User {
    @Id
    private String email;
    private String password;
    private String gender;

    public User(String email, String password, String gender) {
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public User() {
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
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    //    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//    public User(){}
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}