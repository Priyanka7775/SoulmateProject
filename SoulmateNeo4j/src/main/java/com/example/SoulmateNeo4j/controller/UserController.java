package com.example.SoulmateNeo4j.controller;

import com.example.SoulmateNeo4j.domain.User;
import com.example.SoulmateNeo4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/userSoulDetails")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<?>getAllUser(){
        List<User> userList=userService.getAllTheUser();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @DeleteMapping("userDetail/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){
        return new ResponseEntity<>(userService.deleteUser(email),HttpStatus.OK);
    }

    @GetMapping("/user1/{gender}")
    public List<?> getAllUserBasedOnGender(@PathVariable String gender){
//        List<User> userList1=userService.getAllUserBasedOnGender(gender);
//        return new ResponseEntity<>(userList1,HttpStatus.OK);
//
        return userService.findUserByGender(gender);
    }


//        @GetMapping("/user1")
//        public List<?> getAllUserBasedOnGender(@PathVariable String gender){
////        List<User> userList1=userService.getAllUserBasedOnGender(gender);
////        return new ResponseEntity<>(userList1,HttpStatus.OK);
////
//        return userService.findUserByGender(gender);
   // }
}
