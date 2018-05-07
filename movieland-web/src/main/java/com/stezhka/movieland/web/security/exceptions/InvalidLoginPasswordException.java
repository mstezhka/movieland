package com.stezhka.movieland.web.security.exceptions;

public class InvalidLoginPasswordException extends RuntimeException {
    public InvalidLoginPasswordException() {
        super("Invalid loginn/password");
    }
}
