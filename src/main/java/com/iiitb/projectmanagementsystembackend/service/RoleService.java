package com.iiitb.projectmanagementsystembackend.service;

import com.iiitb.projectmanagementsystembackend.data.model.Role;

public interface RoleService {
    Role findByName(String name);
}

