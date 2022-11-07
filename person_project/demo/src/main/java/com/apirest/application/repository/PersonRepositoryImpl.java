package com.apirest.application.repository;

import com.apirest.domain.entity.Person;
import com.apirest.infrastructure.dao.PersonDAO;
import com.apirest.domain.entity.TypeDocument;
import com.apirest.application.exception.EmptyInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {
    @Autowired
    private final PersonDAO personDao;

    @Autowired
    private TypeDocumentRepository typeDocumentRepository;

    @Override
    public List<Person> findAll() {
        List<Person> listPersons = personDao.findAll();
        return listPersons;
    }

    @Override
    public Person findById(String id) {
        Person person = personDao.findById(id).get();
        if(person==null){
            throw new NoSuchElementException();
        }
        return person;
    }

    @Override
    public Person save(Person person) {
        person.setId("0");
        TypeDocument type_search = typeDocumentRepository.findById(person.getType_document());
        person.setType_document(type_search);
        if(person==null ||person.getCedula().isEmpty() ||
                person.getName().isEmpty() ||
                person.getAge()<18 ||
                person.getEmail().isEmpty()
                ) {
            throw new EmptyInputException();
        }
        personDao.save(person);

        return person;
    }

    @Override
    public Person update(Person person) {
        Person person_send = new Person();
        try {
            Person person_find = personDao.findById(person.getId()).get();
            if(person==null){
                throw new NoSuchElementException();
            }
            person_find.setName(person.getName());
            person_find.setEmail(person.getEmail());
            person_find.setAge(person.getAge());
            person_find.setType_document(person.getType_document_all());
            personDao.save(person_find);

            return person;
        }catch (Exception e) {
            return person_send;
        }
    }

    @Override
    public boolean deleteById(String id) {
        try {
            personDao.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }

    }
}
