package com.cartapp.cartaapplication.controllers;

import com.cartapp.cartaapplication.dto.UserDTO;
import com.cartapp.cartaapplication.entities.User;
import com.cartapp.cartaapplication.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="UserController", description ="Endpoints del servicio de usuarios")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    //C
    @Operation(summary = "Crear usuario", description = "Se creará un nuevo usuario")
    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }
    //R
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers(){
        return userService.findAllUsers();
    }
    @Operation(summary = "Encontrar usuario por id", description = "Se encontrará un usuario por el valor del id")
    @GetMapping("/user/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id){
        return userService.findUserById(id);
    }
    @Operation(summary = "Encontrar usuario por username", description = "Se encontrará un usuario por el username")
    @GetMapping("user/{userName}")
    public ResponseEntity<UserDTO>findUserByUserName(@PathVariable String userName){
        return userService.findUserByUserName(userName);
    }
    //U
    @Operation(summary="Actualizar usuario", description = "Se actualizará un usuario")
    @PutMapping("/user/{userName}")
    public ResponseEntity<String> updateUser(@PathVariable String userName, @RequestBody UserDTO userDTO){
        return userService.updateUser(userName, userDTO);
    }
    //D
    @Operation(summary = "Eliminar usuario", description = "Se eliminará un usuario por username")
    @DeleteMapping("/user/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName){
        return userService.deleteUser(userName);
    }
    @Operation(summary="Eliminar usuario por id", description = "Se eliminará usuario por el valor de su id")
    @DeleteMapping("/user/id/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id){
        return userService.deleteUserById(id);
    }
}
