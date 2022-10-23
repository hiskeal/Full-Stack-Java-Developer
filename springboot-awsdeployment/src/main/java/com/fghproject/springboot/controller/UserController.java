package com.fghproject.springboot.controller;

import com.fghproject.springboot.entity.User;
import com.fghproject.springboot.exception.ResourceNotFoundException;
import com.fghproject.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository; // Injection

    // get all users
    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable (value = "id") Long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }
    //create user
    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    // update user
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable ("id") Long userId) {
        User existingUser =  this.userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        return this.userRepository.save(existingUser);
    }
    // delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable ("id") Long userId) {
        User existingUser =  this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        this.userRepository.delete(existingUser);

        return ResponseEntity.ok().build();
    }

}
