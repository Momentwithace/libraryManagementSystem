package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.LoginRequest;
import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.request.UpdateUserDetails;
import com.momentwithace.library.data.dtos.response.DeleteResponse;
import com.momentwithace.library.data.dtos.response.LoginResponse;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import com.momentwithace.library.data.dtos.response.UpdateResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ReaderServiceImplTest {
    private RegisterResponse registerResponse;
    private UpdateResponse updateResponse;
    private RegisterRequest registerRequest;
    private LoginRequest loginRequest;
    @Autowired
    private ReaderService readerService;
    @BeforeEach
    void setUp(){
        registerRequest = RegisterRequest.builder()
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

    @Test
    void updateUserTest(){
        UpdateUserDetails updateUserDetails = UpdateUserDetails.builder()
                .email(registerRequest.getEmail())
                .buildingNumber(23)
                .city("yaba")
                .state("lagos")
                .country("nigeria")
                .phoneNumber("09035122225")
                .build();

        updateResponse = readerService.updateProfile(updateUserDetails);
        assertThat(updateUserDetails).isNotNull();
    }

    @Test
    void deleteUserTest(){
        DeleteResponse deleteResponse =
    }
}