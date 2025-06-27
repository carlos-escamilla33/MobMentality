package com.carlosescamilla.mob.band_website.service;

import com.carlosescamilla.mob.band_website.entity.Image;
import com.carlosescamilla.mob.band_website.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image getImageByFilename(String filename) {
        return imageRepository.findByFilename(filename);
    }

    public List<Image> findByContentType(String contentType) {
        return imageRepository.findByContentType(contentType);
    }

    public void deleteImage(Image image) {
        imageRepository.delete(image);
    }

    public void deleteImageById(Long id) {
        imageRepository.deleteById(id);
    }
}
