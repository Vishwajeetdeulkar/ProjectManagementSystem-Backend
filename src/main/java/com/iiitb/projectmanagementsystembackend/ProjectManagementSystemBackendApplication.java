package com.iiitb.projectmanagementsystembackend;

import com.iiitb.projectmanagementsystembackend.controller.UserController;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.model.UserDto;
import com.iiitb.projectmanagementsystembackend.data.repository.UserDao;
import com.iiitb.projectmanagementsystembackend.service.UserService;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class ProjectManagementSystemBackendApplication implements CommandLineRunner {
   // @Autowired
    //UserDao ob1;
    //private UserService ob;
    //private UserDto user;
   @Autowired
   private UserService userService;
    UserController ob = new UserController();
//    @Value("${http.port}")
//    private int httpPort;
    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementSystemBackendApplication.class, args);
    }

    @Autowired
    private UserDao userDao;
    @Override
    public void run(String... args) throws Exception {

        User user = userDao.findByUsername("admin");
        if(user==null) {
            Map<String, String> admin = new HashMap<>();
            admin.put("username", "admin");
            admin.put("password", "admin");
            admin.put("email", "admin@admin.org");
            admin.put("phone", "7894561230");
            admin.put("name", "admin");
            admin.put("businessTitle", "admin");
            userService.save(admin);
        }
    }

    // Let's configure additional connector to enable support for both HTTP and HTTPS

//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//        return tomcat;
//    }
//
//    private Connector createStandardConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setPort(httpPort);
//        return connector;
//    }
}
