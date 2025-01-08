package com.learnjava.security.controller;

import com.learnjava.security.entity.User;
import com.learnjava.security.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        var u = userRepository.findByUserName(user.getUserName());
        if (!Objects.isNull(u)) {
            return "Success";
        } else {
            return "Failure";
        }
    }
}
