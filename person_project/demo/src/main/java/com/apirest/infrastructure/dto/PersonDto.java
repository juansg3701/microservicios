package com.apirest.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {
    private String id_person;
    private String email_person;
    private String name_person;
    private String cedula_person;
    private int age_person;
    private int type_document;
    private Date created_at_person;
    private Date updated_at_person;
    private List<ImageDto> images;

    public PersonDto clone(){
        return PersonDto.builder()
                .id_person(id_person)
                .email_person(email_person)
                .cedula_person(cedula_person)
                .age_person(age_person)
                .type_document(type_document)
                .created_at_person(created_at_person)
                .updated_at_person(updated_at_person)
                .build();
    }
}
