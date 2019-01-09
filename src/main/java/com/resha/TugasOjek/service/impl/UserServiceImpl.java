package com.resha.TugasOjek.service.impl;

import com.resha.TugasOjek.model.User;
import com.resha.TugasOjek.repository.UserRepository;
import com.resha.TugasOjek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @Override
    public  User editUser(Long id, String name){
        User user = userRepository.findById(id);
        user.setName(name);
        return userRepository.save(user);
    }

    @Override
    public User createUser(String name, int balance) {
        User user = new User(name, balance);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
