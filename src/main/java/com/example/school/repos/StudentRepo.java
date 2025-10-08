package com.example.school.repos;

import com.example.school.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
