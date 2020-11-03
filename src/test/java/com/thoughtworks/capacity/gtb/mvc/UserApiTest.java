package com.thoughtworks.capacity.gtb.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserApiTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_create_user() throws Exception {
        User user = User.builder().username("xiaoming").password("123456").email("xiaoming@qq.com").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(user);
        mockMvc.perform(post("/register").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_get_user_when_username_and_password_match() throws Exception {
        mockMvc.perform(get("/login?username=xiaozhang&password=147258"))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.username",is("xiaozhang")))
                .andExpect(jsonPath("$.password",is("147258")))
                .andExpect(jsonPath("$.email",is("xiaozhang@qq.com")))
                .andExpect(status().isOk());
    }
}
