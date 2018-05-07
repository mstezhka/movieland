package com.stezhka.movieland.dao;

import com.stezhka.movieland.dao.enums.UserRole;
import com.stezhka.movieland.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> extractUser(String email);
    List<UserRole> getUserRoles(int userId);
}
