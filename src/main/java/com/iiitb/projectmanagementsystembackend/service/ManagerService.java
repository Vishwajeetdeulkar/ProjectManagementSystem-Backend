package com.iiitb.projectmanagementsystembackend.service;

import com.iiitb.projectmanagementsystembackend.data.model.Project;

import java.util.List;
import java.util.Map;

public interface ManagerService {
    List<Project> getAllProject(Map<String,String> payload);
    Map<String,String> addProject(Map<String,String> payload);
}
