package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.LoginRequest;
import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.response.LoginResponse;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ReaderServiceImplTest {
    private RegisterResponse registerResponse;
    private LoginRequest loginRequest;
    @Autowired
    private ReaderService readerService;
    @BeforeEach
    void setUp(){
        RegisterRequest registerRequest = RegisterRequest.builder()
                .firstname("Ace")
                .lastname("Adeh")
                .email("ace@gmail.com")
                .password("12345")
                .build();

        loginRequest = LoginRequest.builder()
                .email("ace@gmail.com")
                .password("12345")
                .build();

        registerResponse = readerService.register(registerRequest);
    }

    @AfterEach
    void tearDown(){
        readerService.deleteAll();
    }

    @Test
    void registerUserTest(){
        assertThat(registerResponse).isNotNull();
    }

    @Test
    void loginUserTest(){
        LoginResponse loginResponse = readerService.login(loginRequest);
        assertThat(loginResponse).isNotNull();
    }
}