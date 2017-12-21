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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by leon on 12/20/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    User mockUser = new User(1L,"wes");

    @Test
    public void addUserTest() throws Exception {
        Mockito.when(userService.add(Mockito.any(User.class))).thenReturn(mockUser);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .content("{}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

//    @Test
//    public void getAllUsersTest() throws Exception{
//        Mockito.when(userService.getAllUsers()).thenReturn(new ArrayList<>());
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/users")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect("[]");
//    }

}
