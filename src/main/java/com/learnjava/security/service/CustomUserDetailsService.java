package com.learnjava.security.service;

import com.learnjava.security.entity.User;
import com.learnjava.security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (Objects.isNull(user)) {
            System.out.println("User not available");
            throw new UsernameNotFoundException("User Not found");
        }
        return new CustomUserDetails(user);
    }
}
