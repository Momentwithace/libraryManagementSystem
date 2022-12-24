package com.momentwithace.library.data.dtos.request;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUserDetails {
    private String email;
    private String phoneNumber;
    private String Street;
    private String city;
    private String state;
    private String country;
    private int buildingNumber;
}
