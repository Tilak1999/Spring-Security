package com.learnjava.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*class to take security to our control
 instead giving control to spring security*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("register","login").permitAll()
                                .anyRequest().authenticated()
                )
                //.formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

//    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails tilak = User
                .withUsername("tilak")
                .password("{noop}password")
                .roles("USER")
                .build();

        UserDetails lia = User
                .withUsername("lia")
                .password("{noop}lia")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(tilak, lia);
    }



}
