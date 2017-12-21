package com.zipcodewilmington.angularservice.controller;

import com.zipcodewilmington.angularservice.model.User;
import com.zipcodewilmington.angularservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by leon on 12/20/17.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        userService.add(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<User> getUsers() {
        return userService.getUsers();
    }
}
