package com.example.soulmateAuth.rabbitmqReceiver;

import com.example.soulmateAuth.domain.User;
import com.example.soulmateAuth.exception.UserAlreadyFoundException;
import com.example.soulmateAuth.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private UserService userService;

    @RabbitListener(queues = "queue1")
    public void getDtoFromQueueAndAddToDb(UserDTO userDTO) throws UserAlreadyFoundException {
        User user=new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setGender(userDTO.getGender());
        User user1=userService.saveUser(user);
        System.out.println("result= " + user1);
    }

}
