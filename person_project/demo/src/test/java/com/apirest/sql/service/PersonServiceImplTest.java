package com.apirest.sql.service;

import com.apirest.infrastructure.dto.PersonDto;
import com.apirest.application.mapper.impl.PersonDtoMapperImpl;
import com.apirest.application.service.PersonServiceImpl;
import com.apirest.domain.entity.Person;
import com.apirest.domain.entity.TypeDocument;
import com.apirest.application.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private PersonDtoMapperImpl personDtoMapperPerson;

    @InjectMocks
    private PersonServiceImpl personService;

    private PersonDto personDto;
    private Person person;
    private TypeDocument type_document;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        type_document = new TypeDocument();
        type_document.setType_name("cedula");
        type_document.setId("1");


        person = new Person();
        person.setName("Juan");
        person.setCedula("112323");
        person.setEmail("juan@gmail.com");
        person.setType_document(type_document);
        person.setAge(23);
        person.setId("123");

        personDto = new PersonDto();
        personDto.setName_person("Juan");
        personDto.setCedula_person("112323");
        personDto.setEmail_person("juan@gmail.com");
        personDto.setType_document(1);
        personDto.setAge_person(23);
        personDto.setId_person("123");

    }

    @Test
    void findAll() {
        when(personRepository.findAll()).thenReturn(Arrays.asList(person));
        when(personDtoMapperPerson.listToPersonDto(Arrays.asList(person))).thenReturn(Arrays.asList(personDto));
        List<PersonDto> result= personService.findAll();
        assertEquals(personDto, result.get(0));
        assertNotNull(personService.findAll());
    }

    @Test
    void findById() {
        when(personRepository.findById(person.getId())).thenReturn(person);
        when(personDtoMapperPerson.toPersonDto(person)).thenReturn(personDto);
        var result= personService.findById(person.getId());
        assertEquals(personDto, result);
        assertNotNull(personService.findById(person.getId()));
    }

    @Test
    void save() {
        when(personRepository.save(person)).thenReturn(person);
        when(personDtoMapperPerson.toPersonDto(person)).thenReturn(personDto);
        when(personDtoMapperPerson.toPerson(personDto)).thenReturn(person);
        PersonDto result= personService.save(personDto);
        assertEquals(personDto, result);
        assertNotNull(personService.save(personDto));


    }

    @Test
    void update() {
        when(personRepository.update(person)).thenReturn(person);
        when(personDtoMapperPerson.toPersonDto(person)).thenReturn(personDto);
        when(personDtoMapperPerson.toPerson(personDto)).thenReturn(person);
        var result= personService.update(personDto);
        assertEquals(personDto, result);
        assertNotNull(personService.update(personDto));
    }

    @Test
    void deleteById() {
        when(personRepository.deleteById(person.getId())).thenReturn(true);
        assertTrue(personService.deleteById(personDto.getId_person()));
    }
}