package com.example.contentApp.service;

import com.example.contentApp.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{

    @Override
    public Map<String, String> generateToken(User user) {
        Date cd=new Date();
        cd.setMinutes(cd.getMinutes()+2);

        String jwtToken=Jwts.builder()
                .setSubject(user.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(cd)
                .signWith(SignatureAlgorithm.HS256,"mykey").compact();
        Map<String, String> map=new HashMap();
        map.put("token",jwtToken);
        map.put("message","User successfully logged in");
        return map;
    }
}
