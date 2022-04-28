package com.iiitb.projectmanagementsystembackend.controller;

import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/getManagerData", method = RequestMethod.GET)
    public ResponseEntity<?> getAllManager(){
        System.out.println("in admin get manager data controller");
        List<User> managers = adminService.getAllManager();
        return ResponseEntity.ok(managers);
    }

    @RequestMapping(value = "/getEmployeeData", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployee(){
        System.out.println("in admin get employee data controller");
        List<User> emps = adminService.getAllEmployee();
        return ResponseEntity.ok(emps);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public ResponseEntity<?> deleteUser(@RequestParam Map<String,String> param){
        System.out.println("in delete user controller");
        Map<String,String> res = adminService.deleteUser(param);
        return ResponseEntity.ok(res);
    }
}
