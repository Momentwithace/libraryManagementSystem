package com.momentwithace.library.data.dtos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterBookRequest {
    private String bookTitle;
    private String bookAuthor;
    private Long BookIsbn;
    private String edition;
}
