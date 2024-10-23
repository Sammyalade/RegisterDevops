package com.register.Register.services;

import com.register.Register.dtos.requests.RegisterRequest;
import com.register.Register.dtos.responses.RegisterResponse;
import com.register.Register.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = modelMapper.map(request, User.class);
        return modelMapper.map(user, RegisterResponse.class);
    }
}
