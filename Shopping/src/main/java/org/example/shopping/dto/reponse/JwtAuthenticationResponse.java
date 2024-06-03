package org.example.shopping.dto.reponse;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    String token;
    String refreshToken;
}
