package com.example.MusicApplication.musicApp.exception;

public class SongNotFound extends RuntimeException{

    public SongNotFound(String runtimeException) {
        super(runtimeException);
    }
}
