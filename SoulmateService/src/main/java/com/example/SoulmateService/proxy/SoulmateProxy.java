package com.example.SoulmateService.proxy;

import com.example.SoulmateService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "soulmate-service",url = "http://localhost:8081")
public interface SoulmateProxy {
    @PostMapping("/userSoulDetails/register")
    public ResponseEntity<?> addUser(@RequestBody User user);
}
