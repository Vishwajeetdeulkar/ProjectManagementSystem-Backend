package com.iiitb.projectmanagementsystembackend;

import com.iiitb.projectmanagementsystembackend.data.model.LoginUser;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.model.UserDto;
import com.iiitb.projectmanagementsystembackend.data.repository.UserDao;
import com.iiitb.projectmanagementsystembackend.service.AdminService;
import com.iiitb.projectmanagementsystembackend.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@EnableWebMvc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProjectManagementSystemBackendApplicationTests  extends AbstractTest{

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    WebApplicationContext webApplicationContext;
    protected MockMvc mvc;
    @BeforeEach
    protected void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Order(1)
    void contextLoads() {
    }

    @Test
    @Order(2)
    void  getAllManagerTest() throws Exception
    {
        String  uri = "/admin/getManagerData";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        try {
            assertEquals( 200, status);
            System.out.println("Get All Manager Data : Success");
        }catch(Exception e) {
            System.out.println("Get All Manager Data : Fail");
        }
        String  content = mvcResult.getResponse().getContentAsString();
        List<User> userList = super.mapFromJson(content, List.class);

    }


    @Test
    @Order(3)
    void  getAllEmployeeTest() throws Exception
    {
        String  uri = "/admin/getEmployeeData";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        try {
            assertEquals( 200, status);
            System.out.println("Get All Employee Data : Success");
        }catch(Exception e) {
            System.out.println("Get All Employee Data : Fail");
        }
        String  content = mvcResult.getResponse().getContentAsString();
        List<User> userList = super.mapFromJson(content, List.class);

    }

    @Test
    @Order(4)
    void  registerUserAndDeleteUserTest() throws Exception
    {
        String user = "{\"username\":\"test\",\"password\":\"test\",\"email\":\"test@manager.org\",\"phone\":\"7894561230\",\"name\":\"test\",\"businessTitle\":\"manager\"}";
        String  uri = "/users/register";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(user)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();

        String content = mvcResult.getResponse().getContentAsString();
        try {
            assertEquals( 200, status);
            System.out.println("Register User : Success");
        }catch(Exception e) {
            System.out.println("Register User : Fail");
        }
        long userId = super.mapFromJson(content,User.class).getId();
        uri = "/admin/deleteUser";
        mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .param("userId",Long.toString(userId))
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        status = mvcResult.getResponse().getStatus();
        try {
            assertEquals( 200, status);
            System.out.println("Remove User : Success");
        }catch(Exception e) {
            System.out.println("Remove User : Fail");
        }
    }

}
