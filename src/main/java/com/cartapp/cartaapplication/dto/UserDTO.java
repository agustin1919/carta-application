package com.cartapp.cartaapplication.dto;

import com.cartapp.cartaapplication.entities.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;

    private String lastName;

    private String userName;

    private String organizationId;

}
