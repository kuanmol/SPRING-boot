package com.code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class trackcoach implements Coach {

    public trackcoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        return "run for 10 kilometer";
    }
}
