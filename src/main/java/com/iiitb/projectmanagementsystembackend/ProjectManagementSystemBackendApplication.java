package com.iiitb.projectmanagementsystembackend;

import com.iiitb.projectmanagementsystembackend.data.model.Role;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.model.UserDto;
import com.iiitb.projectmanagementsystembackend.data.repository.RoleDao;
import com.iiitb.projectmanagementsystembackend.data.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectManagementSystemBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementSystemBackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
