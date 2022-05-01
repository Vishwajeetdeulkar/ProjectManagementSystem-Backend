package com.iiitb.projectmanagementsystembackend.service;

import com.iiitb.projectmanagementsystembackend.data.model.Project;
import com.iiitb.projectmanagementsystembackend.data.model.Task;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Project> getAllProjects(String username);
    List<Task> getAllTaskByProjectByUser(Map<String,String> param,String username);
    List<Task> updateTaskStatus(Map<String,String> payload,String username);
}
