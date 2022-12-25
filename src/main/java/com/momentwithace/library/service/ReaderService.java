package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.LoginRequest;
import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.request.UpdateUserDetails;
import com.momentwithace.library.data.dtos.response.DeleteResponse;
import com.momentwithace.library.data.dtos.response.LoginResponse;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import com.momentwithace.library.data.dtos.response.UpdateResponse;
import com.momentwithace.library.data.models.Reader;
import com.momentwithace.library.exception.LibrarySystemException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReaderService {
    RegisterResponse register(RegisterRequest registerRequest) throws LibrarySystemException;


    LoginResponse login(LoginRequest loginRequest);

    void deleteAll();

    UpdateResponse updateProfile(UpdateUserDetails updateUserDetails) throws LibrarySystemException;

    DeleteResponse deleteUser(String email);

    Optional<Reader> getUserByEmail(String email);
}
