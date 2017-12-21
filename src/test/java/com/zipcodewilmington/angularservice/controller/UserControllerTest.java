package com.zipcodewilmington.angularservice.controller;

import com.zipcodewilmington.angularservice.model.User;
import com.zipcodewilmington.angularservice.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by leon on 12/20/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = UserController.class,secure = false)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    User mockUser = new User(1L,"Zach");
    String example = "{\"id\":1,\"firstName\":\"Zach\"}";

    @Test
    public void createTest() throws Exception {

        Mockito.when(userService.add(Mockito.any(User.class))).thenReturn(mockUser);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .content(example)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(example));

    }

    @Test
    public void getByIdTest() throws Exception{
        Mockito.when(userService.getById(Mockito.anyLong())).thenReturn(mockUser);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(example));
    }
}
