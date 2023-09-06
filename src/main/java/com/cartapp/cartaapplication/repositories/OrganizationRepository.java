package com.cartapp.cartaapplication.repositories;

import com.cartapp.cartaapplication.entities.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationRepository extends MongoRepository<Organization, String> {

    boolean existsByName(String name);

    Organization findByIdContaining(String id);

    Organization findByNameContaining(String name);
}
