package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.LoginRequest;
import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.request.UpdateUserDetails;
import com.momentwithace.library.data.dtos.response.LoginResponse;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import com.momentwithace.library.data.dtos.response.UpdateResponse;
import org.springframework.stereotype.Service;

@Service
public interface ReaderService {
    RegisterResponse register(RegisterRequest registerRequest);


    LoginResponse login(LoginRequest loginRequest);

    void deleteAll();

    UpdateResponse updateProfile(UpdateUserDetails updateUserDetails);
}
