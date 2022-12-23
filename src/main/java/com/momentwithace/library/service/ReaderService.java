package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface ReaderService {
    RegisterResponse register(RegisterRequest registerRequest);
}
