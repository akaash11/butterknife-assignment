package com.example.akaash.butterknifedemo;

/**
 * Created by akaash on 10/1/18.
 */

public class Profile {

    private String name;
    private String url;
    private String dataOne;
    private String dataTwo;

    public Profile(String name, String url, String dataOne, String dataTwo) {
        this.name = name;
        this.url = url;
        this.dataOne = dataOne;
        this.dataTwo = dataTwo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDataOne() {
        return dataOne;
    }

    public void setDataOne(String dataOne) {
        this.dataOne = dataOne;
    }

    public String getDataTwo() {
        return dataTwo;
    }

    public void setDataTwo(String dataTwo) {
        this.dataTwo = dataTwo;
    }
}
