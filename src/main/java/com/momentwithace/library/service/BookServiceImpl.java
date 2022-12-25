package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterBookRequest;
import com.momentwithace.library.data.dtos.response.DeleteBookResponse;
import com.momentwithace.library.data.dtos.response.RegisterBookResponse;
import com.momentwithace.library.data.models.Book;
import com.momentwithace.library.data.repository.BookRepository;
import com.momentwithace.library.exception.BookAlreadyExistException;
import com.momentwithace.library.exception.BookNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{
    private ModelMapper modelMapper;
    private final BookRepository bookRepository;
    @Override
    public RegisterBookResponse registerBook(RegisterBookRequest registerBookRequest) {
        Optional<Book> book = bookRepository.findBookByBookIsbn(registerBookRequest.getBookIsbn());
        if(book.isPresent())
            throw new BookAlreadyExistException("Book with "+registerBookRequest.getBookIsbn()+"already exist!");
        Book newBook = modelMapper.map(registerBookRequest, Book.class);
        Book savedBook = bookRepository.save(newBook);
        return new RegisterBookResponse("Book with isbn "+savedBook.getBookIsbn()+"successfully added!");
    }

    @Override
    public DeleteBookResponse deleteBookByBookIsbn(long bookIsbn) {
        Optional<Book> bookToDelete = bookRepository.findBookByBookIsbn(bookIsbn);
        if(bookToDelete.isEmpty())
            throw new BookNotFoundException("Book with "+bookIsbn+" not found!");
         bookRepository.delete(bookToDelete.get());
        return new DeleteBookResponse("Book deleted!");
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }

}
