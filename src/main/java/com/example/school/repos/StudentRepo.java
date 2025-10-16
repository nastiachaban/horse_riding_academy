package com.example.school.repos;

import com.example.school.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> getStudentByAccountId(Long AccountId);
}
