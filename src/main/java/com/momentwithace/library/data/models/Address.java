package com.momentwithace.library.data.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    private Long id;
    private String street;
    private String city;
    private int buildingNumber;
    private String state;
    private String country;
}
