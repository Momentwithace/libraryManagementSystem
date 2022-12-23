package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ReaderServiceImplTest {
    private RegisterResponse registerResponse;
    private RegisterRequest registerRequest;
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

        registerResponse = readerService.register(registerRequest);
    }
    @Test
    void registerReaderTest(){
        assertThat(registerResponse).isNotNull();
    }

}