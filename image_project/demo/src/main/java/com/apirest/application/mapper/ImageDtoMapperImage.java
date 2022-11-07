package com.apirest.application.mapper;

import com.apirest.infrastructure.dto.ImageDto;
import com.apirest.domain.entity.Image;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ImageDtoMapperImage {
    ImageDto toImageDto(Image image);
    Image toImage(ImageDto imageDto);
    List<ImageDto> listToImageDto(List<Image> image);
    Optional<ImageDto> optionalToImageDto(Optional<Image> image);
}
