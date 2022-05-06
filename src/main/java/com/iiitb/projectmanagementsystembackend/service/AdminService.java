package com.iiitb.projectmanagementsystembackend.service;

import com.iiitb.projectmanagementsystembackend.data.model.User;

import java.util.List;
import java.util.Map;

public interface AdminService {

    List<User> getAllManager();
    List<User> getAllEmployee();
    Map<String,String> deleteUser(Map<String,String> param);
}
