package com.example.demoSecurityWeb.repository;

import com.example.demoSecurityWeb.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User1Repository extends JpaRepository<User1, Long> {
}
