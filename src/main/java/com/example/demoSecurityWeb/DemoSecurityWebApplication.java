package com.example.demoSecurityWeb;

import com.example.demoSecurityWeb.repository.Permission1Repository;
import com.example.demoSecurityWeb.repository.Role1Repository;
import com.example.demoSecurityWeb.repository.User1Repository;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(name = "E-Commerce Application", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class DemoSecurityWebApplication implements CommandLineRunner {

    @Autowired
    User1Repository user1Repository;
    @Autowired
    Role1Repository role1Repository;
    @Autowired
    Permission1Repository permission1Repository;

    @Autowired
//    @Qualifier("hi")
    String hello;

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(hello);
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
