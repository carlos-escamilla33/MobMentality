package com.carlosescamilla.mob.band_website.service;

import com.carlosescamilla.mob.band_website.entity.Image;
import com.carlosescamilla.mob.band_website.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    private static final Set<String> ALLOWED_TYPES = Set.of("image/jpeg", "image/png", "image/gif");
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024;

    public Image saveImage(MultipartFile file) {
        this.validateFile(file);

        String sanitizeFilename = sanitizeFilename(file.getOriginalFilename());

        Image image = new Image(
                sanitizeFilename,
                file.getContentType()
        );

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

    private void validateFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is null or empty");
        }
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("File is empty");
        }
        if (!ALLOWED_TYPES.contains(file.getContentType())) {
            throw new IllegalArgumentException("Only image/jpeg/gif images allowed");
        }

        String filename = file.getOriginalFilename();
        if (filename == null || filename.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid filename");
        }
        if (imageRepository.findByFilename(filename) != null) {
            throw new IllegalArgumentException("Image already exists");
        }
    }

    private String sanitizeFilename(String filename) {
        return filename.replaceAll("[^a-zA-Z0-9]", "_");
    }
}
