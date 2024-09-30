package com.example.demo_as.service;

import com.example.demo_as.model.Users;
import com.example.demo_as.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    public List<Users> getUsersByAge(Integer age) {
        return userRepository.findByAgeGreaterThanEqualOrderByFirstNameAsc(age);
    }
}
