package com.apirest.infrastructure.dao;


import com.apirest.domain.entity.TypeDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDocumentDAO extends JpaRepository<TypeDocument, String> {
}
