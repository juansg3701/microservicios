package com.apirest.application.service;

import com.apirest.infrastructure.dto.ImageDto;
import com.apirest.infrastructure.dto.PersonDto;
import com.apirest.application.mapper.PersonDtoMapperPerson;
import com.apirest.application.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonServiceInterface{
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonDtoMapperPerson personDtoMapperPerson;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<PersonDto> findAll() {
        return personDtoMapperPerson.listToPersonDto(personRepository.findAll());
    }

    @Override
    public PersonDto findById(String id) {
        return personDtoMapperPerson.toPersonDto(personRepository.findById(id));
    }

    @Override
    public PersonDto save(PersonDto person) {
        return personDtoMapperPerson.toPersonDto(personRepository.save(personDtoMapperPerson.toPerson(person)));
    }

    @Override
    public PersonDto update(PersonDto person) {
        return personDtoMapperPerson.toPersonDto(personRepository.update(personDtoMapperPerson.toPerson(person)));
    }

    @Override
    public boolean deleteById(String id) {
        return personRepository.deleteById(id);
    }

    @Override
    public void deleteImages(String id) {
        restTemplate.delete("http://localhost:8082/imagesmongo/deleteByPerson/"+ id, String.class);
    }

    @Override
    public List<ImageDto> getImages(String id) {
        return restTemplate.getForObject("http://localhost:8082/imagesmongo/getImageByPerson/"+ id, List.class);
    }
}
