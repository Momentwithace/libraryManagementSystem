package com.momentwithace.library.data.repository;

import com.momentwithace.library.data.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
