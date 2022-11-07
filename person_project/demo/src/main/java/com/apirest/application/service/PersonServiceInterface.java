package com.apirest.application.service;

import com.apirest.infrastructure.dto.ImageDto;
import com.apirest.infrastructure.dto.PersonDto;

import java.util.List;

public interface PersonServiceInterface {
    List<PersonDto> findAll();
    PersonDto findById(String id);
    PersonDto save(PersonDto person);
    PersonDto update(PersonDto person);
    boolean deleteById(String id);
    void deleteImages(String id);
    List<ImageDto> getImages(String id);

}
