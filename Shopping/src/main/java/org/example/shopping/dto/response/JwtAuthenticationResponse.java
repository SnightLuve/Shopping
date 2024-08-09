package org.example.shopping.dto.response;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    String token;
    String refreshToken;
}
