package com.momentwithace.library.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Reader extends LibraryUser{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
