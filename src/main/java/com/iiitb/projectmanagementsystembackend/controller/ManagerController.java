package com.iiitb.projectmanagementsystembackend.controller;

import com.iiitb.projectmanagementsystembackend.data.model.Project;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.service.ManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger("ProjectManagementSystem");

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ResponseEntity<?> addProject(@RequestBody Map<String,String> payload)
    {
        logger.info("[ManagerController] - [Add Project]");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        Project res = managerService.addProject(payload,username);
        res = managerService.initializeEffortTable(res);
        return  ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/updateProject",method = RequestMethod.POST)
    public ResponseEntity<?> updateProject(@RequestBody Map<String,String> payload)
    {
        logger.info("[ManagerController] - [Update Project]");
        Project res = managerService.updateProject(payload);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/removeProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeProject(@RequestParam Map<String,String> param)
    {
        logger.info("[ManagerController] - [Remove Project]");
        Map<String ,String> res = managerService.removeProject(param);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/getAllProject", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProject()
    {
        logger.info("[ManagerController] - [Get All Project]");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        List<Project> projects = managerService.getAllProject(username);
        return  ResponseEntity.ok(projects);
    }

    @RequestMapping(value = "/getFreeEmployee",method = RequestMethod.GET)
    public ResponseEntity<?> getFreeEmployee(@RequestParam Map<String,String> param)
    {
        logger.info("[ManagerController] - [Get Free Employee]");
        List<User> freeEmployee = managerService.getFreeEmployee(param);
        return ResponseEntity.ok(freeEmployee);
    }

    @RequestMapping(value = "/addUserToProject",method = RequestMethod.POST)
    public ResponseEntity<?> addUserToProject(@RequestBody Map<String,Object> payload)
    {
        logger.info("[ManagerController] - [Add User TO Project]");
        Project res = managerService.addUserToProject(payload);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/removeUserFromProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeUserFromProject(@RequestParam Map<String,String> param)
    {
        logger.info("[ManagerController] - [Re,ove User From Project]");
        Project res = managerService.removeUserFromProject(param);
        return ResponseEntity.ok(res);
    }


    @RequestMapping(value = "/addTaskToProject",method = RequestMethod.POST)
    public ResponseEntity<?> addTaskToProject(@RequestBody Map<String,String> payload)
    {
        logger.info("[ManagerController] - [Add Task To Project]");
        Project res = managerService.addTaskToProject(payload);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/removeTaskFromProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeTaskFromProject(@RequestParam Map<String,String> param)
    {
        logger.info("[ManagerController] - [Remove Task From Project]");
        Project res = managerService.removeTaskFromProject(param);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/updateEffortTable",method = RequestMethod.POST)
    public ResponseEntity<?> updateEffortTable(@RequestBody Map<String,String> payload)
    {
        logger.info("[ManagerController] - [Update Effort Table]");
        Project res = managerService.updateEffortTable(payload);
        return ResponseEntity.ok(res);
    }
}
