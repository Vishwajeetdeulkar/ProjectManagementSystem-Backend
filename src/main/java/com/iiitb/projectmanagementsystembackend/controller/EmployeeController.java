package com.iiitb.projectmanagementsystembackend.controller;

import com.iiitb.projectmanagementsystembackend.data.model.Project;
import com.iiitb.projectmanagementsystembackend.data.model.Task;
import com.iiitb.projectmanagementsystembackend.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = LogManager.getLogger("ProjectManagementSystem");

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/getAllProjects",method = RequestMethod.GET)
    public ResponseEntity<?> getAllProjects()
    {
        logger.info("[EmployeeController] - [Get All Projects]");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        List<Project> projects = employeeService.getAllProjects(username);
        return  ResponseEntity.ok(projects);
    }

    @RequestMapping(value = "/getTaskByProject",method = RequestMethod.GET)
    public ResponseEntity<?> getAllTaskByProjectByUser(@RequestParam Map<String,String> param)
    {
        logger.info("[EmployeeController] - [Get All Task By Project By User]");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        List<Task> res = employeeService.getAllTaskByProjectByUser(param,username);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/updateTaskStatus",method = RequestMethod.POST)
    public ResponseEntity<?> updateTaskStatus(@RequestBody Map<String,String> payload)
    {
        logger.info("[EmployeeController] - [Update Task Status]");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        List<Task> res = employeeService.updateTaskStatus(payload,username);
        return ResponseEntity.ok(res);
    }
}
