package com.stezhka.movieland.service;

import com.stezhka.movieland.dao.enums.UserRole;
import com.stezhka.movieland.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<User> extractUser(String email);
    List<UserRole> getUserRoles(int userId);
}
