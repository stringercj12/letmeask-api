package com.letmeask.api.controller;

import com.letmeask.api.dtos.UserRequestDTO;
import com.letmeask.api.dtos.UserResponseDTO;
import com.letmeask.api.model.UserEntity;
import com.letmeask.api.repositories.UserRepository;
import com.letmeask.api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserResponseDTO>> getUsersAlls() {
        var users = this.userService.getUsersAlls();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> create(@RequestBody UserRequestDTO userRequestDTO) {
        UserEntity newUser = this.userService.create(userRequestDTO);
        return ResponseEntity.ok(newUser);
    }
}
