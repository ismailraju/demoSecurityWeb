package com.example.demoSecurityWeb;

import com.example.demoSecurityWeb.model.Permission1;
import com.example.demoSecurityWeb.model.Role1;
import com.example.demoSecurityWeb.model.User1;
import com.example.demoSecurityWeb.repository.Permission1Repository;
import com.example.demoSecurityWeb.repository.Role1Repository;
import com.example.demoSecurityWeb.repository.User1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoSecurityWebApplication implements CommandLineRunner {

    @Autowired
    User1Repository user1Repository;
    @Autowired
    Role1Repository role1Repository;
    @Autowired
    Permission1Repository permission1Repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Permission1 permission1 = permission1Repository.save(Permission1.builder().name("DASHBOARD").build());
//
//        Role1 role1 = Role1.builder()
//                .role("ADMIN")
//                .permission1s(Arrays.asList(permission1))
//                .build();
//
//
//        role1 = role1Repository.save(role1);
//
//        User1 user1 = User1.builder()
//                .username("raju")
//                .password("raju")
//                .email("raju@gmail.com")
//                .enabled(true)
//                .role1s(Arrays.asList(role1))
//                .build();
//        user1Repository.save(user1);

    }
}
