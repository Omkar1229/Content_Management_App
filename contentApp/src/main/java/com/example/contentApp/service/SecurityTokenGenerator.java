package com.example.contentApp.service;

import com.example.contentApp.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String,String> generateToken(User user);
}
