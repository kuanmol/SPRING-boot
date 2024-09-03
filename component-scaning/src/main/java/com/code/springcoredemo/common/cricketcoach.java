package com.code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class cricketcoach implements Coach {

    public cricketcoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        return "Practice fast bowling for 15 minutes";
    }
}

