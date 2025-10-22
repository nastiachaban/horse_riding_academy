package com.example.school.repos;

import com.example.school.entities.Lesson;
import com.example.school.entities.LessonId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepo extends JpaRepository<Lesson, LessonId> {
}
