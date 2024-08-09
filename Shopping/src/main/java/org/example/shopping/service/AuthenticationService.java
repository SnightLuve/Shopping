package org.example.shopping.service;

import org.example.shopping.dto.response.JwtAuthenticationResponse;
import org.example.shopping.dto.request.RefreshTokenRequest;
import org.example.shopping.dto.request.SignUpRequest;
import org.example.shopping.dto.request.SigninRequest;
import org.example.shopping.model.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
