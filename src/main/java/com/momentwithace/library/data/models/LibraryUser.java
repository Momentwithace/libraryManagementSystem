package com.momentwithace.library.data.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;

import java.util.HashSet;
import java.util.Set;

public class LibraryUser {
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();


}
