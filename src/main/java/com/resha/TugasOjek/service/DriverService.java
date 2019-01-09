package com.resha.TugasOjek.service;

import com.resha.TugasOjek.model.Driver;

import java.util.List;

public interface DriverService {

    Driver findByName(String name);

    Driver findById(Long id);

    List<Driver> findAllDriver();

    Driver editDriver(Long id, String name);

    Driver createDriver(String name, int balance);

    void deleteDriver(Long id);
}
