package com.example.SoulmateService.service;

import com.example.SoulmateService.domain.User;
import com.example.SoulmateService.exception.UserAlreadyFoundException;
import com.example.SoulmateService.exception.UserNotFoundException;
import com.example.SoulmateService.proxy.SoulmateProxy;
import com.example.SoulmateService.proxy.UserProxy;
import com.example.SoulmateService.rabbitmqSender.CommonUser;
import com.example.SoulmateService.rabbitmqSender.Producer;
import com.example.SoulmateService.rabbitmqSender.UserDTO;
import com.example.SoulmateService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProxy userProxy;
    @Autowired
    private Producer producer;
    @Autowired
    private SoulmateProxy soulmateProxy;

    public UserServiceImpl(UserRepository userRepository,UserProxy userProxy){
        this.userProxy=userProxy;
        this.userRepository=userRepository;
    }

    @Override
    public User addUser(User user) throws UserAlreadyFoundException {
        if(userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyFoundException();
        }
        User user1 = userRepository.save(user);
        if(!(user1.getEmail().isEmpty())){
            ResponseEntity responseEntity = userProxy.saveUser(user);
            soulmateProxy.addUser(user1);
            System.out.println(responseEntity.getBody());
        }
        return user1;
    }

    @Override
    public User addUser1(CommonUser commonUser) {
        UserDTO userDTO=new UserDTO(commonUser.getEmail(),commonUser.getPassword(),commonUser.getGender());
        producer.sendDtoToQueue(userDTO);
        User user=new User(commonUser.getEmail(), commonUser.getName(), commonUser.getAge(),commonUser.getGender(),commonUser.getCity() , commonUser.getPassword() );
        return userRepository.insert(user);
    }

    @Override
    public List<User> getAllTheUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUserByEmail(String email) {
//        if(userRepository.findById(email).isEmpty()){
//            throw new UserNotFoundException();
//        }
//            return userRepository.findById(email);
//        }

        return userRepository.findAllByEmail(email);
    }


    @Override
    public boolean deleteUser(String email) throws UserNotFoundException {
        boolean result=false;
        if(userRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        else{
            userRepository.deleteById(email);
            return true;
        }
    }
}
