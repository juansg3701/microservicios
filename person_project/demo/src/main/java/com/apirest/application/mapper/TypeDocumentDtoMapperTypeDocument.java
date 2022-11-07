package com.apirest.application.mapper;

import com.apirest.infrastructure.dto.TypeDocumentDto;
import com.apirest.domain.entity.TypeDocument;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper
public interface TypeDocumentDtoMapperTypeDocument {
    TypeDocumentDto toTypeDocumentDto(TypeDocument person);
    TypeDocument toTypeDocument(TypeDocumentDto personDto);
    List<TypeDocumentDto> listToTypeDocumentDto(List<TypeDocument> person);
}
