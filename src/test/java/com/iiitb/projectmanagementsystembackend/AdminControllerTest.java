package com.iiitb.projectmanagementsystembackend;

import com.iiitb.projectmanagementsystembackend.data.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp(){
        super.setUp();
    }

    @Test
    @WithMockUser
    public void  getAllManagerTest() throws Exception
    {
        String uri = "/admin/getManagerData";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<User> userList = super.mapFromJson(content, List.class);
        assertTrue(userList.size() > 0);

    }
}
