package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.ReaderRegistrationRequest;
import com.momentwithace.library.data.dtos.response.RegisterResponse;

public interface ReaderService {
    RegisterResponse register(ReaderRegistrationRequest readerRegistrationRequest);
}
