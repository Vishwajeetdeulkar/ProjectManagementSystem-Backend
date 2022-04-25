package com.iiitb.projectmanagementsystembackend.service;

import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.model.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
