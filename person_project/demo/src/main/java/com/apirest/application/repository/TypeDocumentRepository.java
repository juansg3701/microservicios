package com.apirest.application.repository;


import com.apirest.domain.entity.TypeDocument;

import java.util.List;

public interface TypeDocumentRepository {
    List<TypeDocument> findAll();
    TypeDocument findById(String id);
}
