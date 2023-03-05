//package com.example.demoSecurityWeb.config.jwt;
//
//import com.example.demoSecurityWeb.config.userDetailsService.UserDetailsImp1;
//import com.example.demoSecurityWeb.payload.ErrorDTO;
//import com.example.demoSecurityWeb.utils.Constant;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Collections;
//
//@Component
//
//
//public class JWTLoginApiFilter extends AbstractAuthenticationProcessingFilter {
//    private final String USERNAME_REQUEST_PARAM = "username";
//    private final String PASSWORD_REQUEST_PARAM = "password";
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private JwtUtils jwtUtils;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    public JWTLoginApiFilter() {
//        super(new AntPathRequestMatcher("/api/login", "POST"));
//        setAuthenticationManager(this.authenticationManager);
//
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authentication)
//            throws IOException, ServletException {
//        UserDetailsImp1 userDetails = (UserDetailsImp1) authentication.getPrincipal();
//        String JWT = jwtUtils.generateToken(userDetails.getUsername());
//        response.addHeader(Constant.HEADER_STRING, JWT);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        ObjectMapper mapper = new ObjectMapper();
//        response.addHeader("content-type", "application/json;charset=UTF-8");
//        mapper.writeValue(response.getWriter(), userDetails);
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request,
//                                              HttpServletResponse response,
//                                              AuthenticationException failed) throws IOException, ServletException {
//        String[] message = failed.getMessage().split(" ");
//        String lastMessage = message[message.length - 1];
//
//        ErrorDTO error = ErrorDTO.builder()
//                .message("")
//                .status(HttpStatus.UNAUTHORIZED.value())
//                .build();
//
//        if (lastMessage.compareTo("credentials") == 0) {
//            error.setMessage("Username or Password is incorrect");
//        } else if (lastMessage.compareTo("disabled") == 0) {
//            error.setMessage("User is disabled");
//        }
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        response.addHeader("content-type", "application/json;charset=UTF-8");
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(response.getWriter(), error);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
//        String username = request.getParameter(USERNAME_REQUEST_PARAM);
//        String password = request.getParameter(PASSWORD_REQUEST_PARAM);
//
//        return getAuthenticationManager()
//                .authenticate(
//                        new UsernamePasswordAuthenticationToken(
//                                username,
//                                password,
//                                Collections.emptyList()
//                        )
//                );
//    }
//}
