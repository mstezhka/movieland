package com.stezhka.movieland.web.security.exceptions;

public class UserTokenExpiredException extends RuntimeException {
    public UserTokenExpiredException(){
        super("User token expired.");
    }
}
