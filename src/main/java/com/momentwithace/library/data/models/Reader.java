package com.momentwithace.library.data.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Reader extends LibraryUser{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
