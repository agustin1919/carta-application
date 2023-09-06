package com.cartapp.cartaapplication.services;

import com.cartapp.cartaapplication.dto.OrganizationDTO;
import com.cartapp.cartaapplication.entities.Organization;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrganizationService {

    ResponseEntity<String> createOrganization(OrganizationDTO organizationDTO);

    ResponseEntity<List<Organization>> findAllOrganizations();

    ResponseEntity<Organization> findOrganizationById(String id);

    ResponseEntity<OrganizationDTO> findOrganizationByName(String name);

    ResponseEntity<String> updateOrganization(String name, OrganizationDTO organizationDTO);

    ResponseEntity<String> deleteOrganizationById(String id);

    ResponseEntity<String> deleteOrganizationByName(String name);
}
