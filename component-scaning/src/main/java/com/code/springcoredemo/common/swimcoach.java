package com.code.springcoredemo.common;

public class swimcoach implements Coach {

    public swimcoach() {
        System.out.println("In constructor :" + getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        return "swim 100 meters as warm up";
    }
}
