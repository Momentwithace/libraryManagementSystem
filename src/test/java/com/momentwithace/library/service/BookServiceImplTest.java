package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterBookRequest;
import com.momentwithace.library.data.dtos.response.DeleteBookResponse;
import com.momentwithace.library.data.dtos.response.RegisterBookResponse;
import com.momentwithace.library.data.models.Book;
import com.momentwithace.library.data.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BookServiceImplTest {
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;
    private RegisterBookResponse registerBookResponse;

    @BeforeEach
    void setUp() {
        RegisterBookRequest registerBookRequest = RegisterBookRequest.builder()
                .bookTitle("SpringBoot in Java")
                .BookIsbn(123456789L)
                .edition("2022")
                .bookAuthor("Micheal Boyo")
                .build();
        registerBookResponse = bookService.registerBook(registerBookRequest);
    }

    @AfterEach
    void tearDown() {
        bookService.deleteAll();
    }

    @Test
    void registerBook(){
        assertThat(registerBookResponse).isNotNull();
    }

    @Test
    void deleteBookTest(){
        DeleteBookResponse deleteBookResponse = bookService.deleteBookByBookIsbn(123456789L);
        assertThat(deleteBookResponse).isNotNull();
    }

    @Test
    void getBookTest(){
        Optional<Book> bookToGet = bookService.getBookByBookIsbn(123456789L);
        assertThat(bookToGet).isNotEmpty();
    }
}