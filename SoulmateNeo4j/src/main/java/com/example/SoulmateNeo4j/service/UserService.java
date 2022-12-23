package com.example.SoulmateNeo4j.service;

import com.example.SoulmateNeo4j.domain.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    List<User> getAllTheUser();
    public boolean deleteUser(String email);

    List<User> findUserByGender(String gender);
}
