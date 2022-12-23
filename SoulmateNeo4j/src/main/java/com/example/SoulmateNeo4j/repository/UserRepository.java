package com.example.SoulmateNeo4j.repository;

import com.example.SoulmateNeo4j.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends Neo4jRepository<User,String> {
    List<User> findUserByGender(String gender);
}
