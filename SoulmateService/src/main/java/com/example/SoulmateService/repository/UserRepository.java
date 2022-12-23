package com.example.SoulmateService.repository;

import com.example.SoulmateService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    List<User> findAllByEmail(String email);
}
