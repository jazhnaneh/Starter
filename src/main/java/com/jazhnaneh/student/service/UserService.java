package com.jazhnaneh.student.service;

import com.jazhnaneh.student.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findByUserName(String userName);
}
