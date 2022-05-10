package com.iiitb.projectmanagementsystembackend.controller;

import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LogManager.getLogger("ProjectManagementSystem");

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/getManagerData", method = RequestMethod.GET)
    public ResponseEntity<?> getAllManager()
    {
        logger.info("[AdminController] - [Get All Manager]");
        List<User> managers = adminService.getAllManager();
        return ResponseEntity.ok(managers);
    }

    @RequestMapping(value = "/getEmployeeData", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployee()
    {
        logger.info("[AdminController] - [Get All Employee]");
        List<User> emps = adminService.getAllEmployee();
        return ResponseEntity.ok(emps);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public ResponseEntity<?> deleteUser(@RequestParam Map<String,String> param)
    {
        logger.info("[AdminController] - [Delete User]");
        Map<String,String> res = adminService.deleteUser(param);
        return ResponseEntity.ok(res);
    }
}
