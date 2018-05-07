package com.stezhka.movieland.service.impl;


import com.stezhka.movieland.dao.UserDao;
import com.stezhka.movieland.dao.enums.UserRole;
import com.stezhka.movieland.entity.User;
import com.stezhka.movieland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Optional<User> extractUser(String email) {
        return userDao.extractUser(email);
    }

    @Override
    public List<UserRole> getUserRoles(int userId) {
        return userDao.getUserRoles(userId);
    }
}