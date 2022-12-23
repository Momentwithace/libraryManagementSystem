package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import com.momentwithace.library.data.models.Reader;
import com.momentwithace.library.data.repository.ReaderRepository;
import com.momentwithace.library.exception.LibrarySystemException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ReaderServiceImpl implements ReaderService{
    private ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ReaderRepository readerRepository;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        Optional<Reader> reader = readerRepository.findByEmail(registerRequest.getEmail());
        if(reader.isPresent())
            throw new LibrarySystemException("Reader already exit");

        Reader newReader = modelMapper.map(registerRequest, Reader.class);
        String encodedPassword = bCryptPasswordEncoder.encode(newReader.getPassword());
        newReader.setPassword(encodedPassword);

        Reader savedReader = readerRepository.save(newReader);
        RegisterResponse registerResponse = new RegisterResponse("Reader with "+ savedReader.getFirstname()+" successfully registered!");

        return registerResponse;
    }
}
