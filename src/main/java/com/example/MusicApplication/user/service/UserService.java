package com.example.MusicApplication.user.service;

import com.example.MusicApplication.musicApp.exception.InvalidEmailOrPassword;
import com.example.MusicApplication.musicApp.model.AccessToken;
import com.example.MusicApplication.user.database.UserRepository;
import com.example.MusicApplication.user.model.Login;
import com.example.MusicApplication.user.model.User;
import com.example.MusicApplication.user.util.HashUtils;
import com.example.MusicApplication.user.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    TokenUtil tokenUtil = new TokenUtil();
    HashUtils hashUtils = new HashUtils();

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){

        user.setPassword(hashUtils.generateHash(user.getPassword()));

        userRepository.save(user);

        return user;
    }

    public AccessToken loginUser(Login login) {

        AccessToken accessToken = new AccessToken();

        User loginUser = userRepository.getUserByEmailAndPassword(login.getEmail(), hashUtils.generateHash(login.getPassword()));

        if (loginUser == null){
            throw new InvalidEmailOrPassword("Invalid email or password, please try again");
        }else{
            Long userId= loginUser.getId();
            accessToken.setAccessToken(tokenUtil.jwt(userId));
        }

        return accessToken;
    }
}
