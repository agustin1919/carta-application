package com.cartapp.cartaapplication.controllers;

import com.cartapp.cartaapplication.dto.OrganizationDTO;
import com.cartapp.cartaapplication.entities.Organization;
import com.cartapp.cartaapplication.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @PostMapping("/organization")
    public ResponseEntity<String> createOrganization(@RequestBody OrganizationDTO organizationDTO){
        return organizationService.createOrganization(organizationDTO);
    }
    @GetMapping("/organizations")
    public ResponseEntity<List<Organization>> findAllOrganizations(){
        return organizationService.findAllOrganizations();
    }
    @GetMapping("/organization/id/{id}")
    public ResponseEntity<Organization> findOrganizationById(@PathVariable String id){
        return organizationService.findOrganizationById(id);
    }
    @GetMapping("/organization/{name}")
    public ResponseEntity<OrganizationDTO> FindOrganizationByName(@PathVariable String name){
        return organizationService.findOrganizationByName(name);
    }
    @PutMapping("/organization/{name}")
    public ResponseEntity<String> updateOrganization(@PathVariable String name, @RequestBody OrganizationDTO organizationDTO){
        return organizationService.updateOrganization(name, organizationDTO);
    }
    @DeleteMapping("/organization/id/{id}")
    public ResponseEntity<String> deleteOrganizationById(@PathVariable String id){
        return organizationService.deleteOrganizationById(id);
    }
    @DeleteMapping("/organization/{name}")
    public ResponseEntity<String> deleteOrganizationByName(@PathVariable String name){
        return organizationService.deleteOrganizationByName(name);
    }
}
