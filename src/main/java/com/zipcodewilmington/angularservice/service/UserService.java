package com.zipcodewilmington.angularservice.service;

import com.zipcodewilmington.angularservice.model.User;
import com.zipcodewilmington.angularservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by leon on 12/21/17.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User add(User user) {
//        user.setId(userRepository.count());
        return userRepository.save(user);
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

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void remove(Long id) {
        remove(getById(id));
    }

}
