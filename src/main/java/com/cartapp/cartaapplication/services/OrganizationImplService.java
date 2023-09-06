package com.cartapp.cartaapplication.services;

import com.cartapp.cartaapplication.dto.OrganizationDTO;
import com.cartapp.cartaapplication.entities.Organization;
import com.cartapp.cartaapplication.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationImplService implements OrganizationService{

    @Autowired
    OrganizationRepository organizationRepository;

    public ResponseEntity<String> createOrganization(OrganizationDTO organizationDTO) {
        if (organizationRepository.existsByName(organizationDTO.getName())) {
            return new ResponseEntity<>("Esa organización ya existe", HttpStatus.BAD_REQUEST);
        }else{
            Organization organization = new Organization();
            organization.setId(UUID.randomUUID().toString().split("-")[0]);
            organization.setName(organizationDTO.getName());
            organization.setDescription(organizationDTO.getDescription());
            organization.setTheme(organizationDTO.getTheme());
            organization.setLogoUrl(organizationDTO.getLogoUrl());
            organizationRepository.save(organization);
            return new ResponseEntity<>("Organización creada con éxito", HttpStatus.OK);
        }
    }
    public ResponseEntity<List<Organization>> findAllOrganizations(){
        List<Organization> organizations = organizationRepository.findAll();
        return ResponseEntity.ok(organizations);
    }
    public ResponseEntity<Organization>findOrganizationById(String id){
        if(organizationRepository.existsById(id)){
            Organization organization = organizationRepository.findByIdContaining(id);
            return ResponseEntity.ok(organization);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    public ResponseEntity<OrganizationDTO> findOrganizationByName(String name){
        if(organizationRepository.existsByName(name)){
            Organization organization = organizationRepository.findByNameContaining(name);
            OrganizationDTO organizationDTO = new OrganizationDTO();
            organizationDTO.setName(organization.getName());
            organizationDTO.setDescription(organization.getDescription());
            organizationDTO.setTheme(organization.getTheme());
            organizationDTO.setLogoUrl(organization.getLogoUrl());
            return ResponseEntity.ok(organizationDTO);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    public ResponseEntity<String> updateOrganization(String name, OrganizationDTO organizationDTO){
        if(organizationRepository.existsByName(name)){
            Organization organization = organizationRepository.findByNameContaining(name);
            organization.setName(organizationDTO.getName());
            organization.setDescription(organizationDTO.getDescription());
            organization.setTheme(organization.getTheme());
            organization.setLogoUrl(organization.getLogoUrl());
            if(organizationRepository.existsByName(organization.getName())){
                return new ResponseEntity<>("Error, ese nombre ya esta en uso.", HttpStatus.BAD_REQUEST);
            }else{
                organizationRepository.save(organization);
                return new ResponseEntity<>("La organización se ha actualizado con éxito.", HttpStatus.OK);
            }
        }else{
            return new ResponseEntity<>("Esa organización no existe.",HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<String> deleteOrganizationById(String id){
        if(organizationRepository.existsById(id)){
            organizationRepository.deleteById(id);
            return new ResponseEntity<>("Organización eliminada con éxito", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Esa organización no existe o ya fue eliminada.",HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<String> deleteOrganizationByName(String name){
        if(organizationRepository.existsByName(name)){
            Organization organization = organizationRepository.findByNameContaining(name);
            organizationRepository.deleteById(organization.getId());
            return new ResponseEntity<>("Organización eliminada con éxito", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Esa organización no existe o ya fue eliminada.", HttpStatus.BAD_REQUEST);
        }
    }
}
