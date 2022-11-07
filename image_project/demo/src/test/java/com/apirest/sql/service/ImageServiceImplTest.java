package com.apirest.sql.service;

import com.apirest.infrastructure.dto.ImageDto;
import com.apirest.infrastructure.dto.PersonDto;
import com.apirest.application.mapper.ImageDtoMapperImage;
import com.apirest.application.service.ImageServiceImpl;
import com.apirest.domain.entity.Image;
import com.apirest.application.repository.ImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

class ImageServiceImplTest {

    @Mock
    private ImageRepository imageRepository;

    @Mock
    private ImageDtoMapperImage imageDtoMapperImage;
    @InjectMocks
    private ImageServiceImpl imageMongoService;

    private Image image;
    private ImageDto imageDto;
    private PersonDto person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        person = new PersonDto();
        person.setName_person("Juan");
        person.setEmail_person("juan@gmail.com");
        person.setId_person("123");

        image = new Image();
        image.setName("test");
        image.set_id("123123");
        image.setExtension("jpg");
        image.setUrl("http://localhost:8080");
        image.setUpdatedAt(new Date());
        image.setCreatedAt(new Date());
        image.set_person(person);

        imageDto = new ImageDto();
        imageDto.setName_image("test");
        imageDto.setId_image("123123");
        imageDto.setExtension_image("jpg");
        imageDto.setUrl_image("http://localhost:8080");
        imageDto.setUpdatedAt_image(new Date());
        imageDto.setCreatedAt_image(new Date());
        imageDto.set_person_image(person);
    }

    @Test
    void findAll() {
        when(imageRepository.findAll()).thenReturn(Arrays.asList(image));
        when(imageDtoMapperImage.listToImageDto(Arrays.asList(image))).thenReturn(Arrays.asList(imageDto));
        List<ImageDto> result = imageMongoService.findAll();
        assertEquals(imageDto, result.get(0));
        assertNotNull(imageMongoService.findAll());
    }

    @Test
    void findById() {
        when(imageRepository.findById(image.get_id()))
                .thenReturn(Optional.of(image));
        when(imageDtoMapperImage.toImageDto(image))
                .thenReturn(imageDto);
        ImageDto result = imageMongoService.findById(imageDto.getId_image());
        assertEquals(imageDto, result);
        assertNotNull(imageMongoService.findById(imageDto.getId_image()));
    }

    @Test
    void findListByPerson() {
        when(imageRepository.findListByPerson(image.get_id()))
                .thenReturn(Arrays.asList(image));
        when(imageDtoMapperImage.listToImageDto(Arrays.asList(image)))
                .thenReturn(Arrays.asList(imageDto));
        List<ImageDto> result = imageMongoService.findListByPerson(imageDto.getId_image());
        assertEquals(imageDto, result.get(0));
        assertNotNull(imageMongoService.findListByPerson(imageDto.getId_image()));
    }

    @Test
    void save() {
        when(imageRepository.save(image))
                .thenReturn(image);
        when(imageDtoMapperImage.toImageDto(image))
                .thenReturn(imageDto);
        when(imageDtoMapperImage.toImage(imageDto))
                .thenReturn(image);
        var result = imageMongoService.save(imageDto);
        assertEquals(imageDto, result);
        assertNotNull(imageMongoService.save(imageDto));
    }

    @Test
    void update() {
        when(imageRepository.update(image)).thenReturn(image);
        when(imageDtoMapperImage.toImageDto(image)).thenReturn(imageDto);
        when(imageDtoMapperImage.toImage(imageDto)).thenReturn(image);
        var result = imageMongoService.update(imageDto);
        assertEquals(imageDto, result);
        assertNotNull(imageMongoService.update(imageDto));
    }

    @Test
    void delete() {
        when(imageRepository.delete(image.get_id())).thenReturn(true);
        assertNotNull(imageMongoService.delete(imageDto.getId_image()));
    }

}