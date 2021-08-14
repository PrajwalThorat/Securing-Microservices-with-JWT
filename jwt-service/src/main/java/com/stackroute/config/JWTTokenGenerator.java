package com.stackroute.config;

import java.util.Map;

import com.stackroute.domain.User;

public interface JWTTokenGenerator {

    Map<String, String> generateToken(User user);
}
