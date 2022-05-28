package com.example.contentApp.service;

import com.example.contentApp.exception.UserNotFoundException;
import com.example.contentApp.model.User;
import com.example.contentApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User authenticateUser(int userId, String password) throws UserNotFoundException {
        User user=userRepository.findByUserIdAndPassword(userId,password);
        if(user!=null){
            return user;
        }
        else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
