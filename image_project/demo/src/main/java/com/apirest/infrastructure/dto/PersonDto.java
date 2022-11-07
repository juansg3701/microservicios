package com.apirest.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonDto {
    private String id_person;
    private String email_person;
    private String name_person;
    private String cedula_person;
    private int age_person;
    private int type_document;
    private Date created_at_person;
    private Date updated_at_person;

}
