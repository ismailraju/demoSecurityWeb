package com.example.demoSecurityWeb.config.jwt;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demoSecurityWeb.config.userDetailsService.UserDetailsServiceImp1;
import com.example.demoSecurityWeb.utils.Constant;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImp1 userDetailsServiceImp1;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader(Constant.HEADER_STRING);
        if (authHeader != null && !authHeader.isBlank() && authHeader.contains("Bearer")) {

            String jwt = authHeader.substring(7);

            if (jwt != null && !jwt.isBlank()) {

                try {


                    String username = jwtUtils.validateTokenAndRetieveSubject(jwt);
                    UserDetails userDetails = userDetailsServiceImp1.loadUserByUsername(username);


                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());

                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                    }


                } catch (JWTVerificationException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invlaid JWT token in Bearer Header");
            }


        }

        filterChain.doFilter(request, response);
    }
}
