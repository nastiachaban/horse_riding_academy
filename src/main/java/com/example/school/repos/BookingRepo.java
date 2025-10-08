package com.example.school.repos;

import com.example.school.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}
