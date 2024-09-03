package com.code.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class cricketcoach implements Coach {
    @Override
    public String getDailyworkout() {
        return "Practice fast bowling for 15 minutes";
    }
}

