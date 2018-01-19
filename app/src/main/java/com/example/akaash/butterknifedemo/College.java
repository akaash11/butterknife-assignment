package com.example.akaash.butterknifedemo;

/**
 * Created by akaash on 11/1/18.
 */

public class College {
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    private String collegeName;

    public College(String collegeName) {
        this.collegeName = collegeName;
    }
}
