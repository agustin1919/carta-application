package com.cartapp.cartaapplication.controllers;

import com.cartapp.cartaapplication.dto.UserDTO;
import com.cartapp.cartaapplication.entities.User;
import com.cartapp.cartaapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    //C
    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }
    //R
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/user/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id){
        return userService.findUserById(id);
    }
    @GetMapping("user/{userName}")
    public ResponseEntity<UserDTO>findUserByUserName(@PathVariable String userName){
        return userService.findUserByUserName(userName);
    }
    //U
    @PutMapping("/user/{userName}")
    public ResponseEntity<String> updateUser(@PathVariable String userName, @RequestBody UserDTO userDTO){
        return userService.updateUser(userName, userDTO);
    }
    //D
    @DeleteMapping("/user/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName){
        return userService.deleteUser(userName);
    }
    @DeleteMapping("/user/id/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id){
        return userService.deleteUserById(id);
    }
}
