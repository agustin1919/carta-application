package com.cartapp.cartaapplication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "organizations")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Organization {
    @Id
    private String id;

    private String name;

    private String description;

    private String theme;

    private String logoUrl;
}
