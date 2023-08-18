package com.cartapp.cartaapplication.services;

import com.cartapp.cartaapplication.dto.UserDTO;
import com.cartapp.cartaapplication.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<String> createUser(UserDTO userDTO);

    ResponseEntity<List<User>> findAllUsers();

    ResponseEntity<User> findUserById(String id);

    ResponseEntity<String> updateUser(String userName, UserDTO userDTO);

    ResponseEntity<String> deleteUser(String userName);

    ResponseEntity<String> deleteUserById(String id);

    ResponseEntity<UserDTO> findUserByUserName(String userName);


}
