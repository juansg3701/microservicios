package com.apirest.application.service;

import com.apirest.infrastructure.dto.ImageDto;
import com.apirest.infrastructure.dto.PersonDto;

import java.util.List;

public interface ImageServiceInterface {
    List<ImageDto> findAll();
    ImageDto findById(String id);
    List<ImageDto> findListByPerson(String id);
    ImageDto save(ImageDto image);
    ImageDto update(ImageDto image);
    boolean delete(String id);
    boolean deleteByPerson(String id);
    PersonDto getPerson(int id);
}
