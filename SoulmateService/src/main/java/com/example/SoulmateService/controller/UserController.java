package com.example.SoulmateService.controller;

import com.example.SoulmateService.domain.User;
import com.example.SoulmateService.exception.UserAlreadyFoundException;
import com.example.SoulmateService.exception.UserNotFoundException;
import com.example.SoulmateService.rabbitmqSender.CommonUser;
import com.example.SoulmateService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/userDetail")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyFoundException {
        ResponseEntity responseEntity=null;
        try{
           // User createdUser = userService.addUser(user);
          //  return new ResponseEntity(createdUser , HttpStatus.CREATED);
           // user.setSongList(new ArrayList<>());
            responseEntity=new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        }catch (UserAlreadyFoundException e){
            throw new UserAlreadyFoundException();
        }catch (Exception e){
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/common")
    public ResponseEntity<?> addUserDetails(@RequestBody CommonUser commonUser){
        return new ResponseEntity<>(userService.addUser1(commonUser),HttpStatus.OK);
    }
    @GetMapping("/userList")
    public ResponseEntity<?>getAllUser(){
        List<User> userList=userService.getAllTheUser();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @GetMapping("/userList1/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
//        ResponseEntity responseEntity=null;
//        try {
//            responseEntity=new ResponseEntity<>(userService.getAllUserByEmail(email),HttpStatus.FOUND);
//        }catch (UserNotFoundException e){
//            throw new UserNotFoundException();
//        }
//        return responseEntity;
        return new ResponseEntity<>(userService.getAllUserByEmail(email),HttpStatus.FOUND);
    }

    @DeleteMapping("/userdata/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
        try{
            userService.deleteUser(email);
            responseEntity = new ResponseEntity("Successfully Deleted",HttpStatus.OK);
        }catch (UserNotFoundException userNotFoundException){
            throw new UserNotFoundException();
        }catch (Exception exception){
            responseEntity=new ResponseEntity(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
