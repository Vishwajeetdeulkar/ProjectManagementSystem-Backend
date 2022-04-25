package com.iiitb.projectmanagementsystembackend.service.impl;


import com.iiitb.projectmanagementsystembackend.data.repository.RoleDao;
import com.iiitb.projectmanagementsystembackend.data.model.Role;
import com.iiitb.projectmanagementsystembackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}