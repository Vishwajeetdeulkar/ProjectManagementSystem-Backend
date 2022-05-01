package com.iiitb.projectmanagementsystembackend.service;

import com.iiitb.projectmanagementsystembackend.data.model.Role;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "adminService")
public class AdminService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    public List<User> getAllManager(){
        System.out.println("int admin get all manager service");
        List<User> managers = new ArrayList<User>();
        userDao.getAllManager().forEach(manager->managers.add(manager));
        return managers;
    }

    public List<User> getAllEmployee(){
        System.out.println("int admin get all employee service");
        List<User> emps = new ArrayList<User>();
        userDao.getAllEmployee().forEach(emp->emps.add(emp));
        return emps;
    }

    public Map<String,String> deleteUser(Map<String,String> param){
        System.out.println("in deleteuser service");
        long id = Long.parseLong(param.get("userId"));
        System.out.println(id);
//        userDao.deleteUser(id);
        userDao.deleteById(id);
        Map<String,String> res = new HashMap<>();
        res.put("msg","User Deleted");
        return res;
    }


}
