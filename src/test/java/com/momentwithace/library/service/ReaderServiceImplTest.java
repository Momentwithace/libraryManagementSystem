package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReaderServiceImplTest {
    private ReaderService readerService;
    @BeforeEach
    void setUp(){

    }
    @Test
    void registerReaderTest(){
        RegisterRequest registerRequest = RegisterRequest.builder()
                .firstname("Ace")
                .lastname("Adeh")
                .email("ace@gmail.com")
                .password("12345")
                .build();

        RegisterResponse registerResponse = readerService.register(registerRequest);
    }

}