package com.apirest.application.repository;

import com.apirest.infrastructure.dao.TypeDocumentDAO;

import com.apirest.domain.entity.TypeDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class TypeDocumentRepositoryImpl implements TypeDocumentRepository{

    @Autowired
    private TypeDocumentDAO typeDocumentDAO;

    @Override
    public List<TypeDocument> findAll() {
        List<TypeDocument> listPersons = typeDocumentDAO.findAll();
        return listPersons;
    }

    @Override
    public TypeDocument findById(String id) {
        TypeDocument result = typeDocumentDAO.findById(id).get();
        if(result==null){
            throw new NoSuchElementException();
        }
        return result;
    }
}
