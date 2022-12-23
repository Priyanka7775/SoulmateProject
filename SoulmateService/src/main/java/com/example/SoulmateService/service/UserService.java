package com.example.SoulmateService.service;

import com.example.SoulmateService.domain.User;
import com.example.SoulmateService.exception.UserAlreadyFoundException;
import com.example.SoulmateService.exception.UserNotFoundException;
import com.example.SoulmateService.rabbitmqSender.CommonUser;

import java.util.List;

public interface UserService {
    public User addUser(User user)throws UserAlreadyFoundException;
    public User addUser1(CommonUser commonUser) ;
    List<User> getAllTheUser();
    List<User> getAllUserByEmail(String email) ;
    public boolean deleteUser(String email) throws UserNotFoundException;
}
