package com.resha.TugasOjek.service.impl;

import com.resha.TugasOjek.model.Driver;
import com.resha.TugasOjek.repository.DriverRepository;
import com.resha.TugasOjek.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("driverService")
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;

    @Override
    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    @Override
    public Driver createDriver(String name, int balance) {
        Driver driver = new Driver(name, balance);
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Long id, String name, int balance) {
        Driver driver = driverRepository.findById(id);
        driver.setBalance(balance);
        driver.setName(name);
        return driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(Long id) {
        driverRepository.delete(id);
    }
}
