package com.resha.TugasOjek.repository;

import com.resha.TugasOjek.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAll();

    Booking findByIdEquals(Long id);
}
