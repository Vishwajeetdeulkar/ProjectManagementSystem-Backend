package com.iiitb.projectmanagementsystembackend.service;

import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.model.UserDto;

import java.util.List;
import java.util.Map;

public interface UserService {
    User save(Map<String,String> payload);
    List<User> findAll();
    User findOne(String username);
}
