package com.learnjava.security.controller;

import com.learnjava.security.entity.User;
import com.learnjava.security.repository.UserRepository;
import com.learnjava.security.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {

    private UserRepository userRepository;

    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
//        var u = userRepository.findByUserName(user.getUserName());
//        if (!Objects.isNull(u)) {
//            return "Success";
//        } else {
//            return "Failure";
//        }
        return userService.verify(user);
    }
}
