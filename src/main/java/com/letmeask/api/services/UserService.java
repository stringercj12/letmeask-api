package com.letmeask.api.services;

import com.letmeask.api.dtos.UserRequestDTO;
import com.letmeask.api.dtos.UserResponseDTO;
import com.letmeask.api.model.UserEntity;
import com.letmeask.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<UserResponseDTO> getUsersAlls() {
        var users = userRepository.findAll();

        return users.stream().map((user) ->
                new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getImageUrl(),
                        user.getCreatedAt())
        ).toList();
    }

    public UserEntity create(UserRequestDTO userRequestDTO) {
        this.userRepository.findByEmail(userRequestDTO.email()).orElseThrow(() -> new IllegalArgumentException("User not found"));


        UserEntity newUser = new UserEntity();
        newUser.setName(userRequestDTO.name());
        newUser.setEmail(userRequestDTO.email());
        newUser.setImageUrl("");

        var password = passwordEncoder.encode(userRequestDTO.password());
        newUser.setPassword(password);

        userRepository.save(newUser);

        return newUser;
    }

}
