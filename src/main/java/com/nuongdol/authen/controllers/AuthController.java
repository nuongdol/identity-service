package com.nuongdol.authen.controllers;

import com.nuongdol.authen.request.ReqRes;
import com.nuongdol.authen.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ReqRes> login(@RequestBody ReqRes loginRequest) {
        ReqRes authResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(authResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<ReqRes> register(@RequestBody ReqRes registerRequest) {
        return ResponseEntity.ok(authService.register(registerRequest));
    }
}

