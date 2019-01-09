package com.resha.TugasOjek.controller;

import com.resha.TugasOjek.repository.UserRepository;
import com.resha.TugasOjek.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;
}
