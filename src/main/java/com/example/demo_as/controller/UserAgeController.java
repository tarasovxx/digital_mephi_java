package com.example.demo_as.controller;

import com.example.demo_as.model.Users;
import com.example.demo_as.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api/v1/additional-info")
public class UserAgeController {

    private final UserService userService;

    @Autowired
    public UserAgeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getUsersByAge(@RequestParam Integer age) {
        return userService.getUsersByAge(age);
    }
}
