package com.apirest.application.mapper.impl;

import com.apirest.infrastructure.dto.PersonDto;
import com.apirest.application.mapper.PersonDtoMapperPerson;
import com.apirest.domain.entity.Person;
import com.apirest.domain.entity.TypeDocument;
import com.apirest.application.repository.TypeDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PersonDtoMapperImpl implements PersonDtoMapperPerson {
    @Autowired
    private TypeDocumentRepository typeDocumentRepository;
    @Override
    public PersonDto toPersonDto(Person person) {
        return PersonDto.builder()
                .id_person(person.getId())
                .email_person(person.getEmail())
                .name_person(person.getName())
                .age_person(person.getAge())
                .type_document(Integer.parseInt(person.getType_document()))
                .cedula_person(person.getCedula())
                .created_at_person(person.getCreated_at())
                .updated_at_person(person.getUpdated_at())
                .build();
    }

    @Override
    public Person toPerson(PersonDto personDto) {

        return Person.builder()
                .id(personDto.getId_person())
                .email(personDto.getEmail_person())
                .name(personDto.getName_person())
                .age(personDto.getAge_person())
                .type_document(find_type_document(personDto.getType_document()))
                .cedula(personDto.getCedula_person())
                .created_at(personDto.getCreated_at_person())
                .updated_at(personDto.getUpdated_at_person())
                .build();

    }

    @Override
    public List<PersonDto> listToPersonDto(List<Person> person) {
        List<PersonDto> result = new ArrayList<>();
        for (Person per : person) {
            result.add(
                    PersonDto.builder()
                            .id_person(per.getId())
                            .email_person(per.getEmail())
                            .name_person(per.getName())
                            .age_person(per.getAge())
                            .cedula_person(per.getCedula())
                            .type_document(Integer.parseInt(per.getType_document()) )
                            .created_at_person(per.getCreated_at())
                            .updated_at_person(per.getUpdated_at())
                            .build()
            );
        }
        return result;
    }

    private TypeDocument find_type_document(int id_document) {
        TypeDocument type_search = typeDocumentRepository.findById(Integer.toString(id_document) );
        return type_search;
    }
}
