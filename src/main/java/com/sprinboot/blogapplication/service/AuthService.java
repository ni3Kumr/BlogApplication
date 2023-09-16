package com.sprinboot.blogapplication.service;

import com.sprinboot.blogapplication.payload.LoginDto;
import com.sprinboot.blogapplication.payload.RegisterDto;

public interface AuthService {

    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);

}
