package com.iiitb.projectmanagementsystembackend.service.impl;

import com.iiitb.projectmanagementsystembackend.data.model.Project;
import com.iiitb.projectmanagementsystembackend.data.repository.ProjectDao;
import com.iiitb.projectmanagementsystembackend.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "managerService")
public class ManagerServiceimpl implements ManagerService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> getAllProject(Map<String,String> payload){
        List<Project> projects = new ArrayList<Project>();
        long id = Long.parseLong(payload.get("id"));
        projectDao.getAllProjectByUserId(id).forEach(project -> projects.add(project));
        return  projects;
    }

    @Override
    public Map<String,String> addProject(Map<String,String> payload){
        Map<String,String> res = new HashMap<>();
        Project project = new Project();
        project.setProjectname(payload.get("name"));
        project.setDescription(payload.get("description"));
        projectDao.save(project);
        res.put("msg","Project Added");
        return res;
    }
}
