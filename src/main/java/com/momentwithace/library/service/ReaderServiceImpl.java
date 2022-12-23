package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import com.momentwithace.library.data.models.Reader;
import com.momentwithace.library.data.repository.ReaderRepository;
import com.momentwithace.library.exception.LibrarySystemException;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public class ReaderServiceImpl implements ReaderService{
    private ModelMapper modelMapper;

    private ReaderRepository readerRepository;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        Optional<Reader> reader = readerRepository.findByEmail(registerRequest.getEmail());
        if(reader.isPresent())
            throw new LibrarySystemException("Reader already exit");


        Reader newReader = modelMapper.map(registerRequest, Reader.class);

        return null;
    }
}
