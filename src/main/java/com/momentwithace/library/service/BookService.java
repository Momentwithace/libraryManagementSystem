package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterBookRequest;
import com.momentwithace.library.data.dtos.response.RegisterBookResponse;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    RegisterBookResponse registerBook(RegisterBookRequest registerBookRequest);

}
