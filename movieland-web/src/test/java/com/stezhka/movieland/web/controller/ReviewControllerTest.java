package com.stezhka.movieland.web.controller;


import com.stezhka.movieland.entity.Review;
import com.stezhka.movieland.entity.User;
import com.stezhka.movieland.service.ReviewService;
import com.stezhka.movieland.web.util.json.JsonJacksonConverter;
import com.stezhka.movieland.web.security.entity.PrincipalUser;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ReviewControllerTest {


    @Test
    public void saveReviewTest() throws Exception {
        String inputJson = "{\"movieId\" : 1,\"text\" : \"Очень понравилось!\"}";
        int userId = 1;

        Review review = new Review();
        User user = new User();
        user.setId(userId);
        review.setUser(user);
        review.setMovieId(1);
        review.setText("Очень понравилось!");

        JsonJacksonConverter mockJsonJacksonConverter = mock(JsonJacksonConverter.class);
        when(mockJsonJacksonConverter.parseJsonToReview(inputJson, userId)).thenReturn(review);

        ReviewService mockReviewService = mock(ReviewService.class);


        PrincipalUser principal = new PrincipalUser("test user", 1);

        ReviewController controller = new ReviewController(mockReviewService, mockJsonJacksonConverter);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/review").
                principal(principal).
                contentType("application/json;charset=UTF-8").
                content(inputJson))
                .andExpect(status().isOk());
    }


}
