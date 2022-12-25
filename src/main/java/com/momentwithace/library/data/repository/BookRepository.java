package com.momentwithace.library.data.repository;

import com.momentwithace.library.data.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByBookIsbn(Long bookIsbn);
}
