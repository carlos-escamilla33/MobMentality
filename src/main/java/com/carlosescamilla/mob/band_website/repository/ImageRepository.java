package com.carlosescamilla.mob.band_website.repository;

import com.carlosescamilla.mob.band_website.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByFilename(String filename);
}
