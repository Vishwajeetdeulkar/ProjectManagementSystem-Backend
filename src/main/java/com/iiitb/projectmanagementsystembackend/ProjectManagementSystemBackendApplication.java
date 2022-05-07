package com.iiitb.projectmanagementsystembackend;

import com.iiitb.projectmanagementsystembackend.controller.UserController;
import com.iiitb.projectmanagementsystembackend.data.model.Project;
import com.iiitb.projectmanagementsystembackend.data.model.Role;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.model.UserDto;
import com.iiitb.projectmanagementsystembackend.data.repository.RoleDao;
import com.iiitb.projectmanagementsystembackend.data.repository.UserDao;
import com.iiitb.projectmanagementsystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectManagementSystemBackendApplication implements CommandLineRunner {
   // @Autowired
    //UserDao ob1;
    //private UserService ob;
    //private UserDto user;
   @Autowired
   private UserService userService;
    UserController ob = new UserController();
    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementSystemBackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
         UserDto first = new UserDto("admin", "admin", "admin@admin.org", "9960429909", "Neha Kothari", "admin");
        userService.save(first);

    }
}
