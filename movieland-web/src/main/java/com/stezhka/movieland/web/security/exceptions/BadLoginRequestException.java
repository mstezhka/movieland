package com.stezhka.movieland.web.security.exceptions;


public class BadLoginRequestException extends RuntimeException {
    public BadLoginRequestException() {
        super("Bad login request");
    }
}
