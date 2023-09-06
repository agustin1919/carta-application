package com.cartapp.cartaapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {

    private String name;

    private String description;

    private String theme;

    private String logoUrl;
}
