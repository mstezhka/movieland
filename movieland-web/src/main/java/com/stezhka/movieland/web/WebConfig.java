package com.stezhka.movieland.web;

import com.stezhka.movieland.web.security.cache.TokenCacheConfig;
import com.stezhka.movieland.web.util.currency.cache.CurrencyCacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@Import({CurrencyCacheConfig.class, TokenCacheConfig.class})
@ComponentScan("com.stezhka.movieland.web")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor());
    }

}
