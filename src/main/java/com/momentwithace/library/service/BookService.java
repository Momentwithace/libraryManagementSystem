package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterBookRequest;
import com.momentwithace.library.data.dtos.response.DeleteBookResponse;
import com.momentwithace.library.data.dtos.response.RegisterBookResponse;
import com.momentwithace.library.data.models.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookService {
    RegisterBookResponse registerBook(RegisterBookRequest registerBookRequest);

    DeleteBookResponse deleteBookByBookIsbn(long bookIsbn);

    void deleteAll();

    Optional<Book> getBookByBookIsbn(long bookIsbn);
}
