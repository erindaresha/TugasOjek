package com.resha.TugasOjek.service;

import com.resha.TugasOjek.model.User;

import java.util.List;

public interface UserService {

    User findByName(String name);

    User findById(Long id);

    List<User> findAllUser();

    User editUser(Long id, String name);

    User createUser(String name, int balance);

    void deleteUser(Long id);
}
