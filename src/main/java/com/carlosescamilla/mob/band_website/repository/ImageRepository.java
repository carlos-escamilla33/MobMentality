package com.carlosescamilla.mob.band_website.repository;

import com.carlosescamilla.mob.band_website.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    // CREATE/UPDATE
    Image save(Image image);

    // READ
    List<Image> findByContentType(String contentType);
    List<Image> findByFilename(String filename);

    // DELETE
    void deleteById(Long id);
    void delete(Image image);
}
