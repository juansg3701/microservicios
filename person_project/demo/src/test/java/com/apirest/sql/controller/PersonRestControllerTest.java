package com.apirest.sql.controller;

import com.apirest.infrastructure.dto.PersonDto;
import com.apirest.application.service.PersonServiceInterface;
import com.apirest.infrastructure.controller.PersonRestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonRestControllerTest {
    @Mock
    private PersonServiceInterface personServiceInterface;

    @InjectMocks
    private PersonRestController controller;

    private PersonDto person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        person = new PersonDto();
        person.setName_person("Juan");
        person.setEmail_person("juan@gmail.com");
        person.setId_person("123");

    }

    @Test
    void findAll() {
        when(personServiceInterface.findAll()).thenReturn(Arrays.asList(person));
        List<PersonDto> result= controller.findAll();
        assertEquals(person, result.get(0));
        assertNotNull(controller.findAll());
    }

    @Test
    void getPerson() {
        when(personServiceInterface.findById(person.getId_person())).thenReturn(person);
        var result= controller.getPerson(person.getId_person());
        assertEquals(person, result);
        assertNotNull(controller.getPerson(person.getId_person()));
    }

    @Test
    void addPerson() {
        when(personServiceInterface.save(person)).thenReturn(person);
        var result= controller.addPerson(person);
        assertEquals(person, result);
        assertNotNull(controller.addPerson(person));
    }

    @Test
    void updatePerson() {
        when(personServiceInterface.update(person)).thenReturn(person);
        var result= controller.updatePerson(person);
        assertEquals(person, result);
        assertNotNull(controller.updatePerson(person));
    }

    @Test
    void deletePerson() {
        when(personServiceInterface.findById(person.getId_person())).thenReturn(person);
        when(personServiceInterface.deleteById(person.getId_person())).thenReturn(true);
        assertNotNull(controller.deletePerson(person.getId_person()));
    }
}