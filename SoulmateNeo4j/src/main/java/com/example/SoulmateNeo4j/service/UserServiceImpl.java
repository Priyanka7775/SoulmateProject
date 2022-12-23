package com.example.SoulmateNeo4j.service;

import com.example.SoulmateNeo4j.domain.User;
import com.example.SoulmateNeo4j.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    public UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllTheUser() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(String email) {
        userRepository.deleteById(email);
        return true;
    }

    @Override
    public List<User> findUserByGender(String gender) {
        if(gender.equals("Female")){
            return userRepository.findUserByGender("Male");
        }
//        else{
//            return userRepository.findUserByGender("Female");
//        }
        return userRepository.findUserByGender("Female");

    }
}
