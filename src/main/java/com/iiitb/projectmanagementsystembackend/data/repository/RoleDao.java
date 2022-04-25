package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}