package com.stackroute.util;

public class TestUser {
    private String id;
    private String password;

    public TestUser(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}