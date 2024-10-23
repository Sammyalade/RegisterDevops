package com.register.Register.services;

import com.register.Register.dtos.requests.RegisterRequest;
import com.register.Register.dtos.responses.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
}
