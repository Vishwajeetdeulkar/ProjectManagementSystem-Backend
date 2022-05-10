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
        try {
            List<User> managers = adminService.getAllManager();
            logger.info("[AdminController] - [Get All Manager]");
            return ResponseEntity.ok(managers);
        }catch(Exception e){
            logger.error("[AdminController] - [Error in Get All Manager]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getEmployeeData", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployee()
    {
        try {
            List<User> emps = adminService.getAllEmployee();
            logger.info("[AdminController] - [Get All Employee]");
            return ResponseEntity.ok(emps);
        }catch (Exception e){
            logger.error("[AdminController] - [Error in Get All Employee]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public ResponseEntity<?> deleteUser(@RequestParam Map<String,String> param)
    {
        try {
            Map<String,String> res = adminService.deleteUser(param);
            logger.info("[AdminController] - [Delete User]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("[AdminController] - [Error in Delete User]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
}
