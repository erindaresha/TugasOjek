package com.resha.TugasOjek.repository;

import com.resha.TugasOjek.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findByName(String name);
    Driver findById(Long id);
}
