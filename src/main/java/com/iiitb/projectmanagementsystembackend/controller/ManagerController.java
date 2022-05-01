package com.iiitb.projectmanagementsystembackend.controller;

import com.iiitb.projectmanagementsystembackend.data.model.Project;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.service.ManagerService;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        System.out.println(username);
        Project res = managerService.addProject(payload,username);
        res = managerService.initializeEffortTable(res);
        return  ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/updateProject",method = RequestMethod.POST)
    public ResponseEntity<?> updateProject(@RequestBody Map<String,String> payload)
    {
        System.out.println("In update project controller");
        Project res = managerService.updateProject(payload);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/removeProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeProject(@RequestParam Map<String,String> param)
    {
        System.out.println("in remove project controller");
        Map<String ,String> res = managerService.removeProject(param);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/getAllProject", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProject()
    {
        System.out.println("in get project controller");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        System.out.println(username);
        List<Project> projects = managerService.getAllProject(username);
        return  ResponseEntity.ok(projects);
    }

    @RequestMapping(value = "/getFreeEmployee",method = RequestMethod.GET)
    public ResponseEntity<?> getFreeEmployee(@RequestParam Map<String,String> param){
        System.out.println("in get free employeecontroller");
        List<User> freeEmployee = managerService.getFreeEmployee(param);
        return ResponseEntity.ok(freeEmployee);
    }

    @RequestMapping(value = "/addUserToProject",method = RequestMethod.POST)
    public ResponseEntity<?> addUserToProject(@RequestBody Map<String,Object> payload){
        System.out.println("in add user to project controller");
        System.out.println(payload.toString());
        Project res = managerService.addUserToProject(payload);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/removeUserFromProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeUserFromProject(@RequestParam Map<String,String> param)
    {
        System.out.println("in remove user from project controller");
        Project res = managerService.removeUserFromProject(param);
        return ResponseEntity.ok(res);
    }


    @RequestMapping(value = "/addTaskToProject",method = RequestMethod.POST)
    public ResponseEntity<?> addTaskToProject(@RequestBody Map<String,String> payload){
        System.out.println("in add Task to project controller");
        System.out.println(payload.toString());
        Project res = managerService.addTaskToProject(payload);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/removeTaskFromProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeUserTaskProject(@RequestParam Map<String,String> param)
    {
        System.out.println("in remove Task from project controller");
        Project res = managerService.removeTaskFromProject(param);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/updateEffortTable",method = RequestMethod.POST)
    public ResponseEntity<?> updateEffortTable(@RequestBody Map<String,String> payload)
    {
        System.out.println("In update effort table");
        Project res = managerService.updateEffortTable(payload);
        return ResponseEntity.ok(res);
    }




}
