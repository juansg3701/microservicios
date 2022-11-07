package com.apirest.application.repository;

import com.apirest.domain.entity.Image;

import java.util.List;
import java.util.Optional;

public interface ImageRepository {
    List<Image> findAll();
    Optional<Image> findById(String id);
    List<Image> findListByPerson(String id);
    Image save(Image image);
    Image update(Image image);
    boolean delete(String id);
    boolean deleteByPerson(String id);
}
