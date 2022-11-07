package com.apirest.application.mapper;

import com.apirest.infrastructure.dto.PersonDto;
import com.apirest.domain.entity.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PersonDtoMapperPerson {
    PersonDto toPersonDto(Person person);
    Person toPerson(PersonDto personDto);
    List<PersonDto> listToPersonDto(List<Person> person);
}
