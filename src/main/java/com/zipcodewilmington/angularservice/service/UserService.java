package com.zipcodewilmington.angularservice.service;

import com.zipcodewilmington.angularservice.model.User;
import com.zipcodewilmington.angularservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 12/21/17.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void add(User user) {
        user.setId(userRepository.count());
        userRepository.save(user);
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.findOne(id);
    }
    public void remove(User user ) {
        userRepository.delete(user);
    }

    public void remove(Long id) {
        remove(getById(id));
    }

}
