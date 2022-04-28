package com.iiitb.projectmanagementsystembackend.controller;

import com.iiitb.projectmanagementsystembackend.data.model.Project;
import com.iiitb.projectmanagementsystembackend.service.ManagerService;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ResponseEntity<?> addProject(@RequestBody Map<String,String> payload)
    {
        System.out.println("in add project controller");
        Map<String,String> res = managerService.addProject(payload);
        return  ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/getAllProject", method = RequestMethod.POST)
    public ResponseEntity<?> getAllProject(@RequestBody Map<String,String> payload)
    {
        System.out.println("in get project controller");
        List<Project> projects = managerService.getAllProject(payload);
        return  ResponseEntity.ok(projects);
    }

}
