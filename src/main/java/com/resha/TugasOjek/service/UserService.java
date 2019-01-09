package com.resha.TugasOjek.service;

import com.resha.TugasOjek.model.User;

import java.util.List;

public interface UserService {

    public abstract User getUserById(Long id);

    public abstract List<User> listUsers();

    public abstract User updateUser(Long id, String name, int balance);

    public abstract User createUser(String name, int balance);

    public abstract void deleteUser(Long id);
}
