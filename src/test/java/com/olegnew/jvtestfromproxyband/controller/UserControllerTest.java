package com.olegnew.jvtestfromproxyband.controller;

import com.olegnew.jvtestfromproxyband.model.User;
import com.olegnew.jvtestfromproxyband.service.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;
    private static final String expected = "[{\"id\":\"63d64a35d84b0f45cc478993\"," +
            "\"name\":\"first\",\"email\":\"first@mail.net\"}]";
    private static final User testUser = new User();
    private static List<User> userList = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @BeforeAll
    public static void init(){
        testUser.setId("63d64a35d84b0f45cc478993");
        testUser.setName("first");
        testUser.setEmail("first@mail.net");
        userList.add(testUser);
    }

    @Test
    public void shouldReturnUserList() {
        Mockito.when(userService.finfAll()).thenReturn(userList);
        RestAssuredMockMvc
                .when()
                .get("/users/")
                .then()
                .statusCode(200)
                .body(Matchers.equalTo(expected));
    }
}
