package com.code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class tenniscoach implements Coach {

    tenniscoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        return "practice backhand volleyball";
    }
}
