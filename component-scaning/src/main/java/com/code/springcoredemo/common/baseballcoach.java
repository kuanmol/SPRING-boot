package com.code.springcoredemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class baseballcoach implements Coach {

    public baseballcoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        return "spend 30 minute to throw ball to base ball player";
    }
}
