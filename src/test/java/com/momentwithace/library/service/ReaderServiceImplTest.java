package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.DeleteUserRequest;
import com.momentwithace.library.data.dtos.request.LoginRequest;
import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.request.UpdateUserDetails;
import com.momentwithace.library.data.dtos.response.DeleteResponse;
import com.momentwithace.library.data.dtos.response.LoginResponse;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import com.momentwithace.library.data.dtos.response.UpdateResponse;
import com.momentwithace.library.exception.LibrarySystemException;
import lombok.var;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ReaderServiceImplTest {
    private RegisterResponse registerResponse;
    private RegisterRequest registerRequest;
    private DeleteUserRequest deleteUserRequest;
    private LoginRequest loginRequest;
    @Autowired
    private ReaderService readerService;
    @BeforeEach
    void setUp() throws LibrarySystemException {
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
    void updateUserTest() throws LibrarySystemException {
        UpdateUserDetails updateUserDetails = UpdateUserDetails.builder()
                .email(registerRequest.getEmail())
                .buildingNumber(23)
                .city("yaba")
                .state("lagos")
                .country("nigeria")
                .phoneNumber("09035122225")
                .build();

        UpdateResponse updateResponse = readerService.updateProfile(updateUserDetails);
        assertThat(updateResponse).isNotNull();
    }

    @Test
    void deleteUserTest(){
        DeleteResponse deleteResponse = readerService.deleteUser("ace@gmail.com");
        assertThat(deleteResponse).isNotNull();
    }

    @Test
    void getUserByEmailTest(){
        var foundUser = readerService.getUserByEmail("ace@gmail.com");
    }

//    @Test
//    void getBookByIsbnTest(){
//        bookService.registerBook(registerBook);
//        var foundBook = bookService.getBookByIsbn(123456789L);
//        assertThat(foundBook).isNotNull();
}