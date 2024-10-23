package com.register.Register.controller;

import com.register.Register.dtos.requests.RegisterRequest;
import com.register.Register.dtos.responses.ApiResponse;
import com.register.Register.dtos.responses.RegisterResponse;
import com.register.Register.model.User;
import com.register.Register.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/api/v1/media")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = userService.register(request);
        return new ResponseEntity<>(new ApiResponse(true, response), CREATED);
    }
}
