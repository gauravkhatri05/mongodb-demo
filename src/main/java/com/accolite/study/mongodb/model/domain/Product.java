package com.accolite.study.mongodb.model.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {

    @Id
    @Getter
    @Setter
    private long id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;
}
