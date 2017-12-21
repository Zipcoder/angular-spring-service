package com.zipcodewilmington.angularservice.controller;

import com.zipcodewilmington.angularservice.model.User;
import com.zipcodewilmington.angularservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return userService.add(user);

//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newLocation = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(newUser.getId())
//                .toUri();
//        responseHeaders.setLocation(newLocation);
//        return new ResponseEntity(newUser, responseHeaders, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable Long id) {

        User user = userService.getById(id);

        if (user == null) {
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user, HttpStatus.OK);
    }
}
