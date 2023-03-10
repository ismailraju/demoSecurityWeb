package com.example.demoSecurityWeb.repository;

import com.example.demoSecurityWeb.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.util.Optional;
@Repository
public interface User1Repository extends JpaRepository<User1, Long> {


    Optional<User1> findByUsername(String username);
}
