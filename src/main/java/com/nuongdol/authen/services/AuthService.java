package com.nuongdol.authen.services;

import com.nuongdol.authen.repositories.UsersRepository;
import com.nuongdol.authen.request.ReqRes;
import com.nuongdol.authen.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsersRepository usersRepository;

    private final JwtUtils jwtUtils;
//    private final PasswordEncoder passwordEncoder;


    private final AuthenticationManager authenticationManager;

    public ReqRes login(ReqRes loginRequest) {
        ReqRes response = new ReqRes();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        var user = usersRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("user not exit!"));
        var jwt = jwtUtils.generateToken(user);
        var refreshToken = jwtUtils.generateRefresherToken(user);
        response.setAccessToken(jwt);
        response.setRefreshToken(refreshToken);
        return response;
    }

    public ReqRes register(ReqRes registerRequest) {
        return null;
    }
}
