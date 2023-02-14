package com.example.demoSecurityWeb.config.userDetailsService;

import com.example.demoSecurityWeb.model.User1;
import com.example.demoSecurityWeb.repository.User1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImp1 implements UserDetailsService {
    @Autowired
    private User1Repository user1Repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User1> user1 = user1Repository.findByUsername(username);
        return user1.map(UserDetailsImp1::new).orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));

    }
}
