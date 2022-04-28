package com.iiitb.projectmanagementsystembackend;

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
    //UserDao ob;
    //private UserService ob;
    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementSystemBackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//       UserDto first = new UserDto("m1", "m", "m1@manager.org", "1234567789", "1234567789", "manager");
//       ob.save(first);

    }
}
