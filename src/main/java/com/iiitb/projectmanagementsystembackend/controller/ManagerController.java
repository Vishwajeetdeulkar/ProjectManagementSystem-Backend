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
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            Project res = managerService.addProject(payload, username);
            res = managerService.initializeEffortTable(res);
            logger.info("200 - [ManagerController] - [Add Project]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("400 - [ManagerController] - [Error in Add Project]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/updateProject",method = RequestMethod.POST)
    public ResponseEntity<?> updateProject(@RequestBody Map<String,String> payload)
    {
        try {

        Project res = managerService.updateProject(payload);
        logger.info("200 - [ManagerController] - [Update Project]");
        return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("400 - [ManagerController] - [Error in Update Project]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeProject(@RequestParam Map<String,String> param)
    {
        try {
            Map<String ,String> res = managerService.removeProject(param);
            logger.info("200 - [ManagerController] - [Remove Project]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("400 - [ManagerController] - [Error in Remove Project]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getAllProject", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProject()
    {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            List<Project> projects = managerService.getAllProject(username);
            logger.info("200 - [ManagerController] - [Get All Project]");
            return ResponseEntity.ok(projects);
        }catch (Exception e){
            logger.error("400 - [ManagerController] - [Error in Get All Project]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getFreeEmployee",method = RequestMethod.GET)
    public ResponseEntity<?> getFreeEmployee(@RequestParam Map<String,String> param)
    {
        try {
            List<User> freeEmployee = managerService.getFreeEmployee(param);
            logger.info("200 - [ManagerController] - [Get Free Employee]");
            return ResponseEntity.ok(freeEmployee);
        }catch (Exception e){
            logger.error("400 - [ManagerController] - [Error in Get Free Employee]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/addUserToProject",method = RequestMethod.POST)
    public ResponseEntity<?> addUserToProject(@RequestBody Map<String,Object> payload)
    {
        try {
            Project res = managerService.addUserToProject(payload);
            logger.info("200 - [ManagerController] - [Add User TO Project]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("400 - [ManagerController] - [Error in Add User TO Project]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeUserFromProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeUserFromProject(@RequestParam Map<String,String> param)
    {
        try {
            Project res = managerService.removeUserFromProject(param);
            logger.info("200 - [ManagerController] - [Remove User From Project]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("400 - [ManagerController] - [Remove User From Project]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @RequestMapping(value = "/addTaskToProject",method = RequestMethod.POST)
    public ResponseEntity<?> addTaskToProject(@RequestBody Map<String,String> payload)
    {
        try {
            Project res = managerService.addTaskToProject(payload);
            logger.info("200 - [ManagerController] - [Add Task To Project]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("400 - [ManagerController] - [Error in Add Task To Project]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeTaskFromProject",method = RequestMethod.GET)
    public ResponseEntity<?> removeTaskFromProject(@RequestParam Map<String,String> param)
    {
        try {
            Project res = managerService.removeTaskFromProject(param);
            logger.info("200 - [ManagerController] - [Remove Task From Project]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("400 - [ManagerController] - [Error in Remove Task From Project]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/updateEffortTable",method = RequestMethod.POST)
    public ResponseEntity<?> updateEffortTable(@RequestBody Map<String,String> payload)
    {
        try {
            Project res = managerService.updateEffortTable(payload);
            logger.info("200 - [ManagerController] - [Update Effort Table]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("400 - [ManagerController] - [Error in Update Effort Table]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
