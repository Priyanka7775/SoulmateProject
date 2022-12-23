package com.example.SoulmateNeo4j.rabbitmqReceiver;

import com.example.SoulmateNeo4j.domain.User;
import com.example.SoulmateNeo4j.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private UserService userService;

    @RabbitListener(queues = "queue1")
    public void getDtoFromQueueAndAddToDb(UserDTO userDTO)  {
        User user=new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setGender(user.getGender());
        user.setCity(userDTO.getCity());
       // user.(userDTO.getPassword());

        User user1=userService.addUser(user);
        System.out.println("result= " + user1);
    }
}
