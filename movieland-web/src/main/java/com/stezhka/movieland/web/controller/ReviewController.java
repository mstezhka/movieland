package com.stezhka.movieland.web.controller;

import com.stezhka.movieland.dao.enums.UserRole;
import com.stezhka.movieland.entity.Review;
import com.stezhka.movieland.service.ReviewService;
import com.stezhka.movieland.web.util.json.JsonJacksonConverter;
import com.stezhka.movieland.web.security.Protected;
import com.stezhka.movieland.web.security.entity.PrincipalUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller

public class ReviewController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private ReviewService reviewService;
    private JsonJacksonConverter jsonJacksonConverter;

    @Autowired
    public ReviewController(ReviewService reviewService, JsonJacksonConverter jsonJacksonConverter) {
        this.reviewService = reviewService;
        this.jsonJacksonConverter = jsonJacksonConverter;
    }

    @RequestMapping(value = "/review", method = POST,produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    @Protected(roles = {UserRole.USER})
    public Object saveReview(@RequestBody String reviewJson, PrincipalUser principal) {
        log.info("Start save review {}", reviewJson);
        long startTime = System.currentTimeMillis();

        Review review = reviewService.addReview(jsonJacksonConverter.parseJsonToReview(reviewJson, principal.getUserId()));
        log.info("Review has been saved to DB. It took {} ms", System.currentTimeMillis() - startTime);
        return review;

    }

}
