package com.apirest.application.repository;

import com.apirest.domain.entity.Image;
import com.apirest.infrastructure.dao.ImageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {
    @Autowired
    private final ImageDAO imageDao;

    @Override
    public List<Image> findAll() {
        List<Image> array_imprimir =  imageDao.findAll();
        return array_imprimir;
    }

    @Override
    public Optional<Image> findById(String id) {
        Optional<Image> image_imprimir =  imageDao.findById(id);
        if(image_imprimir==null){
            throw new NoSuchElementException();
        }
        return image_imprimir;
    }

    @Override
    public List<Image> findListByPerson(String personId) {
        return imageDao.findAllByPerson(personId);
    }

    @Override
    public Image save(Image image) {
        return imageDao.save(image);
    }

    @Override
    public Image update(Image image) {
        return imageDao.save(image);
    }

    @Override
    public boolean delete(String id) {
        try {
            imageDao.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteByPerson(String id) {
        List<Image> images = imageDao.findAllByPerson(id);
        if(images.size() == 0) {
            throw new NoSuchElementException();
        }

        for (Image img : images) {
            try{
                Path rutaCompleta = Paths.get("demo/src/main/resources/images");
                Path ruta_eliminar_imagen = Paths.get(rutaCompleta+"/"+ img.getName()+"."+ img.getExtension());
                Files.delete(ruta_eliminar_imagen);
                imageDao.deleteById(img.get_id());
            }catch (IOException e) {
                throw new RuntimeException("Error al eliminar la imagen: " + e.getMessage());
            }
        }

        return true;
    }
}
