package com.stackroute.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenGeneratorTestUtil {
    TestUser user = new TestUser("john@email.com", "john@123");

    public Map<String, String> generateToken(TestUser user) {
        String jwtToken = "";
        jwtToken = Jwts.builder().setSubject(user.getId()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret").compact();
        Map<String, String> jwtTokenMap = new HashMap<>();
        jwtTokenMap.put("token", jwtToken);
        jwtTokenMap.put("message", "Login Successful");
        return jwtTokenMap;
    }

}
