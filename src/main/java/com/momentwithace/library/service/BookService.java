package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterBookRequest;
import com.momentwithace.library.data.dtos.response.RegisterBookResponse;

public interface BookService {
    RegisterBookResponse registerBook(RegisterBookRequest registerBookRequest);
}
