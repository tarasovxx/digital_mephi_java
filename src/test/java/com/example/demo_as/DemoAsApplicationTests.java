package com.example.demo_as;

import com.example.demo_as.controller.UserController;
import com.example.demo_as.model.Country;
import com.example.demo_as.model.Users;
import com.example.demo_as.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoAsApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        assertThat(userController).isNotNull();
    }

    @Test
    void testGetAllUsers() {
        String url = "http://localhost:" + port + "/user-api/v1/users";
        ResponseEntity<Users[]> response = restTemplate.getForEntity(url, Users[].class);
        Users[] users = response.getBody();
        assertThat(users).isNotNull();
        assertThat(users.length).isGreaterThan(0);
    }

    @Test
    void testAddUser() {
        String url = "http://localhost:" + port + "/user-api/v1/users";
        Users newUser = new Users("John", 28, Country.USA);
        HttpEntity<Users> request = new HttpEntity<>(newUser);
        ResponseEntity<Users> response = restTemplate.exchange(url, HttpMethod.POST, request, Users.class);
        Users createdUser = response.getBody();
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getFirstName()).isEqualTo("John");
        assertThat(createdUser.getAge()).isEqualTo(28);
        assertThat(createdUser.getCountry()).isEqualTo(Country.USA);
    }
}
