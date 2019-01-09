package com.resha.TugasOjek.controller;

import com.resha.TugasOjek.model.User;
import com.resha.TugasOjek.repository.UserRepository;
import com.resha.TugasOjek.service.UserService;
import com.resha.TugasOjek.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/api/getAllUsers"}, method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.listUsers();
    }

    @RequestMapping(value = {"/api/getUserById/{id}"}, method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
}
