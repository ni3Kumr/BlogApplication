package com.sprinboot.blogapplication.controller;

import com.sprinboot.blogapplication.payload.JwtAuthResponse;
import com.sprinboot.blogapplication.payload.LoginDto;
import com.sprinboot.blogapplication.payload.RegisterDto;
import com.sprinboot.blogapplication.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    private AuthService authService;
    @PostMapping(value={"/login","/signin"})
    public ResponseEntity<JwtAuthResponse> login (@RequestBody LoginDto loginDto){
       String token =  authService.login(loginDto);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }
    //build Register REST API;
    @PostMapping(value={"/register","/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
       String response =  authService.register(registerDto);
       return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
