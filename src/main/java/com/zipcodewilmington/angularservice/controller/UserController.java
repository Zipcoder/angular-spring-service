package com.zipcodewilmington.angularservice.controller;

import com.zipcodewilmington.angularservice.model.User;
import com.zipcodewilmington.angularservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Created by leon on 12/20/17.
 */
@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(@RequestBody User user) {

        User user1  = userService.add(user);

        logger.info("adding user");

        URI userURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(user1.getId())
                .toUri();

        return ResponseEntity.created(userURI).build();
    }

    @GetMapping()
    public ResponseEntity<Iterable<User>> getAllUser(){
        Iterable<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.getById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
