package com.apirest.application.service;

import com.apirest.infrastructure.dto.ImageDto;
import com.apirest.infrastructure.dto.PersonDto;
import com.apirest.application.mapper.ImageDtoMapperImage;
import com.apirest.application.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageServiceInterface {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private  ImageDtoMapperImage imageDtoMapperImage;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ImageDto> findAll() {
        return imageDtoMapperImage.listToImageDto(imageRepository.findAll());
    }

    @Override
    public ImageDto findById(String id) {
        return imageRepository.findById(id)
                .map(imageDtoMapperImage::toImageDto)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));
    }

    @Override
    public List<ImageDto> findListByPerson(String id) {
        return imageDtoMapperImage.listToImageDto(imageRepository.findListByPerson(id));
    }

    @Override
    public ImageDto save(ImageDto image) {
        return imageDtoMapperImage.toImageDto(imageRepository.save(imageDtoMapperImage.toImage(image)));
    }

    @Override
    public ImageDto update(ImageDto image) {
        return imageDtoMapperImage.toImageDto(imageRepository.update(imageDtoMapperImage.toImage(image)));
    }

    @Override
    public boolean delete(String id) {
        return imageRepository.delete(id);
    }

    @Override
    public boolean deleteByPerson(String id) {
        return imageRepository.deleteByPerson(id);
    }

    @Override
    public PersonDto getPerson(int id) {
        PersonDto  get_person = restTemplate.getForObject("http://localhost:8081/persons/"+ id, PersonDto.class);
        return get_person;
    }
}
