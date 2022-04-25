package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}