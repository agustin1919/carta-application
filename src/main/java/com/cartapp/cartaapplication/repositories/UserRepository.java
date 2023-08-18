package com.cartapp.cartaapplication.repositories;

import com.cartapp.cartaapplication.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByUserName(String name);

    User findByUserNameContaining(String userName);

    User findByIdContaining(String id);
}
