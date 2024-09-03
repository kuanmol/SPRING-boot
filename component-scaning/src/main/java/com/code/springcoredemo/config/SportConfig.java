package com.code.springcoredemo.config;

import com.code.springcoredemo.common.Coach;
import com.code.springcoredemo.common.swimcoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new swimcoach();
    }
}
