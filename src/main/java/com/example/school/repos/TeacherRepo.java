package com.example.school.repos;

import com.example.school.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}
