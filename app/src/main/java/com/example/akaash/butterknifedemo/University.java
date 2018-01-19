package com.example.akaash.butterknifedemo;

/**
 * Created by akaash on 11/1/18.
 */

public class University {

    private float rating;
    private String universityName;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }



    public University(int rating, String universityName) {
        this.rating = rating;
        this.universityName = universityName;
    }


}
