package com.example.school.repos;

import com.example.school.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepo extends JpaRepository<Picture, Long> {
}
