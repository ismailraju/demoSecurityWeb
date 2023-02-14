package com.example.demoSecurityWeb.repository;

import com.example.demoSecurityWeb.model.Role1;
import com.example.demoSecurityWeb.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Role1Repository extends JpaRepository<Role1, Long> {


    Optional<Role1> findByRole(String role);
}
