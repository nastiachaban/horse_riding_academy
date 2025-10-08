package com.example.school.repos;

import com.example.school.entities.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepo extends JpaRepository<Horse, Long> {
}
