package com.example.MusicApplication.musicApp.exception;

public class InvalidEmailOrPassword extends RuntimeException{

    public InvalidEmailOrPassword(String runtimeException) {
        super(runtimeException);
    }
}
