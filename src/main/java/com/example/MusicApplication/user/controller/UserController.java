package com.example.MusicApplication.user.controller;

import com.example.MusicApplication.musicApp.exception.InvalidEmailOrPassword;
import com.example.MusicApplication.musicApp.model.AccessToken;
import com.example.MusicApplication.user.model.Login;
import com.example.MusicApplication.user.model.User;
import com.example.MusicApplication.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user){
        try {
            User createUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(createUser);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(path = "login")
    public ResponseEntity<Object> userLogin(@RequestBody Login login){
        try {
            AccessToken loginUser = userService.loginUser(login);
            return ResponseEntity.status(HttpStatus.OK).body(loginUser);
        }catch (InvalidEmailOrPassword e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
