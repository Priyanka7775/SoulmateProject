package com.example.SoulmateService.rabbitmqSender;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonUser {
    private String email;
    private String name;
    private int age;
    private String gender;
    private String city;
    private String password;



}
