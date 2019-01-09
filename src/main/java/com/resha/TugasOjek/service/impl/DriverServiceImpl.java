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
    public Driver findByName(String name) {
        return driverRepository.findByName(name);
    }

    @Override
    public Driver findById(Long id) {
        return driverRepository.findById(id);
    }

    @Override
    public List<Driver> findAllDriver(){
        return driverRepository.findAll();
    }

    @Override
    public  Driver editDriver(Long id, String name){
        Driver driver = driverRepository.findById(id);
        driver.setName(name);
        return driverRepository.save(driver);
    }

    @Override
    public Driver createDriver(String name, int balance) {
        Driver driver = new Driver(name, balance);
        return driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(Long id) {
        driverRepository.delete(id);
    }
}
