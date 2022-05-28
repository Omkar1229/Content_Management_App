package com.example.contentApp.controller;

import com.example.contentApp.exception.UserNotFoundException;
import com.example.contentApp.model.User;
import com.example.contentApp.service.SecurityTokenGenerator;
import com.example.contentApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/loginapp/v2")
public class UserController {

    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;
    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator){
        this.userService=userService;
        this.securityTokenGenerator=securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/userservice/getallusers")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws UserNotFoundException {
        Map<String, String> map=null;
        try {
            User authenticateUser=userService.authenticateUser(user.getUserId(),user.getPassword());
            if(authenticateUser.getUserId()==user.getUserId()){
                map=securityTokenGenerator.generateToken(authenticateUser);
            }
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch(Exception e){
            return new ResponseEntity<>("Exception",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
