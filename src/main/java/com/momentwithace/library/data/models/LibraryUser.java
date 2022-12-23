package com.momentwithace.library.data.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibraryUser {
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();


}
