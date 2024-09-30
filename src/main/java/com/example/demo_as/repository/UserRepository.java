package com.example.demo_as.repository;

import com.example.demo_as.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByAgeGreaterThanEqualOrderByFirstNameAsc(Integer age);
}
