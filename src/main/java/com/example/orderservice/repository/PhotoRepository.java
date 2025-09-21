package com.example.orderservice.repository;

import com.example.orderservice.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    // найти по ключу (photoKey должен быть уникальным)
    Optional<Photo> findByPhotoKey(String photoKey);

    // проверить существование по ключу
    boolean existsByPhotoKey(String photoKey);

    // найти по ссылке (если используется прямой URL)
    Optional<Photo> findByUrl(String url);

    // найти все фото с флагом "вертикальная"
    List<Photo> findByHasVerticalPhotoTrue();

    // найти все фото по цвету
    List<Photo> findByColor(String color);
}
