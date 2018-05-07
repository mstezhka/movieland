package com.stezhka.movieland.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.stezhka.movieland.web.security.entity.UserToken;
import com.stezhka.movieland.web.security.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@Controller

public class UserController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final AuthenticationService authenticationService;

    @Autowired
    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/login", method = POST, consumes = "application/json;", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public UserToken processLogin(@RequestBody String loginJson, HttpServletResponse response) {
        log.info("Start login user ");
        long startTime = System.currentTimeMillis();
        UserToken userToken = authenticationService.performLogin(loginJson);
        response.setStatus(200);
        log.info("User logged in. It took {} ms", System.currentTimeMillis() - startTime);
        return userToken;

    }

    @RequestMapping(value = "/logout", method = DELETE)
    public ResponseEntity processLogout(@RequestHeader(value = "uuid") String uuid) {
        log.info("Start logout token {}", uuid);
        authenticationService.performLogout(uuid);
        return ResponseEntity.ok("Logout done");
    }

}
