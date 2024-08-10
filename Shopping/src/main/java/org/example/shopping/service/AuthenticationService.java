package org.example.shopping.service;

import org.example.shopping.dto.response.JwtAuthenticationResponse;
import org.example.shopping.dto.request.RefreshTokenRequest;
import org.example.shopping.dto.request.SignUpRequest;
import org.example.shopping.dto.request.SignInRequest;
import org.example.shopping.model.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
