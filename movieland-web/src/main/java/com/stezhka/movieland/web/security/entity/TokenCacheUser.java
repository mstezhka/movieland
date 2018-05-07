package com.stezhka.movieland.web.security.entity;


import com.stezhka.movieland.entity.User;

import java.time.LocalDateTime;

public class TokenCacheUser {
    private User user;
    private LocalDateTime TokenGeneratedDateTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTokenGeneratedDateTime() {
        return TokenGeneratedDateTime;
    }

    public void setTokenGeneratedDateTime(LocalDateTime tokenGeneratedDateTime) {
        TokenGeneratedDateTime = tokenGeneratedDateTime;
    }
}
