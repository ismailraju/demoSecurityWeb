package com.example.demoSecurityWeb.config.userDetailsService;

import com.example.demoSecurityWeb.model.Role1;
import com.example.demoSecurityWeb.model.User1;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImp1 implements UserDetails {

    String password;
    String username;

    boolean enabled;
    List<GrantedAuthority> authorities;

    public UserDetailsImp1(User1 user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();
        if(user.getRole1s().size()>0){
            Role1 role1 = user.getRole1s().get(0);
            this.authorities = role1.getPermission1s().stream()
                    .map(permission1 ->    new SimpleGrantedAuthority(permission1.getName()))
                    .collect(Collectors.toList());
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
