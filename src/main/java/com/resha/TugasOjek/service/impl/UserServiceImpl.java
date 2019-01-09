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
    private UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(String nama, int balance) {
        User user = new User(nama, balance);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, String nama, int balance) {
        User user = userRepository.findById(id);
        user.setName(nama);
        user.setBalance(balance);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
