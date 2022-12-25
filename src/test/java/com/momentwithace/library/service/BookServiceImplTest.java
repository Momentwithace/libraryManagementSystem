package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterBookRequest;
import com.momentwithace.library.data.dtos.response.RegisterBookResponse;
import com.momentwithace.library.data.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    private BookRepository bookRepository;
    private RegisterBookRequest registerBookRequest;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        registerBookRequest = RegisterBookRequest.builder()
                .bookTitle("SpringBoot in Java")
                .isbn(123456789L)
                .edition("2022")
                .bookAuthor("Micheal Boyo")
                .build();
    }

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
    }

    @Test
    void registerBook(){
        RegisterBookResponse registerBookResponse = bookService.registerBook(registerBookRequest);
    }
}