//package com.example.demoSecurityWeb.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.ldap.core.support.BaseLdapPathContextSource;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
//import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
//import org.springframework.security.config.ldap.LdapPasswordComparisonAuthenticationManagerFactory;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
//import org.springframework.security.ldap.authentication.BindAuthenticator;
//import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
//import org.springframework.security.ldap.authentication.LdapAuthenticator;
//import org.springframework.security.ldap.server.ApacheDSContainer;
//import org.springframework.security.ldap.server.UnboundIdContainer;
//
//@Configuration
//public class LDAPConfig {
//
////    @Bean
////    public EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean() {
////        return EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
////    }
//
//    @Bean
//    UnboundIdContainer ldapContainer() {
//        return new UnboundIdContainer("dc=springframework,dc=org",
//                "classpath:users.ldif");
//    }
//
//    @Bean
//    DefaultSpringSecurityContextSource contextSource(UnboundIdContainer container) {
//        return new DefaultSpringSecurityContextSource(
//                "ldap://localhost:" + container.getPort() + "/dc=springframework,dc=org");
//    }
//
//
//    @Bean
//    BindAuthenticator authenticator(BaseLdapPathContextSource contextSource) {
//        BindAuthenticator authenticator = new BindAuthenticator(contextSource);
//        authenticator.setUserDnPatterns(new String[] { "uid={0},ou=people" });
//        return authenticator;
//    }
//
//    @Bean
//    LdapAuthenticationProvider authenticationProvider(LdapAuthenticator authenticator) {
//        return new LdapAuthenticationProvider(authenticator);
//    }
////    @Bean
////    ApacheDSContainer ldapContainer() throws Exception {
////        return new ApacheDSContainer("dc=springframework,dc=org",
////                "classpath:users.ldif");
////    }
////    @Bean
////    public EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean() {
////        EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean =
////                EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
////        contextSourceFactoryBean.setPort(0);
////        return contextSourceFactoryBean;
////    }
////
//
////    @Bean
////    AuthenticationManager authenticationManager(BaseLdapPathContextSource contextSource) {
////        LdapBindAuthenticationManagerFactory factory = new LdapBindAuthenticationManagerFactory(contextSource,  NoOpPasswordEncoder.getInstance());
////        factory.setUserDnPatterns("uid={0},ou=people");
////        return factory.createAuthenticationManager();
////    }
////
////    @Bean
////    AuthenticationManager authenticationManager(BaseLdapPathContextSource contextSource) {
////        LdapBindAuthenticationManagerFactory factory = new LdapBindAuthenticationManagerFactory(contextSource);
////        factory.setUserSearchFilter("(uid={0})");
////        factory.setUserSearchBase("ou=people");
////        return factory.createAuthenticationManager();
////    }
//
////    @Bean
////    AuthenticationManager authenticationManager(BaseLdapPathContextSource contextSource) {
////        LdapPasswordComparisonAuthenticationManagerFactory factory = new LdapPasswordComparisonAuthenticationManagerFactory(
////                contextSource, new BCryptPasswordEncoder());
////        factory.setUserDnPatterns("uid={0},ou=people");
////        factory.setPasswordAttribute("pwd");
////        return factory.createAuthenticationManager();
////    }
//
//
////    @Bean
////    LdapAuthoritiesPopulator authorities(BaseLdapPathContextSource contextSource) {
////        String groupSearchBase = "";
////        DefaultLdapAuthoritiesPopulator authorities =
////                new DefaultLdapAuthoritiesPopulator(contextSource, groupSearchBase);
////        authorities.setGroupSearchFilter("member={0}");
////        return authorities;
////    }
////
////    @Bean
////    AuthenticationManager authenticationManager(BaseLdapPathContextSource contextSource, LdapAuthoritiesPopulator authorities) {
////        LdapBindAuthenticationManagerFactory factory = new LdapBindAuthenticationManagerFactory(contextSource);
////        factory.setUserDnPatterns("uid={0},ou=people");
////        factory.setLdapAuthoritiesPopulator(authorities);
////        return factory.createAuthenticationManager();
////    }
//}
