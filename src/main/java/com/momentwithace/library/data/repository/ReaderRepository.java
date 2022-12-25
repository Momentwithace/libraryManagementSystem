package com.momentwithace.library.data.repository;

import com.momentwithace.library.data.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Optional<Reader> findByEmail(String email);

    void deleteByEmail(String email);
}
