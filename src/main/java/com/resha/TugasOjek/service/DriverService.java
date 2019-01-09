package com.resha.TugasOjek.service;

import com.resha.TugasOjek.model.Driver;

import java.util.List;

public interface DriverService {

    public abstract Driver getDriverById(Long id);

    public abstract List<Driver> listDrivers();

    public abstract Driver updateDriver(Long id, String name, int balance);

    public abstract Driver createDriver(String name, int balance);

    public abstract void deleteDriver(Long id);
}
