package com.apirest.application.repository;

import com.apirest.domain.entity.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> findAll();
    Person findById(String id);
    Person save(Person person);
    Person update(Person person);
    boolean deleteById(String id);
}
