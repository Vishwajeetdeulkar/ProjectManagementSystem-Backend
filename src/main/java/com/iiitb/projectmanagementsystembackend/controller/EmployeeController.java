package com.iiitb.projectmanagementsystembackend.controller;

import com.iiitb.projectmanagementsystembackend.data.model.Project;
import com.iiitb.projectmanagementsystembackend.data.model.Task;
import com.iiitb.projectmanagementsystembackend.service.EmployeeService;
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

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/getAllProjects",method = RequestMethod.GET)
    public ResponseEntity<?> getAllProjects()
    {
        System.out.println("in get projects controller");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        System.out.println(username);
        List<Project> projects = employeeService.getAllProjects(username);
        return  ResponseEntity.ok(projects);
    }

    @RequestMapping(value = "/getTaskByProject",method = RequestMethod.GET)
    public ResponseEntity<?> getAllTaskByProjectByUser(@RequestParam Map<String,String> param)
    {
        System.out.println("In get all task by project by user controller");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        System.out.println(username);
        List<Task> res = employeeService.getAllTaskByProjectByUser(param,username);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/updateTaskStatus",method = RequestMethod.POST)
    public ResponseEntity<?> updateTaskStatus(@RequestBody Map<String,String> payload)
    {
        System.out.println("In update task status controller");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        System.out.println(username);
        List<Task> res = employeeService.updateTaskStatus(payload,username);
        return ResponseEntity.ok(res);
    }
}
