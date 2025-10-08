package com.example.school.repos;

import com.example.school.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepo extends JpaRepository<Worker, Long> {
}
