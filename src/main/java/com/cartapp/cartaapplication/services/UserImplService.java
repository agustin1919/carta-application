package com.cartapp.cartaapplication.services;

import com.cartapp.cartaapplication.dto.UserDTO;
import com.cartapp.cartaapplication.entities.Organization;
import com.cartapp.cartaapplication.entities.User;
import com.cartapp.cartaapplication.repositories.OrganizationRepository;
import com.cartapp.cartaapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserImplService implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    public ResponseEntity<String> createUser(UserDTO userDTO){
        if(userRepository.existsByUserName(userDTO.getUserName())){
            return new ResponseEntity<>("Error, ese usuario ya existe",HttpStatus.BAD_REQUEST);
        } else {
            User user = new User();
            user.setId(UUID.randomUUID().toString().split("-")[0]);
            // organization.setId(UUID.randomUUID().toString().split("-")[0]);
            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setUserName(userDTO.getUserName());
            Organization organization = organizationRepository.findByIdContaining(userDTO.getOrganizationId());
            user.setOrganization(organization);
            userRepository.save(user);
            return new ResponseEntity<>("Usuario creado", HttpStatus.OK);
        }
    }
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    public ResponseEntity<User> findUserById(String id){
        User user = userRepository.findByIdContaining(id);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<UserDTO> findUserByUserName(String userName){
        if(userRepository.existsByUserName(userName)){
            UserDTO userDTO = new UserDTO();
            User user = userRepository.findByUserNameContaining(userName);
            userDTO.setName(user.getName());
            userDTO.setLastName(user.getLastName());
            userDTO.setUserName(user.getUserName());
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    public ResponseEntity<String> updateUser(String userName, UserDTO userDTO){
        if(userRepository.existsByUserName(userName)){
            User user = userRepository.findByUserNameContaining(userName);
            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setUserName(userDTO.getUserName());
            userRepository.save(user);
            return new ResponseEntity<>("Usuario actualizado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, ese usuario no existe.", HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<String> deleteUser(String userName){
        User user = userRepository.findByUserNameContaining(userName);
        userRepository.delete(user);
        return new ResponseEntity<>("El usuario se ha eliminado correctamente", HttpStatus.OK);
    }
    public ResponseEntity<String> deleteUserById(String id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return new ResponseEntity<>("El usuario se ha eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El usuario no existe o ya ha sido eliminado", HttpStatus.OK);
        }
    }
}
