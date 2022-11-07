package com.apirest.sql.controller;

import com.apirest.infrastructure.dto.ImageDto;
import com.apirest.infrastructure.dto.PersonDto;
import com.apirest.application.service.ImageServiceInterface;
import com.apirest.infrastructure.controller.ImageController;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

class ImageRestControllerTest {

    @Mock
    private ImageServiceInterface imageServiceInterface;

    @InjectMocks
    private ImageController mongoRestController;

    private ImageDto image;
    private PersonDto person;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        person = new PersonDto();
        person.setName_person("Juan");
        person.setCedula_person("112323");
        person.setEmail_person("juan@gmail.com");
        person.setAge_person(23);
        person.setId_person("123");

        image = new ImageDto();
        image.setName_image("test");
        image.setId_image("123123");
        image.setExtension_image("jpg");
        image.setUrl_image("http://localhost:8080");
        image.setUpdatedAt_image(new Date());
        image.setCreatedAt_image(new Date());
        image.set_person_image(person);
    }


    @Test
    void getImages() {
        when(imageServiceInterface.findAll()).thenReturn(Arrays.asList(image));
        assertNotNull(mongoRestController.getImages());
    }

    @Test
    void getImage() {
        //when(imageServiceInterface.findById(image.getId_image())).thenReturn(image);
        assertNotNull(imageServiceInterface.findById(image.getId_image()));
        assertNotNull(mongoRestController.getImage(image.getId_image()));
    }

    @Test
    void addImage() throws Exception {
        when(imageServiceInterface.save(image))
                .thenReturn(image);
        when(imageServiceInterface
                .getPerson(Integer.parseInt(image.get_person_image().getId_person())))
                .thenReturn(person);
            MockMultipartFile file
                    = new MockMultipartFile(
                            "image",
                    "hello.png",
                    "image/png",
                    "/images/test.png".getBytes());

            var result =  mongoRestController.addImage(123,file);
            System.out.println(result);

    }

    @Test
    void updateImage() {
        when(imageServiceInterface.update(image)).thenReturn(image);
        assertNotNull(imageServiceInterface.findById(image.getId_image()));
        MockMultipartFile file = new MockMultipartFile( "file",
                "hello.jpeg",
                String.valueOf(MediaType.IMAGE_JPEG),
                "Hello, World!".getBytes());
        assertNotNull(mongoRestController.updateImage("123123", file));
    }

    @Test
    void deleteImage() {
        when(imageServiceInterface.delete(image.getId_image())).thenReturn(true);
        when(imageServiceInterface.findById(image.getId_image())).thenReturn(image);
       // assertNotNull(mongoRe+stController.deleteImage(image.getId_image()));
    }


}