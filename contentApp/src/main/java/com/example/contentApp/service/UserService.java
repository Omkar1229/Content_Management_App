package com.example.contentApp.service;

import com.example.contentApp.exception.UserNotFoundException;
import com.example.contentApp.model.User;

import java.util.List;

public interface UserService {
    public abstract User saveUser(User user);
    public abstract User authenticateUser(int userId, String password) throws UserNotFoundException;
    public abstract List<User> getAllUsers();
}
