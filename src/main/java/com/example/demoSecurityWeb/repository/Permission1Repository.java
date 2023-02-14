package com.example.demoSecurityWeb.repository;

import com.example.demoSecurityWeb.model.Permission1;
import com.example.demoSecurityWeb.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Permission1Repository extends JpaRepository<Permission1, Long> {

}
