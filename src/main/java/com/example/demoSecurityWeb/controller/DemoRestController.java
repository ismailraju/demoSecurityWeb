package com.example.demoSecurityWeb.controller;


import com.example.demoSecurityWeb.model.User1;
import com.example.demoSecurityWeb.repository.User1Repository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api3")
@SecurityRequirement(name = "Spring boot 3.0.2 MVC  Application")
public class DemoRestController {

    @Autowired
    private User1Repository user1Repository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User1>> getUsers() {
        List<User1> user1List = user1Repository.findAll();

        return new ResponseEntity<List<User1>>(user1List, HttpStatus.FOUND);
    }
}
