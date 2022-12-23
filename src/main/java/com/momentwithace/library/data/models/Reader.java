package com.momentwithace.library.data.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

public class Reader extends LibraryUser{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
