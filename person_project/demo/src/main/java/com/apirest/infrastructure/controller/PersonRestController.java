package com.apirest.infrastructure.controller;

import com.apirest.infrastructure.dto.PersonDto;
import com.apirest.application.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestConrtoller para saber que es un controlador rest
@RestController
@RequestMapping("/persons")//-> microsevicio
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class PersonRestController {

    @Autowired
    PersonServiceInterface personServiceInterface;

    @GetMapping()
    public List<PersonDto> findAll() {
        List<PersonDto> persons = personServiceInterface.findAll();
        persons.forEach( item -> item.setImages(personServiceInterface.getImages(item.getId_person())));
        return persons;
    }

    @GetMapping("/{personId}")
    public PersonDto getPerson(@PathVariable String personId) {
        PersonDto person = personServiceInterface.findById(personId);
        person.setImages(personServiceInterface.getImages(person.getId_person()));
        return person;
    }

    @PostMapping()
    public PersonDto addPerson(@RequestBody PersonDto person) {
        personServiceInterface.save(person);
        return person;
    }

    @PutMapping()
    public PersonDto updatePerson(@RequestBody PersonDto person) {
        personServiceInterface.update(person);
        return person;
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable String id) {
        PersonDto person = personServiceInterface.findById(id);
        if(person == null){
            throw new RuntimeException("Persona no encontrada - " + id);
        }
        personServiceInterface.deleteImages(id);
        personServiceInterface.deleteById(id);
        return "Persona eliminada con id: " + id;
    }
}
