package com.momentwithace.library.service;

import com.momentwithace.library.data.dtos.request.DeleteUserRequest;
import com.momentwithace.library.data.dtos.request.LoginRequest;
import com.momentwithace.library.data.dtos.request.RegisterRequest;
import com.momentwithace.library.data.dtos.request.UpdateUserDetails;
import com.momentwithace.library.data.dtos.response.DeleteResponse;
import com.momentwithace.library.data.dtos.response.LoginResponse;
import com.momentwithace.library.data.dtos.response.RegisterResponse;
import com.momentwithace.library.data.dtos.response.UpdateResponse;
import com.momentwithace.library.data.models.Address;
import com.momentwithace.library.data.models.Reader;
import com.momentwithace.library.data.repository.ReaderRepository;
import com.momentwithace.library.exception.LibrarySystemException;
import com.momentwithace.library.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReaderServiceImpl implements ReaderService{
    private ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ReaderRepository readerRepository;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) throws LibrarySystemException {
        Optional<Reader> reader = readerRepository.findByEmail(registerRequest.getEmail());
        if(reader.isPresent())
            throw new LibrarySystemException("Reader already exit");

        Reader newReader = modelMapper.map(registerRequest, Reader.class);
        String encodedPassword = bCryptPasswordEncoder.encode(newReader.getPassword());
        newReader.setPassword(encodedPassword);

        Reader savedReader = readerRepository.save(newReader);

        return new RegisterResponse("Reader with "+ savedReader.getFirstname()+" successfully registered!");
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<Reader> user = readerRepository.findByEmail(loginRequest.getEmail());
        if(user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword()))
            return LoginResponse.builder().message("User logged in successfully").build();

        return LoginResponse.builder().message("User with "+loginRequest.getEmail()+"Not found!").build();
    }

    @Override
    public void deleteAll() {
        readerRepository.deleteAll();
    }

    @Override
    public UpdateResponse updateProfile(UpdateUserDetails updateUserDetails) throws LibrarySystemException {
        Reader userToUpdate = readerRepository.findByEmail(updateUserDetails.getEmail()).orElseThrow(() ->
                new LibrarySystemException("User with "+updateUserDetails.getEmail()+ " Does not exist!"));

        Set<Address> userAddressSet = userToUpdate.getAddressSet();

        Optional<Address> foundAddress = userAddressSet.stream().findFirst();
        foundAddress.ifPresent(address -> applyAddressUpdate(address, updateUserDetails));
        readerRepository.save(userToUpdate);
        return UpdateResponse.builder()
                .message("User with "+updateUserDetails.getEmail()+"Account successfully updated!")
                .build();
    }

    private void applyAddressUpdate(Address address, UpdateUserDetails updateUserDetails) {
        address.setCity(updateUserDetails.getCity());
        address.setStreet(updateUserDetails.getStreet());
        address.setState(updateUserDetails.getState());
        address.setCountry(updateUserDetails.getCountry());

    }

    @Override
    public DeleteResponse deleteUser(String email) {
        Optional<Reader> userToDelete = readerRepository.findByEmail(email);
        if(userToDelete.isEmpty())
            throw new UserNotFoundException("User with "+email+" Does not exist!");
        readerRepository.delete(userToDelete.get());
        return DeleteResponse.builder()
                .message("User with "+userToDelete.getClass()+"Successfully deleted!")
                .build();
    }
}
